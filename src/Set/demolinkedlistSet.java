package Set;

public class demolinkedlistSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedlistSet<Integer> linkedlistSet=new LinkedlistSet<Integer>();
		linkedlistSet.add(1);
		linkedlistSet.add(2);
		linkedlistSet.add(2);
		linkedlistSet.remove(2);
		linkedlistSet.add(3);
		System.out.println(linkedlistSet);
		

	}

}
