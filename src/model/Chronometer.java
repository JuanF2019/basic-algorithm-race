package model;

public class Chronometer {
	private long currentTime;
	private long pauseTime;
	private long startTime;
	private long baseTime;
	private boolean running;
	private boolean stopped;
	
	public Chronometer() {
		running = false;
		stopped = false;
	}
	
	public void updateTime() {
		currentTime = System.currentTimeMillis();
	}
	
	public String getTime() {
		long time = (currentTime - baseTime); 
		
		long minutes = time/60000;
		String minutesStr;
		
		if(minutes < 10) minutesStr = "0" + minutes;
		else minutesStr = "" + minutes;
				
		
		long seconds = (time%60000)/1000;
		String secondsStr = "";
		
		if(seconds < 10) secondsStr = "0" + seconds;
		else secondsStr = "" + seconds;
		
				
		long milliseconds = time%1000;
		String millisStr = "";
		
		if (milliseconds < 10) millisStr = "00" + milliseconds;
		else if (milliseconds < 100) millisStr = "0" + milliseconds;
		else millisStr = "" + milliseconds;
		
		return minutesStr + ":" + secondsStr + ":" + millisStr;
	}
	
	public void start() {
		startTime = System.currentTimeMillis();
		if(!stopped) {
			baseTime += (startTime - pauseTime);
			running = true;
		}else {
			pauseTime = 0;
			currentTime = 0;
			stopped = false;
			
			baseTime = System.currentTimeMillis();
			running = true;
		}
	}
	
	public void pause() {
		running = false;
		pauseTime = System.currentTimeMillis();		
	}
	
	public void stop() {
		running = false;	
		stopped = true;
	}
	
	public boolean isRunning() {
		return running;
	}	
}
