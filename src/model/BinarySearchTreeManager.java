package model;

import java.util.Random;

public class BinarySearchTreeManager {
	private BSTNode firstNode;
	
	public BinarySearchTreeManager() {		
	}
	
	public void addIterative(long number) {
		
		BSTNode nodeToAdd = new BSTNode(number);
		if(firstNode == null) {
			firstNode = new BSTNode(number);
		}
		else {
			BSTNode currentNode = firstNode;
			boolean add = false;
			while(!add) {
				if(number >= currentNode.getNumber() ) {
					if(currentNode.getRight() == null){
						add = true;
						
						currentNode.setRight(nodeToAdd);
						nodeToAdd.setFather(currentNode);						
					}
					else {
						currentNode = currentNode.getRight();
					}					
				}
				else {					
					if(currentNode.getLeft() == null){
						add = true;	
						
						currentNode.setLeft(nodeToAdd);
						nodeToAdd.setFather(currentNode);
						
					}
					else {
						currentNode = currentNode.getLeft();
					}
				}			
			}
		}
	}
	
	//Change in Class Diagram
	public void addRecursive(long number, BSTNode currentNode) throws StackOverflowError{
		if(currentNode == null) {
			currentNode = firstNode;
		}
				
		if(firstNode == null) {
			firstNode = new BSTNode(number);
		}		
		else {
			if(number >= currentNode.getNumber()) {
				BSTNode right = currentNode.getRight();
				if(right == null) {
					BSTNode nodeToAdd = new BSTNode(number);
					
					currentNode.setRight(nodeToAdd);
					nodeToAdd.setFather(currentNode);
				}
				else {
					addRecursive(number,right);
				}
			}
			else {
				BSTNode left = currentNode.getLeft();
				if(left == null) {
					BSTNode nodeToAdd = new BSTNode(number);
					
					currentNode.setLeft(nodeToAdd);
					nodeToAdd.setFather(currentNode);
				}
				else {
					addRecursive(number,left);
				}
			}
		}
	}

	public boolean findIterative(long number) {
		if(firstNode == null) {
			return false;
		}
		else {
			BSTNode currentNode = firstNode;
			boolean found = false;
			while(!found) {
				if(number > currentNode.getNumber() ) {
					if(currentNode.getRight() == null){
						return false;						
					}
					else {
						currentNode = currentNode.getRight();
					}					
				}
				else if (number < currentNode.getNumber()) {					
					if(currentNode.getLeft() == null){
						return false;						
					}
					else {
						currentNode = currentNode.getLeft();
					}
				}
				else {
					return true;
				}
			}
		}
		return false;
	}
	
	//Change in class diagram
	public boolean findRecursive(long number, BSTNode currentNode) throws StackOverflowError{
		if(currentNode == null) {
			currentNode = firstNode;
		}
				
		if(firstNode == null) {
			return false;
		}		
		else {
			if(number > currentNode.getNumber()) {
				BSTNode right = currentNode.getRight();
				if(right == null) {
					return false;
				}
				else {
					findRecursive(number,right);
				}
			}
			else if(number < currentNode.getNumber()){
				BSTNode left = currentNode.getLeft();
				if(left == null) {
					return false;
				}
				else {
					findRecursive(number,left);
				}
			}
			else {
				return true;
			}
		}		
		return false;
	}

