package PaintApp;

import java.awt.Color;

public interface OtherShape extends Shape {
	public void fill(Color color);

	public double getWidth();

	public double getHeight();

	public void setWidth(int amount);

	public void setHeight(int amount);
}