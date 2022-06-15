package PaintApp;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Point;

public interface Shape {
	public void draw(Graphics g);

	public boolean contains(int x, int y);

	public void createShape(Point startPoint, Point endPoint);

	public BasicStroke getStroke();

	public void setStroke(BasicStroke stroke);

	public double getX();

	public double getY();

	public void setX(int dx);

	public void setY(int dy);
}