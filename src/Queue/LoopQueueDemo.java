package Queue;

public class LoopQueueDemo {

	public static void main(String[] args) {
		LoopQueue< Integer> lQueue=new LoopQueue<Integer>();
		for(int i=0;i<10;i++) {
			lQueue.enqueue(i);
		}
		lQueue.dequeue();
		System.out.println(lQueue);

	}

}
