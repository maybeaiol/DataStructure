package Queue;

public interface Queue<E> {
 void enqueue(E evalue);
 E dequeue();
 E getFront();//看队首的元素
 int Getsize();
 boolean isEmpty();
}
