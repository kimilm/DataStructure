package kimilm;

public interface QnSTK<T> {
	//큐와 스탴에는 어떤 기능이 있을가
	
	public void push(T value);
	public T pop();
	// 맨 앞의 원소 확인
	public T door();
	//비어있는가
	public boolean isEmpty();
	//길이
	public int length();
	
	public void clean();
	
	public String toString();
}
