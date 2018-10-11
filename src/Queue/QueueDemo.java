package Queue;

import LinkedList.Linkedlist;

public class QueueDemo {

	public static void main(String[] args) {
		LinkedlistQueue<Integer> queue = new LinkedlistQueue<Integer>();
		for(int i=0;i<10;i++) {
			queue.enqueue(i);
			System.out.println(queue.toString());
			if(i%3==2) {
				queue.dequeue();
				System.out.println(queue.toString());
			}
		}
	}

}
