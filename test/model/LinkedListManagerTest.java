package model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class LinkedListManagerTest {
	
	private LinkedListManager LLManager;

	//For adding test
	void setUp() {
		LLManager = new LinkedListManager();
	}
	
	//For finding test
	void setUp1() {
		LLManager = new LinkedListManager();
		
		LLManager.addIterative(995);
		LLManager.addIterative(25);
		LLManager.addIterative(250);
		LLManager.addIterative(0);
	}
	
	@Test
	void addIterativeTest() {
		setUp();
		
		LLManager.addIterative(995);
		LLManager.addIterative(25);
		LLManager.addIterative(250);
		
		LLNode firstNode = LLManager.getFirstNode();
		
		assertEquals(firstNode.getNumber(),995);
		assertEquals(firstNode.getNextNode().getNumber(),25);
		assertEquals(firstNode.getNextNode().getNextNode().getNumber(),250);
	}
	
	void addRecursiveTest() {
		setUp();
		
		LLManager.addRecursive(995,null);
		LLManager.addRecursive(25,null);
		LLManager.addRecursive(250,null);
		
		LLNode firstNode = LLManager.getFirstNode();
		
		assertEquals(firstNode.getNumber(),995);
		assertEquals(firstNode.getNextNode().getNumber(),25);
		assertEquals(firstNode.getNextNode().getNextNode().getNumber(),250);
	}
	
	void findIterativeTest() {
		setUp1();
		
		
	}
}