	public void removeIterative(long number) {
		if(firstNode != null) {
			BSTNode currentNode = firstNode;
			boolean check = false;
			while(!check) {
				if(number > currentNode.getNumber() ) {
					if(currentNode.getRight() != null){
						currentNode = currentNode.getRight();					
					}
					else {										
						check = true;
					}
				}
				else if (number < currentNode.getNumber()) {					
					if(currentNode.getLeft() != null){
						currentNode = currentNode.getLeft();					
					}
					else {										
						check = true;
					}
				}
				else {
					if(currentNode.getLeft() == null && currentNode.getRight() == null) {
						if(currentNode.getFather().getLeft() == currentNode) {
							currentNode.getFather().setLeft(null);
						}
						else {
							currentNode.getFather().setRight(null);
						}
						currentNode.setFather(null);
					}
					else if(currentNode.getLeft() != null) {
						BSTNode left =  currentNode.getLeft();
						BSTNode father = currentNode .getFather();
						if(father.getLeft() == currentNode) {
							father.setLeft(left);
						}
						else {
							father.setRight(left);
						}
						left.setFather(father);
						currentNode.setFather(null);
						currentNode.setLeft(null);
					}
					else if(currentNode.getRight() != null) {
						BSTNode right =  currentNode.getRight();
						BSTNode father = currentNode .getFather();
						if(father.getLeft() == currentNode) {
							father.setLeft(right);
						}
						else {
							father.setRight(right);
						}
						right.setFather(father);
						currentNode.setFather(null);
						currentNode.setLeft(null);
					}
					else {
						BSTNode minSubTreeNode = minNodeIterative(currentNode);
						
						if(minSubTreeNode.getRight() != null) {
							minSubTreeNode.getFather().setLeft(minSubTreeNode.getRight());
							minSubTreeNode.setRight(null);
						}
						minSubTreeNode.setFather(null);
						
						minSubTreeNode.setFather(currentNode.getFather());
						minSubTreeNode.setRight(currentNode.getRight());
						minSubTreeNode.setLeft(currentNode.getLeft());
						
						currentNode.setFather(null);
						currentNode.setLeft(null);
						currentNode.setRight(null);
					}
					check = true;
				}
			}
		}		
	}
	
	//Change in class diagram
	public void removeRecursive(long number, BSTNode currentNode)throws StackOverflowError {
		if(currentNode == null) {
			currentNode = firstNode;
		}
				
		if(firstNode != null) {
			if(number > currentNode.getNumber() ) {
				if(currentNode.getRight() != null){
					removeRecursive(number,currentNode.getRight());					
				}
				else {										
					//Terminates method, node not found.
				}
			}
			else if (number < currentNode.getNumber()) {					
				if(currentNode.getLeft() != null){
					removeRecursive(number,currentNode.getLeft());					
				}
				else {										
					//Terminates method, node not found.
				}
			}
			else {
				if(currentNode.getLeft() == null && currentNode.getRight() == null) {
					if(currentNode.getFather().getLeft() == currentNode) {
						currentNode.getFather().setLeft(null);
					}
					else {
						currentNode.getFather().setRight(null);
					}
					currentNode.setFather(null);
				}
				else if(currentNode.getLeft() != null) {
					BSTNode left =  currentNode.getLeft();
					BSTNode father = currentNode .getFather();
					if(father.getLeft() == currentNode) {
						father.setLeft(left);
					}
					else {
						father.setRight(left);
					}
					left.setFather(father);
					currentNode.setFather(null);
					currentNode.setLeft(null);
				}
				else if(currentNode.getRight() != null) {
					BSTNode right =  currentNode.getRight();
					BSTNode father = currentNode .getFather();
					if(father.getLeft() == currentNode) {
						father.setLeft(right);
					}
					else {
						father.setRight(right);
					}
					right.setFather(father);
					currentNode.setFather(null);
					currentNode.setLeft(null);
				}
				else {
					BSTNode minSubTreeNode = minNodeRecursive(currentNode);
					
					if(minSubTreeNode.getRight() != null) {
						minSubTreeNode.getFather().setLeft(minSubTreeNode.getRight());
						minSubTreeNode.setRight(null);
					}
					minSubTreeNode.setFather(null);
					
					minSubTreeNode.setFather(currentNode.getFather());
					minSubTreeNode.setRight(currentNode.getRight());
					minSubTreeNode.setLeft(currentNode.getLeft());
					
					currentNode.setFather(null);
					currentNode.setLeft(null);
					currentNode.setRight(null);
				}
				//Terminates method, node removed.
			}
		}
	}
	
	//Add to class diagram
	private BSTNode minNodeRecursive(BSTNode currentNode) throws StackOverflowError{
		if(currentNode == null) {
			currentNode = firstNode;
		}
		
		if(currentNode != null) {	
			BSTNode left = currentNode.getLeft();
			
			if(left == null) {
				return currentNode;
			}
			else {		
				return minNodeRecursive(left);
			}
		}
		else {
			return null;
		}
	}
	
	//Add to class diagram
	private BSTNode minNodeIterative(BSTNode currentNode) {
		if(currentNode == null) {
			currentNode = firstNode;
		}
				
		if(currentNode != null) {
			while(currentNode.getLeft() != null) {
				currentNode = currentNode.getLeft();
			}			
		}
		return currentNode;
	}
	
	public void generateRandomNodes(int n) {
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			addIterative(r.nextLong());
		}
	}

}
