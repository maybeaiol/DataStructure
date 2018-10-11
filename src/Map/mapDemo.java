package Map;

public class mapDemo {

	public static void main(String[] args) {
		LinkedlistMap<Integer, String> map = new LinkedlistMap<Integer, String>();
		map.add(1, "liu");
		map.add(2, "zhang");
		map.add(3, "wang");
		map.remove(2);
		String value=map.get(3);
		map.set(1, "lu");
		System.out.println(value);
		System.out.println(map.getSize());
		System.out.println(map.contains(1));
		System.out.println(map);

	}

}
