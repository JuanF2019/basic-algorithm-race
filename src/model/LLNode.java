package model;

public class LLNode {
	private long number;
	private LLNode preNode;
	private LLNode nextNode;
	
	public LLNode(long number) {
		this.number = number;
	}
	
	public long getNumber() {
		return number;
	}

	public LLNode getPreNode() {
		return preNode;
	}

	public LLNode getNextNode() {
		return nextNode;
	}

	public void setPreNode(LLNode preNode) {
		this.preNode = preNode;
	}

	public void setNextNode(LLNode nextNode) {
		this.nextNode = nextNode;
	}
}
