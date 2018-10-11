package Arraylist;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Integer> casure=new ArrayList<>();
		//casure.insert(3, 0);
		for(int i=0;i<casure.getCap();i++) {
			casure.insert(i, i);
		}
		casure.insertlast(10);
		casure.delete(0);
		casure.insertlast(66);
		for(int i=0;i<casure.getSize();i++) {
			System.out.print(casure.getEle(i)+"  ");
		}
	}

}
