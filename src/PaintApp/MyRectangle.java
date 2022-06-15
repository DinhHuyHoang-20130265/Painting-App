package PaintApp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class MyRectangle implements OtherShape {
	private Rectangle rect;
	private Color lineColor;
	private Color color = null;
	private BasicStroke stroke;

	public MyRectangle() {
		this.rect = rect;
	}

	public void createShape(Point startPoint, Point endPoint) {
		setLineColor(Main.selectColor);
		Rectangle r = new Rectangle(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y),
				Math.abs(startPoint.x - endPoint.x), Math.abs(startPoint.y - endPoint.y));
		this.setRect(r);
	}

	public void makeRectangle(int x, int y, int w, int h) {
		Rectangle r = new Rectangle(x, y, w, h);
		this.setRect(r);
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(getStroke());
		if (getColor() == null) {
			g2.setColor(this.getLineColor());
			g2.drawRect(this.getRect().x, this.getRect().y, this.getRect().width, this.getRect().height);
		} else {
			g2.setColor(this.getColor());
			g2.fillRect(this.getRect().x, this.getRect().y, this.getRect().width, this.getRect().height);
			g2.drawRect(this.getRect().x, this.getRect().y, this.getRect().width, this.getRect().height);
		}
	}

	public void fill(Color c) {
		this.setColor(c);
	}

	public boolean contains(int x, int y) {
		return this.getRect().contains(x, y);
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
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
		return stroke;
	}

	public void setStroke(BasicStroke stroke) {
		this.stroke = stroke;
	}

	public double getWidth() {
		return rect.getWidth();
	}

	public double getHeight() {
		return rect.getHeight();
	}

	public void setWidth(int amount) {
		this.rect.width = amount;
	}

	public void setHeight(int amount) {
		this.rect.height = amount;
	}

	public double getX() {
		return rect.getX();
	}

	public double getY() {
		return rect.getY();
	}

	public void setX(int dx) {
//		rect = new Rectangle(dx, (int) rect.getY(), rect.width, rect.height);
		this.rect.x = dx;
	}

	public void setY(int dy) {
		this.rect.y = dy;
	}
}
