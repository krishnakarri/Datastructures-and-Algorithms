import java.lang.reflect.Array;
import java.util.Arrays;


public class SegmentTree {

	
	private int array[];
	
	public SegmentTree(int length) {
		
		int n = (int)Math.ceil(Math.log(length)/Math.log(2));
		
		int noOfNodes = 2*(int)Math.pow(2, n)-1;
		
		array = new int[noOfNodes];
		
		System.out.println("No of nodes is "+noOfNodes);
	}
	
	/* 
	 * Utility to build segement Tree 
	 */
	private int constructSTUtil(int arr[],int s,int l,int index){
		
		if(l==s){
			array[index] = arr[s];
			return array[index];
		}
		int mid = s+((l-s)/2);
	//	System.out.println(mid);
		
		int left = constructSTUtil(arr,s,mid,2*index+1);
		int right = constructSTUtil(arr,mid+1,l,2*index+2);
		
		array[index] = left+right;
		
		return array[index];
		
	}
	
	/* 
	 * Construct segment tree 
	 */
	public void constructSegmentTree(int arr[]) {
		
		int l = arr.length;
		
		constructSTUtil(arr,0,l-1,0);
		
	}
	
	private int queryST(int ss,int se,int qs, int qe,int index){
		
		if(qs<=ss && se<=qe)
			return array[index];
		if(qe<ss || se <qs)
			return 0;
		
		int mid = ss+((se-ss)/2);
		int left = queryST(ss, mid, qs, qe, 2*index+1);
		int right = queryST(mid+1,se,qs,qe,2*index+2);
		return left+right;
	}
	
	public int query(int arr[],int s,int l){
		int n = arr.length-1;
		return queryST(0,n,s,l,0);
	}
	
	
	private int updateST(int ss,int se, int index, int val, int sind){
		
		if(index < ss || index > se)
			return 0;
		
		if(ss == se){
			int diff =  val - array[sind];
			array[sind] = val;
			System.out.println("diff is"+diff);
			return diff;
		}
		
		int mid = ss+((se-ss)/2);
		
		int l = updateST(ss, mid, index, val, 2*sind+1);
		int r = updateST(mid+1, se, index, val, 2*sind+2);
		int diff = array[sind];
		array[sind] = array[sind]+l+r;
		return array[sind]-diff;		
	}
	public void update(int arr[],int val, int index){
		int l = arr.length-1;
		updateST(0,l,index,val,0);
	}
	public void printArrayElements(){
		
		System.out.println(Arrays.toString(array));
	}
}
