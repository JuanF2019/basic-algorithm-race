package threads;

import model.BinarySearchTreeManager;
import model.RaceManager;
import ui.AlgorithmsRaceGUI;

public class BinarySearchTreeManagerThread extends Thread{
	private RaceManager raceManager;
	private BinarySearchTreeManager BSTManager;
	private String raceType;	
	private long[] values;
	private AlgorithmsRaceGUI algorithmsRaceGUI;
	
	public  BinarySearchTreeManagerThread(AlgorithmsRaceGUI algorithmsRaceGUI, RaceManager raceManager, BinarySearchTreeManager BSTManager, String raceType,long[] values) {
		this.raceManager = raceManager;
		this.BSTManager = BSTManager;
		this.raceType = raceType;		
		this.values = values;
		this.algorithmsRaceGUI = algorithmsRaceGUI;
		setDaemon(true);
	}
	
	public void run() {
		try {
			switch(raceType) {
			case RaceManager.ADD_RACE_ITERATIVE:
				for (int i = 0; i < values.length; i++) {
					BSTManager.addIterative(values[i]);
				}
				break;
			case RaceManager.ADD_RACE_RECURSIVE:
				for (int i = 0; i < values.length; i++) {
					BSTManager.addRecursive(values[i],null);
				}
				break;
			case RaceManager.FIND_RACE_ITERATIVE:
				for (int i = 0; i < values.length; i++) {
					BSTManager.findIterative(values[i]);
				}
				break;
			case RaceManager.FIND_RACE_RECURSIVE:
				for (int i = 0; i < values.length; i++) {
					BSTManager.findRecursive(values[i],null);
				}
				break;
			case RaceManager.REMOVE_RACE_ITERATIVE:
				for (int i = 0; i < values.length; i++) {
					BSTManager.removeIterative(values[i]);
				}
				break;
			case RaceManager.REMOVE_RACE_RECURSIVE:
				for (int i = 0; i < values.length; i++) {
					BSTManager.removeRecursive(values[i],null);
				}
				break;
				
			}	
			algorithmsRaceGUI.reportCorrectEndBST();
		}
		catch(StackOverflowError sof) {		
			algorithmsRaceGUI.reportStackOverflowBST();
		}
		finally {
			raceManager.setBSTEnd(true);
		}			
	}
}
