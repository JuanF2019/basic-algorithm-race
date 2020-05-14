package model;

import java.util.ArrayList;

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
	
	public boolean findRecursive(long number, int i) throws StackOverflowError{
		if(i < nodes.size() && nodes.get(i).getNumber() == number) {
			return true;
		}
		else if(i < nodes.size()) {
			return findRecursive(number,i+1);			
		}		
		else {
			return false;
		}
	}

	public boolean removeIterative(long number) {
		for (int i = 0; i < nodes.size(); i++) {
			if(nodes.get(i).getNumber() == number) {
				nodes.remove(i);
				return true;
			}
		}
		return false;
	}	
	
	public boolean removeRecursive(long number, int i)throws StackOverflowError {
		if(i < nodes.size() && nodes.get(i).getNumber() == number) {
			nodes.remove(i);
			return true;
		}
		else if(i < nodes.size()) {
			return removeRecursive(number,i+1);
		}		
		else {
			return false;
		}
	}	
}
