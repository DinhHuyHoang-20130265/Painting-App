package PaintApp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

public class MyLine implements PointAndLine {

	private Color color;
	private Line2D line;
	private BasicStroke stroke;

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(getStroke());
		g2.setColor(getColor());
		g2.drawLine((int) this.getLine().getX1(), (int) this.getLine().getY1(), (int) this.getLine().getX2(),
				(int) this.getLine().getY2());
	}

	public boolean contains(int x, int y) {
		Point p = new Point(x, y);
		return distance(new Point((int) line.getX1(), (int) line.getY1()), p)
				+ distance(new Point((int) line.getX2(), (int) line.getY2()), p) == distance(
						new Point((int) line.getX1(), (int) line.getY1()),
						new Point((int) line.getX2(), (int) line.getY2()));
	}

	public double distance(Point p1, Point p2) {
		return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
	}

	public void createShape(Point startPoint, Point endPoint) {
		Line2D ln = new Line2D.Float(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		setLine(ln);
		setColor(Main.selectColor);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Line2D getLine() {
		return line;
	}

	public void setLine(Line2D line) {
		this.line = line;
	}

	public BasicStroke getStroke() {
		return stroke;
	}

	public void setStroke(BasicStroke stroke) {
		this.stroke = stroke;
	}

	public double getX() {
		return line.getX1();
	}

	public double getY() {
		return line.getY1();
	}

	public void setX(int dx) {
		line = new Line2D.Float((float) dx, (float) line.getY1(), (float) line.getX2(), (float) line.getY2());
	}

	public void setY(int dy) {
		line = new Line2D.Float((float) line.getX1(), (float) dy, (float) line.getX2(), (float) line.getY2());
	}
}
