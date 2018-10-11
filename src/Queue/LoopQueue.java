package Queue;
//循环队列,解决出栈O(n)的时间复杂度
public class LoopQueue<E> implements Queue<E>{
	private E[] elem;
	private int  tail,front;
	private  int size;
	public LoopQueue(int capcity) {
		elem=(E[]) new Object[capcity+1];
		tail=front=0;
		// TODO Auto-generated constructor stub
	}
	public LoopQueue() {
		this(5);
	}
	public int Getcapcity() {
		return elem.length-1;
	}
	@Override
	public void enqueue(E evalue) {
		if(((tail+1)%elem.length)==front) {
			resize(Getcapcity()*2);
		}
		elem[tail]=evalue;
		tail=(tail+1)%elem.length;
		size++;
	}
	@Override
	public E dequeue() {
		if(isEmpty()) {
			try {
				throw new Exception("没有元素");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		E value=elem[front];
		elem[front]=null;
		front=(front+1)%elem.length;
		size--;
		if(size==Getcapcity()/4)
				resize(Getcapcity()/2);
		return value;
	}
	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			try {
				throw new Exception("没有元素");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return elem[front];
	}
	@Override
	public int Getsize() {
		// TODO Auto-generated method stub
		return size;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return tail==front;
	}
	private void resize(int newcapacity) {
		E[] newelem=(E[]) new Object[newcapacity+1];
		for(int i=0;i<elem.length;i++) {
			newelem[i]=elem[(i+front)%elem.length];
		}
		elem=newelem;
		front=0;
		tail=size;
	}
	
	@Override
	public String toString() {
		StringBuilder sBuilder=new StringBuilder();
		sBuilder.append(String.format("Queue:size=%d,capcity=%d\n",size,Getcapcity()));
		sBuilder.append("front [");
		for(int i=front;i!=tail;i=(i+1)%elem.length) {
			try {
				sBuilder.append(elem[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if((i+1)%elem.length!=tail) {
				sBuilder.append(", ");
			}
			
		}
		sBuilder.append("] tali");
		return sBuilder.toString();
	}
	

}
