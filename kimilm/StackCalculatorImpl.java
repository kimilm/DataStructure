package kimilm;

public class StackCalculatorImpl implements StackCalculator {
	private STK<Character> stack;
	private int curOrder;
	private int flag;	
	
	public StackCalculatorImpl() {
		stack = new STK<>();
		curOrder = 0;
		flag = 0;
	}
	
	@Override
	public int calculate(String in) {
		StringBuffer buf = new StringBuffer(inToPost(in));
		char token;
		int calculate = 0;
		int a;
		int b;
		
		while(buf.length() != 0) {
			token = buf.charAt(0);
			buf.deleteCharAt(0);
			
			if(order(token) == 0)
				stack.push(token);
			else {
				a = Character.getNumericValue(stack.pop());
				b = Character.getNumericValue(stack.pop());
				
				switch(token) {
				case '+':
					calculate = b + a;
					break;
				case '-':
					calculate = b - a;
					break;
				case '*':
					calculate = b * a;
					break;
				case '/':
					calculate = b / a;
					break;
				}
				stack.push(Character.forDigit(calculate, 10));
			}
		}
		
		calculate = Character.getNumericValue(stack.pop());
		
		return calculate;
	}
	
	private int order(char operator) {
		switch(operator) {
		case '*':
		case '/':
			return 3;
		case '+':
		case '-':
			return 2;
		case '(':
		case ')':
			return 1;
		default:
			return 0;
		}
	}
	
	@Override
	public String inToPost(String in) {
		StringBuffer equation = new StringBuffer(in);
		StringBuffer post = new StringBuffer();
		char token;
		int operatorOrder;
		
		while(equation.length() != 0) {
			token = equation.charAt(0);
			equation.deleteCharAt(0);
			
			operatorOrder = order(token);
			
			if (operatorOrder == 0) {
				post.append(token);
			}
			else if (operatorOrder == 1) {
				if(flag == 0) {
					flag = 1;
					stack.push(token);
				}
				else {
					flag = 0;
					while(stack.door() != '(')
						post.append(stack.pop());
					
					stack.pop();
				}	
			}
			else {		
				if(operatorOrder < curOrder) {
					while(stack.isEmpty())
						post.append(stack.pop());
				}
				stack.push(token);
				
				curOrder = operatorOrder;
			}
		}
		
		while(stack.isEmpty())
			post.append(stack.pop());
		
		return post.toString();
	}
}
