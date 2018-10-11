package Stack;

public interface stack<E> {
	void push(E e);
	E pop() ;
	E peek();
	int getSize();
	boolean isEmpty();

}
