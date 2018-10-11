package Stack;

public class Demosatck {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedlistStack<Integer> arrayStack=new LinkedlistStack<Integer>();
		arrayStack.push(1);
		arrayStack.push(2);
		arrayStack.push(3);
		arrayStack.push(4);
		arrayStack.pop();
		//arrayStack.pop();
		System.out.println(arrayStack.peek());
		System.out.println(arrayStack.isEmpty());
		System.out.println(arrayStack.getSize());
		
		System.out.print(arrayStack);
		
	}

}
