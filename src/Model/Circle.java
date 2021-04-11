package Model;
import processing.core.PApplet;

public class Circle extends Figure {

	public Circle(int tam, int posX, int posY, int direction, int r, int g, int b, int value, PApplet app) {
		super(tam, posX, posY, direction, r, g, b, value, app);
	}

	protected void drawFigure() {
		// the circle
		app.fill(r, g, b);
		app.ellipse(posX, posY, size, size);
		// the text
		app.fill(0);
		app.textAlign(CENTER);
		app.text(getValue(), getPosX(), getPosY());

	}
}
