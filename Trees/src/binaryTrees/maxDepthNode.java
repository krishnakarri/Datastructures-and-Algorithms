package binaryTrees;


/* Finding a node at a maximum depth in
 * a binary tree
 */
public class maxDepthNode {
	
	static int maxlevel = -1;
	static BinaryNode deepestNode = null;
	public static void findDeepestNode(BinaryNode root, int level){
		
		if(root!=null) {
			if(level>maxlevel){
				
				maxlevel = level;
				deepestNode = root;
			}
			findDeepestNode(root.left, level+1);
			findDeepestNode(root.right, level+1);
			
		}
		
	}
	
	
	public static void main(String[] args){
		
		BinaryNode n = new BinaryNode(1);
		n.left = new BinaryNode(2);
		n.right = new BinaryNode(3);
		n.left.left = new BinaryNode(4);
		n.left.right = new BinaryNode(5);
		n.right.left = new BinaryNode(6);
		n.right.right = new BinaryNode(7);
		n.right.right.right = new BinaryNode(8);
		
		findDeepestNode(n, 0);
		System.out.println("The deepest Node is "+ deepestNode.data);
		System.out.println("The depth is "+maxlevel);
	}
}
