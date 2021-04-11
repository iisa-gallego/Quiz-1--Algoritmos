package Model;

import processing.core.PApplet;

public abstract class Figure extends PApplet {

	PApplet app;
	protected int posX;
	protected int posY;
	protected int size;
	protected int dir;
	protected int value;
	protected int r, g, b;
	private boolean Mov;

	public Figure(int tam, int posX, int posY, int direction, int r, int g, int b, int value, PApplet app) {

		this.posX = posX;
		this.posY = posY;
		this.size = tam;
		this.dir = direction;
		this.app = app;
		this.value = value;
		this.r = r;
		this.g = g;
		this.b = b;
		Mov = true;
	}
	
	protected abstract void drawFigure();

	protected void move() {
		if (Mov) {
			posY += (2 * dir);
			if (posY + size / 2 <= 29 || posY + (size / 2) >= 580) {
				dir = dir * (-1); // this change the direction of the figures
			}
		}
	}

	public boolean isMov() {
		return Mov;
	}

	public void setMov(boolean isMov) {
		this.Mov = isMov;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getTam() {
		return size;
	}

	public int getValue() {
		return value;
	}

}
