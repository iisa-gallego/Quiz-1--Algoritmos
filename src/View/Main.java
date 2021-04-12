package View;

import Controller.Controller;
import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	Controller controller;

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		controller = new Controller(this);
	}

	public void draw() {
		background(10);
		controller.drawRandomFig();
		controller.hit();
	}

	public void mousePressed() {
		controller.addRandomFig();
		controller.pauseFig();
	}
}
