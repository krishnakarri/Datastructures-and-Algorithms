
public class TestSegmentTree {

	
	
	public static void main(String[] args){
		
		int array[] = {2,3,5,6,7,8,9,10,11,12};
		SegmentTree st = new SegmentTree(array.length);
		//st.printArrayElements();
		st.constructSegmentTree(array);
		st.printArrayElements();
		System.out.println(st.query(array, 3, 9));
		st.update(array,8,3);
		st.printArrayElements();
	}
}
