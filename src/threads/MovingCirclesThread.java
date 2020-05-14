package threads;

import javafx.application.Platform;
import model.RaceManager;
import ui.AlgorithmsRaceGUI;

public class MovingCirclesThread extends Thread {
	private RaceManager raceManager;
	private AlgorithmsRaceGUI algorithmsRaceGUI;
	
	public MovingCirclesThread(AlgorithmsRaceGUI algorithmsRaceGUI, RaceManager raceManager) {
		this.raceManager = raceManager;
		this.algorithmsRaceGUI = algorithmsRaceGUI;
		setDaemon(true);
	}
	
	public void run() {
		while(raceManager.isRunningRace()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Platform.runLater(new Thread() {
				public void run() {
					algorithmsRaceGUI.updateCircles();
				}
			});
		}
	}
}
