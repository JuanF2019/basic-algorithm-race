package model;

public class BSTNode {
	private long number;
	private LLNode left;
	private LLNode right;
	
	public BSTNode(long number) {
		this.number = number;
	}
	
	public long getNumber() {
		return number;
	}

	public LLNode getLeft() {
		return left;
	}
	
	public LLNode getRight() {
		return right;
	}

	public void setLeft(LLNode left) {
		this.left = left;
	}	

	public void setRight(LLNode right) {
		this.right = right;
	}

}
