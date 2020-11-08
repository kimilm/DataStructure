package kimilm;

//Must be Generic
public class Node<T> {
	private Node<T> next;
	private T value;
	
	public Node() {
		next = null;
		value = null;
	}
	
	public Node(T value) {
		next = null;
		this.value = value;
	}
	
	public Node(Node<T> next, T value) {
		this.next = next;
		this.value = value;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	/*----for version2 LimListImpl.toString()----*/
//	public String toString() {
//		return next != null ? String.valueOf(value) + ", " + next.toString() : String.valueOf(value);
//	}
	
	/*----non-recursive for better performance----*/
	public String toString() {	
		StringBuffer buf = new StringBuffer(String.valueOf(value));
		Node<T> temp = next;
		
		while(temp != null) {
			buf.append(", ");
			buf.append(temp.getValue());
			
			temp = temp.getNext();
		}
		
		return buf.toString();
	}
}
