package model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class BinarySearchTreeManagerTest {

	private BinarySearchTreeManager BSTManager;

	//For adding test
	void setUp() {
		BSTManager = new BinarySearchTreeManager();
	}
	
	//For finding test
	void setUp1() {
		BSTManager = new BinarySearchTreeManager();
		
		BSTManager.addIterative(10);
		BSTManager.addIterative(5);
		BSTManager.addIterative(12);		
		BSTManager.addIterative(1);		
		BSTManager.addIterative(4);		
		BSTManager.addIterative(14);		
		BSTManager.addIterative(6);
		BSTManager.addIterative(11);
		BSTManager.addIterative(13);
	}
	
	@Test
	void addIterativeTest() {
		setUp();
		
		BSTManager.addIterative(10);
		BSTManager.addIterative(5);
		BSTManager.addIterative(12);		
		BSTManager.addIterative(1);		
		BSTManager.addIterative(4);		
		BSTManager.addIterative(14);		
		BSTManager.addIterative(6);
		BSTManager.addIterative(11);
		BSTManager.addIterative(13);
		
		BSTNode firstNode = BSTManager.getFirstNode();
		
		assertEquals(firstNode.getNumber(),10);
		assertEquals(firstNode.getLeft().getNumber(),5);
		assertEquals(firstNode.getRight().getNumber(),12);
		assertEquals(firstNode.getLeft().getLeft().getNumber(),1);
		assertEquals(firstNode.getLeft().getLeft().getRight().getNumber(),4);
		assertEquals(firstNode.getRight().getRight().getNumber(),14);
		assertEquals(firstNode.getLeft().getRight().getNumber(),6);
		assertEquals(firstNode.getRight().getLeft().getNumber(),11);
		assertEquals(firstNode.getRight().getRight().getLeft().getNumber(),13);
	}
	
	@Test
	void addRecursiveTest() {
		setUp();
		
		BSTManager.addRecursive(10,null);
		BSTManager.addRecursive(5,null);
		BSTManager.addRecursive(12,null);		
		BSTManager.addRecursive(1,null);		
		BSTManager.addRecursive(4,null);		
		BSTManager.addRecursive(14,null);		
		BSTManager.addRecursive(6,null);
		BSTManager.addRecursive(11,null);
		BSTManager.addRecursive(13,null);
		
		BSTNode firstNode = BSTManager.getFirstNode();
		
		assertEquals(firstNode.getNumber(),10);
		assertEquals(firstNode.getLeft().getNumber(),5);
		assertEquals(firstNode.getRight().getNumber(),12);
		assertEquals(firstNode.getLeft().getLeft().getNumber(),1);
		assertEquals(firstNode.getLeft().getLeft().getRight().getNumber(),4);
		assertEquals(firstNode.getRight().getRight().getNumber(),14);
		assertEquals(firstNode.getLeft().getRight().getNumber(),6);
		assertEquals(firstNode.getRight().getLeft().getNumber(),11);
		assertEquals(firstNode.getRight().getRight().getLeft().getNumber(),13);
	
	}
	
	@Test
	void removeIterativeTest() {
		setUp1();
		
		BSTManager.removeRecursive(10,null);
		
		BSTNode firstNode = BSTManager.getFirstNode();	
		
		assertEquals(11,firstNode.getNumber());
		
		
	}

}
