package kimilm;

public class Q<T> implements QnSTK<T> {
	private Node<T> head;
	private Node<T> tail;
	private int count;
	
	public Q() {
		head = null;
		tail = null;
		count = 0;
	}
	
	@Override
	public void push(T value) {
		Node<T> temp = new Node<T>(value);
		
		if(head == null)
			head = temp;
		else
			tail.setNext(temp);
		
		++count;
		
		tail = temp;
		temp = null;
	}

	@Override
	public T pop() {
		if(count == 0) {
			return null;
		}
		
		T value = head.getValue();
		
		head = head.getNext();
		
		if(count == 1)
			tail = head;
			
		--count;
		
		return value;
	}

	@Override
	public T door() {
		return head.getValue();
	}

	@Override
	public boolean isEmpty() {
		return count != 0;
	}
	
	@Override
	public int length() {
		return count;
	}
	
	@Override
	public void clean() {
		while(head != null)
			head = head.getNext();
		
		tail = null;
		count = 0;
	}
	
	@Override
	public String toString() {
		return head == null ? null : head.toString();
	}
}
