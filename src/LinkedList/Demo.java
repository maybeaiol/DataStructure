package LinkedList;

public class Demo {

	public static void main(String[] args) throws Exception {
		Linkedlist<Integer> linkedlist=new Linkedlist<>();
		for(int i=0;i<5;i++) {
			linkedlist.inserthead(i);
			System.out.println(linkedlist);
		}
		linkedlist.insert(666, 2);
		System.out.println(linkedlist);
		linkedlist.deleteFirst();
		System.out.println(linkedlist);
		linkedlist.deletelast();
		System.out.println(linkedlist);
	}

}
