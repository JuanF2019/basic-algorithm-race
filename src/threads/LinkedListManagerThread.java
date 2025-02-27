package threads;

import model.LinkedListManager;
import model.RaceManager;
import ui.AlgorithmsRaceGUI;

public class LinkedListManagerThread extends Thread {
	private RaceManager raceManager;
	private LinkedListManager LLManager;
	private String raceType;	
	private long[] values;
	private AlgorithmsRaceGUI algorithmsRaceGUI;
	
	public  LinkedListManagerThread(AlgorithmsRaceGUI algorithmsRaceGUI,RaceManager raceManager, LinkedListManager LLManager, String raceType,long[] values) {
		this.raceManager = raceManager;
		this.LLManager = LLManager;
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
					LLManager.addIterative(values[i]);					
				}
				break;
			case RaceManager.ADD_RACE_RECURSIVE:
				for (int i = 0; i < values.length; i++) {
					LLManager.addRecursive(values[i],null);
				}
				break;
			case RaceManager.FIND_RACE_ITERATIVE:
				for (int i = 0; i < values.length; i++) {
					LLManager.findIterative(values[i]);
				}
				break;
			case RaceManager.FIND_RACE_RECURSIVE:
				for (int i = 0; i < values.length; i++) {
					LLManager.findRecursive(values[i],null);
				}
				break;
			case RaceManager.REMOVE_RACE_ITERATIVE:
				for (int i = 0; i < values.length; i++) {
					LLManager.removeIterative(values[i]);
				}
				break;
			case RaceManager.REMOVE_RACE_RECURSIVE:
				for (int i = 0; i < values.length; i++) {
					LLManager.removeRecursive(values[i],null);
				}
				break;
			}	
			algorithmsRaceGUI.reportCorrectEndLL();
		}
		catch(StackOverflowError sof) {		
			algorithmsRaceGUI.reportStackOverflowLL();
		}
		finally {
			raceManager.setLLEnd(true);
		}			
	}
}
