package kimilm;


public class LimTreeImpl<T extends Comparable<T>> implements LimTree<T> {
	private TreeNode<T> root;
//	private int count;
	
	public LimTreeImpl() {
		root = null;
//		count = 0;
	}
	
	public LimTreeImpl(LimTree<T> tree) {
		// TODO
	}
	
	@Override
	public void add(T value) {
//		if(root == null)
//			root = new TreeNode<T>(value);
//		else
			root = add(root, value);
	}
	
	private TreeNode<T> add (TreeNode<T> node, T value) {
		if(node == null)
			return new TreeNode<>(value);
		
		int compare = node.getValue().compareTo(value);
		
		if (compare == 0)
			return node;
		else if (compare > 0)
			node.setLeft(add(node.getLeft(), value));
		else
			node.setRight(add(node.getRight(), value));
		
		return node;
	}
	
	// 비슷한 함수가 중복되는게 싫은데 매번 트리를 만들 때 마다 이게 고민이다.
	private TreeNode<T> get (TreeNode<T> node, T value) {
		int compare = node.getValue().compareTo(value);
		
		if (compare == 0)
			return node;
		else if (compare > 0)
			return get(node.getLeft(), value);
		else if (compare < 0)
			return get(node.getRight(), value);
		
		return null;
	}

	@Override
	public void delete(T value) {
		delete(root, value);
	}
	
	//재귀를 돌려야 할 것 같다.
	private void delete (TreeNode<T> node, T value) {
		TreeNode<T> temp = get(node, value);	//일치하는 노드를 찾았다.
		
		if(temp == null)	//고 생각헸는데 아니었다면
			return;
		
		TreeNode<T> left = temp.getLeft();
		TreeNode<T> right = temp.getRight();
		
		if(left != null && right != null) {	//차일드가 둘 다 있을 때
			TreeNode<T> lastLeft = right;
			
			while(lastLeft.getLeft() != null)
				lastLeft = lastLeft.getLeft();
			
			if(right == lastLeft) {
				temp.setRight(right.getRight());
				temp.setValue(right.getValue());
				
				//delete가 자동으로 된다고는 하지만 아직 잘 모르겠다.
				right.setLeft(null);
				right.setRight(null);
				right.setValue(null);
			}
			else {
				TreeNode<T> lastLeftParent = findParent(right, lastLeft.getValue());
				lastLeftParent.setLeft(lastLeft.getRight());
				temp.setValue(lastLeft.getValue());
				
				lastLeft.setLeft(null);
				lastLeft.setRight(null);
				lastLeft.setValue(null);
			}
		}
		else if (left != null) {	//왼쪽 차일드만 있을 때
			temp.setLeft(left.getLeft());
			temp.setRight(left.getRight());
			temp.setValue(left.getValue());
			
			//delete가 자동으로 된다고는 하지만 아직 잘 모르겠다.
			left.setLeft(null);
			left.setRight(null);
			left.setValue(null);
		}
		else if (right != null) {	// 오른쪽 차일드만 있을 때
			temp.setLeft(right.getLeft());
			temp.setRight(right.getRight());
			temp.setValue(right.getValue());
			
			//delete가 자동으로 된다고는 하지만 아직 잘 모르겠다.
			right.setLeft(null);
			right.setRight(null);
			right.setValue(null);
		}
		else {	//차일드가 없을 때...는 부모를 알아야겠는데..?
			temp = findParent(node, value);
			if(temp.getLeft().getValue() == value)
				temp.setLeft(null);
			else
				temp.setRight(null);
		}
	}

	// root는 부모를 가지지 않음
	private TreeNode<T> findParent(TreeNode<T> node, T value) {
		int compare = node.getValue().compareTo(value);
		
		TreeNode<T> left = node.getLeft();
		TreeNode<T> right = node.getRight();
		
		// 삭제하는게 루트라면 여기 걸림
		if (compare == 0)
			return node;
		// 나머지
		else if (left.getValue() == value)
			return node;
		else if (right.getValue() == value)
			return node;
		else if (compare > 0)
			return findParent(left, value);
		else if (compare < 0)
			return findParent(right, value);
		
		return null;
	}
	
	@Override
	public void clean() {
		// 힣ㅎ..
		root = null;
	}

	// 의미없는 함수
//	@Override
//	public T get(T value) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public LimTree<T> divide(T value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equal(LimTree<T> tree) {
		// TODO Auto-generated method stub
		return false;
	}

	// 사이즈가 알고싶지 않아졌다.
//	@Override
//	public boolean isEmpty() {
//		return count != 0;
//	}
//
//	@Override
//	public int size() {
//		return count;
//	}
	
	@Override
	public String toString() {
		return toString(root);
	}
	public String toString(TreeNode<T> node) {
		if(node == null)
			return "";

		return node.toString() + " " + toString(node.getLeft()) + toString(node.getRight());
//		return toString(node.getLeft()) + node.toString() + " " + toString(node.getRight());
//		return toString(node.getLeft()) + toString(node.getRight()) + node.toString() + " ";
	}
}
