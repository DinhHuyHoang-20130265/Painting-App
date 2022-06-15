package PaintApp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class MySquare implements OtherShape {
	private Rectangle square;
	private Color lineColor;
	private Color color = null;
	private BasicStroke stroke;

	public void createShape(Point startPoint, Point endPoint) {
		setLineColor(Main.selectColor);
		Rectangle sq = new Rectangle(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y),
				Math.abs(startPoint.x - endPoint.x), Math.abs(startPoint.x - endPoint.x));
		this.setSquare(sq);
	}

	public void makeRectangle(int x, int y, int w, int h) {
		Rectangle sq = new Rectangle(x, y, w, h);
		this.setSquare(sq);
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(getStroke());
		if (getColor() == null) {
			g2.setColor(this.getLineColor());
			g2.drawRect(this.getSquare().x, this.getSquare().y, this.getSquare().width, this.getSquare().height);
		} else {
			g2.setColor(this.getColor());
			g2.fillRect(this.getSquare().x, this.getSquare().y, this.getSquare().width, this.getSquare().height);
			g2.drawRect(this.getSquare().x, this.getSquare().y, this.getSquare().width, this.getSquare().height);
		}
	}

	public void fill(Color c) {
		this.setColor(c);
	}

	public boolean contains(int x, int y) {
		return this.getSquare().contains(x, y);
	}

	public Rectangle getSquare() {
		return square;
	}

	public void setSquare(Rectangle sqr) {
		this.square = sqr;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public BasicStroke getStroke() {
		return this.stroke;
	}

	public void setStroke(BasicStroke stroke) {
		this.stroke = stroke;
	}

	public double getWidth() {
		return square.getWidth();
	}

	public double getHeight() {
		return square.getHeight();
	}

	public void setWidth(int amount) {
		this.square.width = amount;
	}

	public void setHeight(int amount) {
		this.square.height = amount;
	}

	public double getX() {
		return square.getX();
	}

	public double getY() {
		return square.getY();
	}

	public void setX(int dx) {
//		square = new Rectangle(dx, (int) rect.getY(), rect.width, rect.height);
		this.square.x = dx;
	}

	public void setY(int dy) {
		this.square.y = dy;
	}
}
