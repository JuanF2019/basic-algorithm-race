package model;

import java.util.Random;

public class LinkedListManager {
	private LLNode firstNode;
	
	public LinkedListManager() {		
	}
	
	public void addIterative(long number) {
		LLNode nodeToAdd = new LLNode(number);
		
		if(firstNode == null) {
			firstNode = nodeToAdd;
		}
		else{
			LLNode currentNode = firstNode;
			while(currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(nodeToAdd);
			nodeToAdd.setPreNode(currentNode);			
		}
		
	}
	
	public void addRecursive(long number, LLNode currentNode) throws StackOverflowError{
		if(firstNode == null) {
			firstNode = new LLNode(number);
		}
		else {
			if(currentNode == null) {
				currentNode = firstNode;
			}
			
			LLNode nextNode = currentNode.getNextNode();
			
			if(nextNode == null){
				LLNode nodeToAdd = new LLNode(number);
				currentNode.setNextNode(nodeToAdd);
				nodeToAdd.setPreNode(currentNode);
			}
			else {
				addRecursive(number,nextNode);
			}
		}
		
	}

	public boolean findIterative(long number) {				
		if(firstNode != null) {									
			LLNode currentNode = firstNode;			
			while(currentNode != null){				
				if(currentNode.getNumber() == number) {
					return true;
				}
				else {
					currentNode = currentNode.getNextNode();
				}				
			}			
		}		
		return false;		
	}
	
	//Change in class diagram
	public boolean findRecursive(long number, LLNode currentNode) throws StackOverflowError{
		if(firstNode != null) {
			if(currentNode == null) {
				currentNode = firstNode;
			}
			
			LLNode nextNode = currentNode.getNextNode();
			
			if(currentNode.getNumber() == number) {
				return true;
			}
			else if(nextNode != null) {
				return findRecursive(number, nextNode);
			}
			else {
				return false;
			}
		}		
		return false;
	}

	public void removeIterative(long number) {
		if(firstNode != null) {
			if(firstNode.getNumber() == number) {
				firstNode = null;
			}else {				
				LLNode currentNode = firstNode;
				while(currentNode != null && currentNode.getNumber() != number) {
					currentNode = currentNode.getNextNode();
				}
				
				if(currentNode != null) {
					if(currentNode.getNextNode() == null) {
						currentNode.getPreNode().setNextNode(null);
						currentNode.setPreNode(null);
					}else {
						currentNode.getPreNode().setNextNode(currentNode.getNextNode());
						currentNode.getNextNode().setPreNode(currentNode.getPreNode());
						currentNode.setNextNode(null);
						currentNode.setPreNode(null);
					}
				}
			}		
		}
	}
	
	//Change in class diagram
	public void removeRecursive(long number, LLNode currentNode)throws StackOverflowError {
		if(firstNode != null) {
			if(currentNode == null && firstNode.getNumber() == number) {
				firstNode = null;
			}
			else {	
				if(currentNode == null) {
					currentNode = firstNode;
				}
				
				if(currentNode.getNumber() == number) {
					if(currentNode.getNextNode() == null) {
						currentNode.getPreNode().setNextNode(null);
						currentNode.setPreNode(null);
					}
					else {
						currentNode.getPreNode().setNextNode(currentNode.getNextNode());
						currentNode.getNextNode().setPreNode(currentNode.getPreNode());
						currentNode.setNextNode(null);
						currentNode.setPreNode(null);
					}
				}
				else {
					if(currentNode.getNextNode() != null) {
						removeRecursive(number,currentNode.getNextNode());
					}
				}													
			}		
		}
	}
	
	public void generateRandomNodes(int n) {
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			addIterative(r.nextLong());
		}
	}

}
