package Controller;

import Model.Logic;
import processing.core.PApplet;

public class Controller {

	Logic logic;
	PApplet app;
	
	public Controller(PApplet app) {
		this.app = app;
		logic = new Logic(app);
	}
	
	public void drawCircle() {
		logic.drawCircle();
	}
	
	public void drawSquare() {
		logic.drawSquare();
	}
	
}