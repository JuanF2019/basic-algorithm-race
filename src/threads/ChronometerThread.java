package threads;

import javafx.application.Platform;
import model.Chronometer;
import ui.AlgorithmsRaceGUI;

public class ChronometerThread extends Thread {
	private Chronometer chronometer;
	private AlgorithmsRaceGUI algorithmsRaceGUI;
	
	public ChronometerThread(Chronometer c, AlgorithmsRaceGUI arGUI) {
		chronometer = c;
		algorithmsRaceGUI = arGUI;
		setDaemon(true);
	}
	
	public void run() {		
		while(chronometer.isRunning()){
			chronometer.updateTime();			
			Platform.runLater(new Thread() {
				public void run() {
					algorithmsRaceGUI.updateTime();					
				}
			});
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}			
		}
	}
}