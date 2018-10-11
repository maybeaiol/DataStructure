package bsTree;

public class demoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<Integer> bst=new BST<Integer>();
		bst.insert(12);
		bst.insert(8);
		bst.insert(6);
		bst.insert(9);
		bst.insert(14);
		
	//	System.out.println(bst.toString());
//		bst.preOrder();
//		
//		bst.preOrderNR();
		bst.preOrder();
		System.out.println("================");
		
		
	

	}

}
