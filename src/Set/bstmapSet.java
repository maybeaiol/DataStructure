package Set;
import Map.BSTMap;

public class bstmapSet<K extends Comparable<K>> {
	BSTMap<K, Integer>  bstMap;
	public bstmapSet() {
		bstMap=new BSTMap<>();
	}
	public void add(K k) {
		bstMap.add(k, 0);
	}
	public  void remove(K k) {
		bstMap.remove(k);
	}
	public boolean contains(K k) {
		return bstMap.contains(k);
	}
	public int getSize() {
		return bstMap.getSize();
	}
	public boolean isEmpty() {
		return bstMap.isEmpty();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		bstMap.setOrder();
		return "";
	}

}
