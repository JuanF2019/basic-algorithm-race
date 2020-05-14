package threads;

import model.RaceManager;


public class RaceManagerThread extends Thread {
	private RaceManager raceManager;
	private int n;
	private String mode;
	
	public RaceManagerThread(RaceManager raceManager, int n, String mode) {
		this.raceManager = raceManager;
		this.n = n;
		this.mode = mode;
		setDaemon(true);
	}
	
	public void run() {				
		try {
			raceManager.startRace(n, mode);
		} catch (StackOverflowError | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
