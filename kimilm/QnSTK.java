package kimilm;

public interface QnSTK<T> {
	//큐와 스탴에는 어떤 기능이 있을가
	
	//푸시푸시 베이베
	public void push(T value);
	//팦!
	public T pop();
	//이번에 팦 되는 원소는 무엇?
	public T door();
	//비어있는지 궁금할 수도 있징
	public boolean isEmpty();
	//길이를 알고싶을 수도 있찡
	public int length();
	
	public void clean();
	
	public String toString();
}
