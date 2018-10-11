package Map;

public class bstMapdemo {

	public static void main(String[] args) {
		BSTMap<Integer, String> bstMap=new BSTMap<Integer, String>();
		bstMap.add(1, "zhao");
		bstMap.add(2, "qian");
		bstMap.add(3, "sun");		
		bstMap.add(4, "li");
		bstMap.add(5, "zhou");
		bstMap.add(6, "wu");
		bstMap.add(7, "zheng");
		bstMap.add(8, "wang");
		bstMap.remove(3);
		bstMap.remove(5);
		bstMap.preOrder();
		System.out.println(bstMap.getSize());
	}

}
