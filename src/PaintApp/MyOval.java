package PaintApp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class MyOval implements OtherShape {
	private Ellipse2D elip2d;
	private Color linecolor = null;
	private Color color = null;
	private BasicStroke stroke;

	public void createShape(Point startPoint, Point endPoint) {
		setLineColor(Main.selectColor);
		Ellipse2D r = new Ellipse2D.Float(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y),
				Math.abs(startPoint.x - endPoint.x), Math.abs(startPoint.y - endPoint.y));

		this.setElip2d(r);
	}

	public void createOval(int x, int y, int w, int h) {
		Ellipse2D r = new Ellipse2D.Float(x, y, w, h);
		this.setElip2d(r);
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(getStroke());
		if (getColor() == null) {
			g2.setColor(getLineColor());
			g2.drawOval((int) getElip2d().getX(), (int) getElip2d().getY(), (int) getElip2d().getWidth(),
					(int) getElip2d().getHeight());
		} else {
			g2.setColor(getColor());
			g2.fillOval((int) getElip2d().getX(), (int) getElip2d().getY(), (int) getElip2d().getWidth(),
					(int) getElip2d().getHeight());
		}
	}

	public void fill(Color c) {
		this.setColor(c);
	}

	public boolean contains(int x, int y) {
		return this.getElip2d().contains(x, y);
	}

	public Ellipse2D getElip2d() {
		return elip2d;
	}

	public void setElip2d(Ellipse2D elip2d) {
		this.elip2d = elip2d;
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
		return elip2d.getWidth();
	}

	public double getHeight() {
		return elip2d.getHeight();
	}

	public void setWidth(int amount) {
		elip2d = new Ellipse2D.Float((float) elip2d.getX(), (float) elip2d.getY(), (float) amount,
				(float) elip2d.getHeight());
	}

	public void setHeight(int amount) {
		elip2d = new Ellipse2D.Float((float) elip2d.getX(), (float) elip2d.getY(), (float) elip2d.getWidth(),
				(float) amount);
	}

	public double getX() {
		return elip2d.getX();
	}

	public double getY() {
		return elip2d.getY();
	}

	public void setX(int dx) {
		elip2d = new Ellipse2D.Float((float) dx, (float) elip2d.getY(), (float) elip2d.getWidth(),
				(float) elip2d.getHeight());
	}

	public void setY(int dy) {
		elip2d = new Ellipse2D.Float((float) elip2d.getX(), (float) dy, (float) elip2d.getWidth(),
				(float) elip2d.getHeight());
	}
}
