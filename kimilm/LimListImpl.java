package kimilm;

import java.lang.reflect.Array;

public class LimListImpl<T> implements LimList<T> {
	Node<T> root;
	Node<T> end;
	int count;
	
	public LimListImpl() {
		root = null;
		end = null;
		count = 0;
	}
	
	public LimListImpl(LimList<T> list) {
		this();
		this.add(list);
	}

	@Override
	public void add(T value) {
		if(count == 0) {
			root = new Node<T>(value);
			end = root;
			++count;
		}
		else {
			end.setNext(new Node<T>(value));
			end = end.getNext();
			++count;
		}
	}

	@Override
	public void add(T[] value) {
 	 	for(int i = 0; i < value.length; ++i) {
 	 		add(value[i]);
 	 	}
	}

	@Override
	public void add(LimList<T> list) {
		add(list.toArray());
	}

	@Override
	public void delete(T value) {
		if(count == 0)
			return;
		
		if(root.getValue() == value) {
			root = root.getNext();
			--count;
		} 
		else {
			Node<T> parent = root;
			Node<T> deleteNode = root.getNext();

			while (deleteNode != null) {
				if (deleteNode.getValue() == value) {
					parent.setNext(deleteNode.getNext());
					
					if(deleteNode.getNext() == null)
						end = parent;
					else
						deleteNode.setNext(null);
					
					--count;
					break;
				}
				parent = deleteNode;
				deleteNode = deleteNode.getNext();
			}
		}
	}

	@Override
	public void delete(T[] value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void removeAll() {
		while(root != null)
			root = root.getNext();
		
		end = null;
		count = 0;
	}

	@Override
	public LimList<T> divide(int start) {
		return divide(start, count - 1);
	}
	
	@Override
	public LimList<T> divide(int start, int end) {
		if(start < 0 || start > count || start > end || end >= count)
			return null;
		
		LimListImpl<T> temp = new LimListImpl<T>(this);
		
		for(int i = ++end; i < count; ++i) {
			temp.delete(temp.get(end));
		}
		
		for(int i = 0; i < start; ++i) {
			temp.delete(temp.get(0));
		}
		
		return temp;
	}

	@Override
	public boolean isEmpty() {
		return count != 0;
	}

	@Override
	public int length() {
		return count;
	}
	
	/*----version 01----*/
//	@Override
//	public String toString() {
//		String [] str = new String[count];
//		Node<T> temp = root;
//		
//		for(int i = 0; i < count; ++i) {
//			str[i] = String.valueOf(temp.getValue());
//			
//			temp = temp.getNext();
//		}
//		
//		return Arrays.toString(str);
//	}
	
	/*----version 02----*/
	@Override
	public String toString() {
		return root.toString();
	}

	@Override
	public T get(int index) {
		Node<T> temp = root;
		
		for(int i = 0; i < index; ++i)
			temp = temp.getNext();
		
		return temp.getValue();
	}
	
	/*    생성자에서 동일한 기능 제공    */
//	@Override
//	public void copy(LimList<T> list) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void copy(T[] list) {
//		// TODO Auto-generated method stub
//	}

	/*    boolean으로 변겅할 것    */
	@Override
	public boolean equal(LimList<T> list) {
		if(count != list.length())
			return false;
		
		T[] arr = list.toArray();
		T[] thisArr = this.toArray();
		
		for(int i = 0; i < count; ++i) {
			if(!thisArr[i].equals(arr[i])) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void sort() {
		bubbleSort();
	}
	
	private void bubbleSort() {
		Node<T> temp = root;
		int re = count - 1;
		
		for(int i = 0; i < count - 1; ++i) {
			for(int j = 0; j < re; ++j) {
				if(temp.getValue().toString().compareTo(temp.getNext().getValue().toString()) > 0) {
					T val = temp.getValue();
					temp.setValue(temp.getNext().getValue());
					temp.getNext().setValue(val);
				}
				temp = temp.getNext();
			}
			--re;
			temp = root;
		}
	}

	/* 요거슨 타입캐스트가 안 된다! */
//	@Override
//	public T[] toArray() {
//		T [] arr = (T[]) new Object[count];
//		
//		Node<T> temp = root;
//		
//		for(int i = 0; i < count; ++i) {
//			arr[i] = temp.getValue();
//			
//			temp = temp.getNext();
//		}
//		
//		return arr;
//	}
	
	/* 요건 된다 */
//	@Override
//	public T[] toArray() {
//		@SuppressWarnings("unchecked")
//		T [] arr = (T[]) Array.newInstance(root.getValue().getClass(), count);
//		
//		Node<T> temp = root;
//		
//		for(int i = 0; i < count; ++i) {
//			arr[i] = temp.getValue();
//			
//			temp = temp.getNext();
//		}
//		
//		return arr;
//	}
	
	/*  중복된 코드를 줄여보자  */
	@Override
	public T[] toArray() {
		return toArray(0, count - 1);
	}

	/*  start, end의 입력은 배열 인덱스와 동일하게 처리  */
	/*  int [] arr = new int[6] -> 0 ~ 5의 인덱스 사용 가능  */
	@Override
	public T[] toArray(int start, int end) {
		if(start < 0 || start > count || start > end || end >= count)
			return null;
		
		int size = end - start + 1;
//		T [] arr = (T[]) new Object[end - start + 1];
		@SuppressWarnings("unchecked")
		T [] arr = (T[]) Array.newInstance(root.getValue().getClass(), size);
		
		Node<T> temp = root;
		
		for(int i = 0; i < start; ++i)
			temp = temp.getNext();
		
		for(int i = 0; i < size; ++i) {
			arr[i] = temp.getValue();
			
			temp = temp.getNext();
		}
			
		return arr;
	}
}
