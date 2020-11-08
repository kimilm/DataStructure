package kimilm;

public interface LimList<T> {
	//리스트의 기능엔 무엇이 있을까?
	//삽입 (첫 번째 삽입, 마지막에 삽입, 여러 개 삽입, 다른 리스트 삽입 등)
	public void add(T value);
	public void add(T[] value);
	public void add(LimList<T> list);
	
	//삭제 (첫 번째 삭제, 마지막 삭제, 여러 개 삭제, 지정하여 삭제 등)
	public void delete(T value);
	public void delete(T[] value);
	
	public void removeAll();
	
	//분할
	public LimList<T> divide(int start);
	public LimList<T> divide(int start, int end);
	
	//비어있는가 (비어있는지 궁금할 수도 있을 듯)
	public boolean isEmpty();
	
	//원소가 몇 개나 들어있나 (원소가 몇 개나 들어있는지 궁금할 수도 있겠다)
	public int length();
	
	//출력 (전체 출력, 범위 출력)
	public String toString();
	
	//i번째 원소는?
	public T get(int index);
	
	//클론 (전체 클론, 범위 클론)	생성자에서 동일한 기능제공
//	public void copy(LimList<T> list);
//	public void copy(T[] list);
	
	//비교
	public boolean equal(LimList<T> list);
	
	//정렬 (퀵 정렬...을 하고싶었으나..!)
	public void sort();
	
	//배열로 반환
	public T[] toArray();
	public T[] toArray(int start, int end);
	
	//정도
}
