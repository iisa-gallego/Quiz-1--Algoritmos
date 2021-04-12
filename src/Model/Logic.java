package Model;

import java.util.ArrayList;
import processing.core.PApplet;

public class Logic extends PApplet {

	PApplet app;
	Figure circle;
	Figure square;
	Figure triangle;

	String[] loadTXT;
	ArrayList<String> words;
	ArrayList<Figure> figure;

	public Logic(PApplet app) {
		figure = new ArrayList<Figure>();
		this.app = app;

		app.rectMode(CENTER);
		circle = new Circle(50, 50, 50, 1, 255, 0, 255, 10, app);
		triangle = new Triangle(50, 50, 50, 1, (int) random(0, 255), (int) random(0, 255), (int) random(0, 255), 10,
				app);
		square = new Square(50, 50, 50, 1, 255, 0, 255, 10, app);

		loadTXT = app.loadStrings("../data/TXT.txt");
		words = new ArrayList<String>();

		for (int i = 0; i < loadTXT.length; i++) {
			String[] tempArray = loadTXT[i].split("\\r\\n|\\n|\\r"); // to jump the line in the TXT

			for (int j = 0; j < tempArray.length; j++) {
				words.add(tempArray[j]);
			}
		}
	}

	public void drawCircle() {
		circle.drawFigure();
	}

	public void drawSquare() {
		square.drawFigure();
	}

	public void drawRandomFig() {
		for (int i = 0; i < figure.size(); i++) {
			figure.get(i).drawFigure();
			figure.get(i).move();
		}
	}

	public void addRandomFig() {

		int tam = (int) random(10, 80);
		int posX = (int) random(10, 580);
		int posY = (int) random(30, 100);
		int direction = 1;
		int value = (int) random(0, 11);

		int r = (int) random(0, 255);
		int g = (int) random(0, 255);
		int b = (int) random(0, 255);

		int randomFig = (int) random(0, 2); // Random status to create a figure between circle and square

		if (app.mouseButton == RIGHT) {
			switch (randomFig) {
			case 0:
				figure.add(new Circle(tam, posX, posY, direction, r, g, b, value, app));
				break;

			case 1:
				figure.add(new Square(tam, posX, posY, direction, r, g, b, value, app));
				break;
			}
		}
	}

	public void pauseFig() {
		for (int i = 0; i < figure.size(); i++) {
			if (app.mouseX > (figure.get(i).getPosX() - (figure.get(i).getTam() / 2))
					&& app.mouseX < (figure.get(i).getPosX() + (figure.get(i).getTam() / 2))
					&& app.mouseY > (figure.get(i).getPosY() - (figure.get(i).getTam() / 2))
					&& app.mouseY < (figure.get(i).getPosY() + (figure.get(i).getTam() / 2))) {
				figure.get(i).setMov(!figure.get(i).isMov());
			}
		}
	}

	public void hit() {
		boolean removed = false;
		for (int i = 0; i < figure.size() && removed == false; i++) {

			for (int j = 0; j < figure.size() && removed == false; j++) {
				if (!(figure.get(i) instanceof Triangle) && !(figure.get(j) instanceof Triangle)) {
					if (i != j) {
						if (PApplet.dist(figure.get(i).getPosX(), figure.get(i).getPosY(), figure.get(j).getPosX(),
								figure.get(j).getPosY()) <= figure.get(i).getTam() / 2 + figure.get(j).getTam() / 2) {

							addTriangle(figure.get(i).getPosX(), // posx to draw triangle
									figure.get(i).getPosY(), // posY to draw triangle
									figure.get(i).getValue() + figure.get(j).getValue());

							figure.remove(j);// Remove First figure
							figure.remove(i);// REmove second figure

							removed = true;
						}
					}
				}
			}
		}
	}

	private void addTriangle(int posX, int posY, int value) {
		int tam = (int) random(10, 80);
		int direction = 1;

		int r = (int) random(0, 255);
		int g = (int) random(0, 255);
		int b = (int) random(0, 255);

		figure.add(new Triangle(tam, posX, posY, direction, r, g, b, value, app));
	}
}