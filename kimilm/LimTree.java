package kimilm;

public interface LimTree<T> {
	// 트리는 또 무슨 기능이 있을까
	// 계산기에 트리를 사용하려면
	// 트리? 스택? 스택 계산기..?
	// 연산기호를 루트로 하고 숫자는 아래로 배치?
	// 중위식을 후위식으로? 자료구조 시간에 배웠던것 같은데
	// 중복은 허용해야 할 듯
	
	// 추가
	public void add(T value);
	
	// 삭제
	public void delete(T value);
	
	//클린
	public void clean();
	
	// 복사 -> 생성자에서 지원
//	public LimTree<T> copy();
	
	// 찾기
	// 추가 삭제시 값이 있나 없나도 보고싶은데 지난번에 해보니까 코드도 길어지고 수식이 꼬였다 
	// 해시테이블을 쓸 수 있을까? 해시테이블을 두면 그게 해시지 트리가 아니지 않나....
	// 해시는 검색만 되니까 같이 사용하는것도 괜찮지 않나?
	// 해시를 좀 더 공부할 것
	// 아니지, 인덱스도 아니고 값을 넣어서 값을 왜 찾아..?
//	public T get(T value);
//	public boolean get(T value);
	
	// 노드를 찾아서 그걸 쓸 일도 있겠다 -> 이건 Tree class 내부에서 private으로 구현하는게 나을듯
//	public TreeNode<T> getNode(T value);
	
	// value를 기점으로 분할 -> 트리가 0, 1, 2개로 분할되겠네.. 리턴을 어떻게?
	// value를 루트로 하는 트리를 리턴하면 되곘다
	public LimTree<T> divide(T value);
	
	// 비교
	public boolean equal(LimTree<T> tree);
	
//	// 출력
	public String toString();
//	
//	//비어있는가
//	public boolean isEmpty();
//	
//	//원소 개수?
//	public int size();
}
