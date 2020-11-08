package kimilm;

public interface StackCalculator {
	//우선순위 리턴
//	private int order(char operator);
	//중위식 입력받기
	public int calculate (String in);
	
	//중위식을 후위식으로 변환
	public String inToPost(String in);
	
	
}
