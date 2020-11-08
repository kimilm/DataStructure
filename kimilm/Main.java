package kimilm;

import java.util.Arrays;

public class Main {
	public static void main (String [] args) {
		listTest();
		System.out.println("");
		stackTest();
		System.out.println("");
		queueTest();
		System.out.println("");
		treeTest();
		System.out.println("");
		calculatorTest();
	}
	
	public static void listTest() {
		LimList<Integer> list = new LimListImpl<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(new Integer[] {4, 5, 6});
		System.out.println("list:\t" + list);
		
		//toArray()
		Integer [] intArray = list.toArray();
		
		System.out.println("list.tostring:\t" + Arrays.toString(list.toArray()));
		System.out.println("to int array:\t" + Arrays.toString(intArray));
		
		//list 복사
		LimList<Integer> list2 = new LimListImpl<>(list);
		System.out.println("copy list -> list2:\t" + list2);
		
		//delete();
		list.delete(6);
		System.out.println("delete 6 in list");
		System.out.println("list:\t" + list + "\t\tlength: " +list.length());
		System.out.println("list2:\t" + list2 + "\tlength: " +list2.length());
		
		//add after delete();
		list.add(6);
		System.out.println("add 6 in list");
		System.out.println("list:\t" + list + "\tlength: " +list.length());
		System.out.println("list2:\t" + list2 + "\tlength: " +list2.length());
		
		//removeAll()
		list2.removeAll();
		list2.add(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		
		///toArray(start, end);
		System.out.println("clear and add to list2: " + list2);
		intArray = list2.toArray(0, 9);
		System.out.println("to array 0-9 intArray:\t " + Arrays.toString(intArray) + " length: " + intArray.length);
		intArray = list2.toArray(10, 19);
		System.out.println("to array 10-19 intArray: " + Arrays.toString(intArray) + " length: " + intArray.length);
		
		//sort();
		list2.removeAll();
		list2.add(new Integer[] {6, 5, 4, 7, 1, 3, 2});
		System.out.println("before sort: "+ list2);
		list2.sort();
		System.out.println("after sort: "+ list2);
		
		//equal();
		System.out.println("list: " + list + " list2: " + list2 + " equal: " + list.equal(list2));
		list2.removeAll();
		list2.add(list);
		System.out.println("list: " + list + " list2: " + list2 + " equal: " + list.equal(list2));
		
		//divide(start);
		list2.removeAll();
		list2 = list.divide(3);
		System.out.println("devide list 3-)  list: " + list + "\tlist2: " + list2);

		//divide(start, end);
		list2.removeAll();
		list2 = list.divide(2, 4);
		System.out.println("devide list 2-4) list: " + list + "\tlist2: " + list2);
		
		list.removeAll();
		list2.removeAll();
	}
	
	public static void stackTest() {
		QnSTK<Integer> stack = new STK<>();
		
		System.out.println("print stack before add: " + stack);
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println("print stack after add:  " + stack);
		
		System.out.println("pop: " + stack.pop());
		System.out.println("pop: " + stack.pop());
		
		System.out.println("print stack: " + stack);
		
		System.out.println("door: " + stack.door());
		
		System.out.println("print stack: " + stack);
		
		stack.clean();
		
		System.out.println("print stack after clean: " + stack);
	}
	
	public static void queueTest() {
		QnSTK<Integer> q = new Q<>();
		
		System.out.println("print queue before add: " + q);
		
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		q.push(5);
		
		System.out.println("print queue after add:  " + q);
		
		System.out.println("pop: " + q.pop());
		System.out.println("pop: " + q.pop());
		
		System.out.println("print queue: " + q);
		
		System.out.println("door: " + q.door());
		
		System.out.println("print queue: " + q);
		
		q.clean();
		
		System.out.println("print queue after clean: " + q);
	}
	
	public static void treeTest() {
		LimTree<Integer> tree = new LimTreeImpl<Integer>();
		
		System.out.println("tree input:\t4 3 6 1 2 5 7");

		tree.add(4);
		tree.add(3);
		tree.add(6);
		tree.add(1);
		tree.add(2);
		tree.add(5);
		tree.add(7);
		
		System.out.println("print tree:\t" + tree);
		
		tree.delete(6);
		
		System.out.println("delete 6:\t" + tree);
		
		tree.add(6);
		
		System.out.println("add 6:\t\t" + tree);
	}
	
	public static void calculatorTest() {
		StackCalculator calculator = new StackCalculatorImpl();
		
		String equation = "1+(2+4/2)*2-3";

		System.out.println("infix: " + equation);
		System.out.println("postfix: " + calculator.inToPost(equation));
		System.out.println("result: " + calculator.calculate(equation));
	}
}
