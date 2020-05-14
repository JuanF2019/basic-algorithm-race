package threads;

import model.ArrayListManager;
import model.RaceManager;
import ui.AlgorithmsRaceGUI;

public class ArrayListManagerThread extends Thread {
	private RaceManager raceManager;
	private ArrayListManager ALManager;
	private String raceType;
	private long[] values;	
	private AlgorithmsRaceGUI algorithmsRaceGUI;
	
	
	public ArrayListManagerThread(AlgorithmsRaceGUI aRGUI, RaceManager rM, ArrayListManager ALM, String rT,long[] v) {
		raceManager = rM;
		ALManager = ALM;
		raceType = rT;
		values = v;
		algorithmsRaceGUI = aRGUI;
		setDaemon(true);
	}

	public void run() {	
		try {
			switch(raceType) {
			case RaceManager.ADD_RACE_ITERATIVE:
				for (int i = 0; i < values.length; i++) {
					ALManager.add(values[i]);						
				}
				break;
			case RaceManager.ADD_RACE_RECURSIVE:
				for (int i = 0; i < values.length; i++) {
					ALManager.add(values[i]);
				}
				break;
			case RaceManager.FIND_RACE_ITERATIVE:
				for (int i = 0; i < values.length; i++) {
					ALManager.findIterative(values[i]);
				}
				break;
			case RaceManager.FIND_RACE_RECURSIVE:
				for (int i = 0; i < values.length; i++) {
					ALManager.findRecursive(values[i],0);
				}
				break;
			case RaceManager.REMOVE_RACE_ITERATIVE:
				for (int i = 0; i < values.length; i++) {
					ALManager.removeIterative(values[i]);
				}
				break;
			case RaceManager.REMOVE_RACE_RECURSIVE:
				for (int i = 0; i < values.length; i++) {
					ALManager.removeRecursive(values[i],0);
				}
				break;
			}	
			algorithmsRaceGUI.reportCorrectEndAL();
		}
		catch(StackOverflowError sof) {			
			algorithmsRaceGUI.reportStackOverflowAL();
		}
		finally {
			raceManager.setALEnd(true);	
		}			
	}	
}
