package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Chronometer;
import model.RaceManager;
import threads.MovingCirclesThread;
import threads.RaceManagerThread;

public class AlgorithmsRaceGUI {
	
	private RaceManager raceManager;	
	
	private Chronometer chronometer;
	
	public static final double MAX_RADIUS = 40;
	public static final double MIN_RADIUS = 0;
	private double STEP_CIRCLE_BIG;
	private double STEP_CIRCLE_SMALL;
	
    @FXML
    private TextField nValueTextField;

    @FXML
    private RadioButton addRButton;

    @FXML
    private ToggleGroup algorithmGroup;

    @FXML
    private RadioButton findRButton;

    @FXML
    private RadioButton removeRButton;

    @FXML
    private RadioButton iterativeRButton;

    @FXML
    private ToggleGroup modeGroup;

    @FXML
    private RadioButton recursiveRButton;

    @FXML
    private Button runButton;

    @FXML
    private Label mainChronometerLabel;

    @FXML
    private Label ALChronometerLabel;

    @FXML
    private Label LLChronometerLabel;

    @FXML
    private Label BSTChronometerLabel;

    @FXML
    private Circle circleBig;

    @FXML
    private Circle circleSmall;

    
    public AlgorithmsRaceGUI(Chronometer chronometer) {
		raceManager = new RaceManager(chronometer,this);	
		this.chronometer = chronometer;
		STEP_CIRCLE_BIG = -1;
		STEP_CIRCLE_SMALL = 1;
	}

    @FXML
    void startRace(ActionEvent event) throws InterruptedException {
    	String mode = "";
    	int n = -1;    	
    	try {
    		if(nValueTextField.getText().isEmpty()) {
    			throw new NumberFormatException();
    		}
    		n = Integer.parseInt(nValueTextField.getText());
    		
    		if(n < 0) {
    			throw new NumberFormatException();
    		}
    		
    		if(addRButton.isSelected()) {
        		if(iterativeRButton.isSelected()) {
        			mode = RaceManager.ADD_RACE_ITERATIVE;
        		}
        		else if(recursiveRButton.isSelected()){
        			mode = RaceManager.ADD_RACE_RECURSIVE;
        		}
        		else {
        			mode = null;
        		}
        	}
        	else if(findRButton.isSelected()) {
        		if(iterativeRButton.isSelected()) {
        			mode = RaceManager.FIND_RACE_ITERATIVE;
        		}
        		else if(recursiveRButton.isSelected()){
        			mode = RaceManager.FIND_RACE_RECURSIVE;
        		}
        		else {
        			mode = null;
        		}
        	}
        	else if(removeRButton.isSelected()) {
        		if(iterativeRButton.isSelected()) {
        			mode = RaceManager.REMOVE_RACE_ITERATIVE;
        		}
        		else if(recursiveRButton.isSelected()) {
        			mode = RaceManager.REMOVE_RACE_RECURSIVE;
        		}   		
        		else {
        			mode = null;
        		}
        	}    	
        	else {
        		mode = null;
        	}   	
        	
        	if(mode!=null) {
        		ALChronometerLabel.setTextFill(Color.WHITE);
        		LLChronometerLabel.setTextFill(Color.WHITE);
        		BSTChronometerLabel.setTextFill(Color.WHITE);
        		
        		new RaceManagerThread(raceManager,n,mode).start();
        		new MovingCirclesThread(this,raceManager).start();
        		
        		runButton.setDisable(true);
        	}
        	else {
        		Alert alert = new Alert(AlertType.WARNING);
        		alert.setContentText("An algorithm and a mode must be selected!");
        		alert.show();
        	}   
    	}
    	catch(NumberFormatException ex) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("N is mandatory and must be a positive number!");
    		alert.show();    		
    	}    	 	
    }
    
    @FXML
    public void showExtraInformation(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setContentText("Created by\nJuanF2019\nhttps://github.com/JuanF2019");
    	alert.setHeaderText("About");
    	alert.show();
    }
    
	public void updateTime() {		
		if(!raceManager.isALEnd()) {			
			ALChronometerLabel.setText(chronometer.getTime());
		}
		if(!raceManager.isLLEnd()) {			
			LLChronometerLabel.setText(chronometer.getTime());
		}
		if(!raceManager.isBSTEnd()) {			
			BSTChronometerLabel.setText(chronometer.getTime());
		}
		if(!raceManager.isALEnd() || !raceManager.isLLEnd() || !raceManager.isBSTEnd()) {			
			mainChronometerLabel.setText(chronometer.getTime());
		}	
			
	}
	
	public void updateCircles() {
		if(circleBig.getRadius() == MAX_RADIUS) {
			STEP_CIRCLE_BIG = -1;
		}
		else if(circleBig.getRadius() == MIN_RADIUS){
			STEP_CIRCLE_BIG = 1;
		}
		
		if(circleSmall.getRadius() == MIN_RADIUS) {
			STEP_CIRCLE_SMALL = 1;
		}
		else if(circleSmall.getRadius() == MAX_RADIUS) {
			STEP_CIRCLE_SMALL = -1;
		}
		
		circleSmall.setRadius(circleSmall.getRadius() + STEP_CIRCLE_SMALL);
		circleBig.setRadius(circleBig.getRadius() + STEP_CIRCLE_BIG);
	}

	public void enableRunButton() {
		runButton.setDisable(false);		
	}

	
	public void reportStackOverflowAL() {
		ALChronometerLabel.setTextFill(Color.RED);
	}
	
	public void reportStackOverflowLL() {
		LLChronometerLabel.setTextFill(Color.RED);
	}
	
	public void reportStackOverflowBST() {
		BSTChronometerLabel.setTextFill(Color.RED);
	}
	
	public void reportCorrectEndAL() {
		ALChronometerLabel.setTextFill(Color.GREEN);
	}
	
	public void reportCorrectEndLL() {
		LLChronometerLabel.setTextFill(Color.GREEN);
	}
	
	public void reportCorrectEndBST() {
		BSTChronometerLabel.setTextFill(Color.GREEN);
	}	
}
