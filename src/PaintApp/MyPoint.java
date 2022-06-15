package PaintApp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class MyPoint implements PointAndLine {
	private Point point;
	private Color color = Color.black;
	private BasicStroke stroke;

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(getStroke());
		g2.setColor(getColor());
		g2.drawLine(getPoint().x, getPoint().y, getPoint().x, getPoint().y);
	}

	public boolean contains(int x, int y) {
		if (x == getPoint().x && y == getPoint().y) {
			return true;
		}
		return false;
	}

	public void createShape(Point startDrag, Point endDrag) {
		Point p = new Point(startDrag.x, startDrag.y);
		setPoint(p);
		setColor(Main.selectColor);
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
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

	public double getX() {
		return point.getX();
	}

	public double getY() {
		return point.getY();
	}

	public void setX(int dx) {
		this.point.x = dx;
	}

	public void setY(int dy) {
		this.point.y = dy;
	}
}
