package PaintApp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class MyCircle implements OtherShape {
	private Ellipse2D circle;
	private Color linecolor = null;
	private Color color = null;
	float radius;
	private BasicStroke stroke;

	public void createShape(Point startPoint, Point endPoint) {
		setLineColor(Main.selectColor);
		radius = (float) Math.sqrt((startPoint.x - endPoint.x) * (startPoint.x - endPoint.x)
				+ (startPoint.y - endPoint.y) * (startPoint.y - endPoint.y));
		Ellipse2D c = new Ellipse2D.Float(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y),
				radius, radius);
		this.setCircle(c);

	}

	public void createCircle(int x, int y, int w, int h) {
		Ellipse2D c = new Ellipse2D.Float(x, y, w, h);
		this.setCircle(c);
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(getStroke());
		if (getColor() == null) {
			g2.setColor(getLineColor());
			g2.drawOval((int) getCircle().getX(), (int) getCircle().getY(), (int) getCircle().getWidth(),
					(int) getCircle().getHeight());
		} else {
			g2.setColor(getColor());
			g2.fillOval((int) getCircle().getX(), (int) getCircle().getY(), (int) getCircle().getWidth(),
					(int) getCircle().getHeight());
		}
	}

	public void fill(Color c) {
		this.setColor(c);
	}

	public boolean contains(int x, int y) {
		return this.getCircle().contains(x, y);
	}

	public Ellipse2D getCircle() {
		return circle;
	}

	public void setCircle(Ellipse2D circle) {
		this.circle = circle;
	}

	public Color getLineColor() {
		return linecolor;
	}

	public void setLineColor(Color linecolor) {
		this.linecolor = linecolor;
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
		return circle.getWidth();
	}

	public double getHeight() {
		return circle.getHeight();
	}

	public void setWidth(int amount) {
		circle = new Ellipse2D.Float((float) circle.getX(), (float) circle.getY(), (float) amount,
				(float) circle.getHeight());
	}

	public void setHeight(int amount) {
		circle = new Ellipse2D.Float((float) circle.getX(), (float) circle.getY(), (float) circle.getWidth(),
				(float) amount);
	}

	public double getX() {
		return circle.getX();
	}

	public double getY() {
		return circle.getY();
	}

	public void setX(int dx) {
		circle = new Ellipse2D.Float((float) dx, (float) circle.getY(), (float) circle.getWidth(),
				(float) circle.getHeight());
	}

	public void setY(int dy) {
		circle = new Ellipse2D.Float((float) circle.getX(), (float) dy, (float) circle.getWidth(),
				(float) circle.getHeight());
	}
}
