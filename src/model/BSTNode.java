package model;

public class BSTNode {
	private long number;
	
	private BSTNode father;
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode(long number) {
		this.number = number;
	}
	
	public long getNumber() {
		return number;
	}

	public BSTNode getLeft() {
		return left;
	}
	
	public BSTNode getRight() {
		return right;
	}
	
	public BSTNode getFather() {
		return father;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}	

	public void setRight(BSTNode right) {
		this.right = right;
	}	

	public void setFather(BSTNode father) {
		this.father = father;
	}

}
