package Queue;
//优先队列
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
	MaxHeap<E> maxHeap;
	public PriorityQueue() {
		maxHeap=new MaxHeap<>();
	}
	@Override
	public void enqueue(E evalue) {
		maxHeap.add(evalue);
	}

	@Override
	public E dequeue() {
		return maxHeap.extractMax();
	}

	@Override
	public E getFront() {
		return maxHeap.findMax();
	}

	@Override
	public int Getsize() {
		return maxHeap.getSize();
	}

	@Override
	public boolean isEmpty() {
		return maxHeap.isEmpty();
	}

}
