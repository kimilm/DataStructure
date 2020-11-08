package kimilm;

public class TreeNode<T> {
	private TreeNode<T> left;
	private TreeNode<T> right;
	private T value;
	
	public TreeNode() {
		left = null;
		right = null;
		value = null;
	}
	
	public TreeNode(T value) {
		left = null;
		right = null;
		this.value = value;
	}
	
	public TreeNode<T> getLeft() {
		return left;
	}
	
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	
	public TreeNode<T> getRight() {
		return right;
	}
	
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public String toString() {
		return String.valueOf(value);
	}
}
