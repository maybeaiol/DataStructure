package Set;

public class mapSetdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bstmapSet<Integer> bstSet=new bstmapSet<Integer>();
		bstSet.add(1);
		bstSet.add(2);
		bstSet.add(3);
		bstSet.add(4);
		bstSet.add(5);
		bstSet.remove(2);
		bstSet.toString();
		System.out.println("size:"+ bstSet.getSize());
	}

}
