package model;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListManager {
	private ArrayList<ALNode> nodes;
	
	public ArrayListManager() {
		nodes = new ArrayList<ALNode>();
	}
	
	public void add(long number) {
		nodes.add(new ALNode(number));
	}

	public boolean findIterative(long number) {
		for (int i = 0; i < nodes.size(); i++) {
			if(nodes.get(i).getNumber() == number) {
				return true;
			}
		}
		return false;
	}
	
	//Change in class diagram
	public boolean findRecursive(long number, int i) throws StackOverflowError{
		if(nodes.get(i).getNumber() == number) {
			return true;
		}
		else if(i < nodes.size()) {
			return findRecursive(number,i++);
		}		
		else {
			return false;
		}
	}

	public void removeIterative(long number) {
		for (int i = 0; i < nodes.size(); i++) {
			if(nodes.get(i).getNumber() == number) {
				nodes.remove(i);
			}
		}
	}
	
	//Change in class diagram
	public void removeRecursive(long number, int i)throws StackOverflowError {
		if(nodes.get(i).getNumber() == number) {
			nodes.remove(i);
		}
		else if(i < nodes.size()) {
			removeRecursive(number,i++);
		}		
		else {
			//Do nothing, terminates method
		}
	}
	
	public void generateRandomNodes(int n) {
		for (int i = 0; i < n; i++) {
			nodes.add(new ALNode(new Random().nextLong()));
		}
	}


}
