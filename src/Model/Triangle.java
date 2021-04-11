package Model;
import processing.core.PApplet;

public class Triangle extends Figure {

	public Triangle(int tam, int posX, int posY, int direction, int r, int g, int b, int value, PApplet app) {
		super(tam, posX, posY, direction, r, g, b, value, app);
	}

	protected void drawFigure() {
		app.fill(r, g, b);
		app.triangle(getPosX() - getTam() / 2, getPosY() + getTam() / 2, // first point
				getPosX(), getPosY() - getTam() / 2, // second point
				getPosX() + getTam() / 2, getPosY() + getTam() / 2); // third point

		app.fill(255);
		app.textAlign(CENTER);
		app.text(getValue(), getPosX(), getPosY() + getTam() / 3);
	}

}
