package model;

import java.util.Random;

import threads.*;
import ui.AlgorithmsRaceGUI;

public class RaceManager {
	public static final String ADD_RACE_ITERATIVE = "ARI";
	public static final String ADD_RACE_RECURSIVE = "ARR";
	public static final String FIND_RACE_ITERATIVE = "FRI";
	public static final String FIND_RACE_RECURSIVE = "FRR";
	public static final String REMOVE_RACE_ITERATIVE = "RRI";
	public static final String REMOVE_RACE_RECURSIVE = "RRR";	
	
	private Chronometer chronometer;		
	private BinarySearchTreeManager BSTManager;
	private LinkedListManager LLManager;
	private ArrayListManager ALManager;
	
	private ChronometerThread chronometerThread;
	private ArrayListManagerThread ALManagerThread;
	private BinarySearchTreeManagerThread BSTManagerThread;
	private LinkedListManagerThread LLManagerThread;	
	private AlgorithmsRaceGUI algorithmsRaceGUI;
		
	private boolean ALEnd;
	private boolean LLEnd;
	private boolean BSTEnd;
	private boolean runningRace;
	
	public RaceManager(Chronometer chronometer, AlgorithmsRaceGUI algorithmsRaceGUI) {	
		this.chronometer = chronometer;
		this.algorithmsRaceGUI = algorithmsRaceGUI;
	}
	
	public void startRace(int n,String mode)throws InterruptedException,StackOverflowError {
		BSTEnd = false;
		LLEnd = false;
		ALEnd = false;
		runningRace = true;
	
		LLManager = new LinkedListManager();
		ALManager = new ArrayListManager();
		BSTManager = new BinarySearchTreeManager();
				
		long[] values = new long[n];
		Random r = new Random();		
		
		for(int i = 0; i < values.length ; i++) {
			values[i] = r.nextLong();
		}
		
		switch(mode) {
		case ADD_RACE_ITERATIVE:
			ALManagerThread =  new ArrayListManagerThread(algorithmsRaceGUI, this,ALManager,ADD_RACE_ITERATIVE,values);
			LLManagerThread =  new LinkedListManagerThread(algorithmsRaceGUI, this,LLManager,ADD_RACE_ITERATIVE,values);
			BSTManagerThread =  new BinarySearchTreeManagerThread(algorithmsRaceGUI, this,BSTManager,ADD_RACE_ITERATIVE,values);			
			break;
		case ADD_RACE_RECURSIVE:
			ALManagerThread =  new ArrayListManagerThread(algorithmsRaceGUI, this,ALManager,ADD_RACE_RECURSIVE,values);
			LLManagerThread =  new LinkedListManagerThread(algorithmsRaceGUI, this,LLManager,ADD_RACE_RECURSIVE,values);
			BSTManagerThread =  new BinarySearchTreeManagerThread(algorithmsRaceGUI, this,BSTManager,ADD_RACE_RECURSIVE,values);
			break;			
		case FIND_RACE_ITERATIVE:
			for(int i = 0; i < n ; i++) {
				long number = r.nextLong();
				ALManager.add(number);
				LLManager.addIterativeFirst(number);
				BSTManager.addIterative(number);
			}
			
			ALManagerThread =  new ArrayListManagerThread(algorithmsRaceGUI, this,ALManager,FIND_RACE_ITERATIVE,values);
			LLManagerThread =  new LinkedListManagerThread(algorithmsRaceGUI, this,LLManager,FIND_RACE_ITERATIVE,values);
			BSTManagerThread =  new BinarySearchTreeManagerThread(algorithmsRaceGUI, this,BSTManager,FIND_RACE_ITERATIVE,values);	
			break;
		case FIND_RACE_RECURSIVE:
			for(int i = 0; i < n ; i++) {
				long number = r.nextLong();
				ALManager.add(number);
				LLManager.addIterativeFirst(number);
				BSTManager.addIterative(number);
			}
			
			ALManagerThread =  new ArrayListManagerThread(algorithmsRaceGUI, this,ALManager,FIND_RACE_RECURSIVE,values);
			LLManagerThread =  new LinkedListManagerThread(algorithmsRaceGUI, this,LLManager,FIND_RACE_RECURSIVE,values);
			BSTManagerThread =  new BinarySearchTreeManagerThread(algorithmsRaceGUI, this,BSTManager,FIND_RACE_RECURSIVE,values);
			break;
		case REMOVE_RACE_ITERATIVE:
			for(int i = 0; i < n ; i++) {
				long number = r.nextLong();
				ALManager.add(number);
				LLManager.addIterativeFirst(number);
				BSTManager.addIterative(number);
			}
			
			ALManagerThread =  new ArrayListManagerThread(algorithmsRaceGUI, this,ALManager,REMOVE_RACE_ITERATIVE,values);
			LLManagerThread =  new LinkedListManagerThread(algorithmsRaceGUI, this,LLManager,REMOVE_RACE_ITERATIVE,values);
			BSTManagerThread =  new BinarySearchTreeManagerThread(algorithmsRaceGUI, this,BSTManager,REMOVE_RACE_ITERATIVE,values);
			break;
		case REMOVE_RACE_RECURSIVE:
			for(int i = 0; i < n ; i++) {
				long number = r.nextLong();
				ALManager.add(number);
				LLManager.addIterativeFirst(number);
				BSTManager.addIterative(number);
			}
			
			ALManagerThread =  new ArrayListManagerThread(algorithmsRaceGUI, this,ALManager,REMOVE_RACE_RECURSIVE,values);
			LLManagerThread =  new LinkedListManagerThread(algorithmsRaceGUI, this,LLManager,REMOVE_RACE_RECURSIVE,values);
			BSTManagerThread =  new BinarySearchTreeManagerThread(algorithmsRaceGUI, this,BSTManager,REMOVE_RACE_RECURSIVE,values);
			break;			
		}
		chronometer.start();
		chronometerThread = new ChronometerThread(chronometer,algorithmsRaceGUI);
		
		
		chronometerThread.start();
		ALManagerThread.start();	
		LLManagerThread.start();
		BSTManagerThread.start();
						
		ALManagerThread.join();		
		LLManagerThread.join();	
		BSTManagerThread.join();	
		
		runningRace = false;
		algorithmsRaceGUI.enableRunButton();		
		chronometer.stop();
	}
	
	public Chronometer getChronometer() {
		return chronometer;
	}

	public BinarySearchTreeManager getBSTManager() {
		return BSTManager;
	}

	public LinkedListManager getLLManager() {
		return LLManager;
	}

	public ArrayListManager getALManager() {
		return ALManager;
	}

	public boolean isBSTEnd() {
		return BSTEnd;
	}

	public boolean isLLEnd() {
		return LLEnd;
	}

	public boolean isALEnd() {
		return ALEnd;
	}

	public void setBSTEnd(boolean bSTEnd) {
		BSTEnd = bSTEnd;
	}

	public void setLLEnd(boolean lLEnd) {
		LLEnd = lLEnd;
	}

	public void setALEnd(boolean aLEnd) {
		ALEnd = aLEnd;
	}

	public boolean isRunningRace() {
		return runningRace;
	}
}
