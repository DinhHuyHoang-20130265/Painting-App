package PaintApp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JComponent;
import javax.swing.*;

public class PaintArea extends JComponent {
	public Point firstPoint, lastPoint;
	public Shape ptemp;
	StatusBar statusBar;
	public static BasicStroke stroke = new BasicStroke((float) 1);

	public PaintArea(StatusBar statusBar) {
		this.statusBar = statusBar;
		MouseAdapter mouse = new MouseAdapter() {
			private int x, dx;
			private int y, dy;

			public void mousePressed(MouseEvent e) {
				requestFocusInWindow();
				firstPoint = new Point(e.getX(), e.getY());
				lastPoint = firstPoint;
				if (Main.select == "Move") {
					x = e.getX();
					y = e.getY();
					return;
				}
				if (Main.select == "Delete") {
					for (int i = Main.shapes.size() - 1; i >= 0; i--) {
						Shape pt = Main.shapes.get(i);
						if (pt.contains(firstPoint.x, firstPoint.y)) {
							ptemp = null;
							Main.shapes.remove(pt);
							break;
						}
					}
				}
			}

			public void mouseReleased(MouseEvent e) {
				Point p = new Point(e.getX(), e.getY());
				if (Main.select == "Rectangle") {
					MyRectangle obj = new MyRectangle();
					obj.createShape(firstPoint, p);
					Main.shapes.add(obj);
				} else if (Main.select == "Oval") {
					MyOval obj = new MyOval();
					obj.createShape(firstPoint, p);
					Main.shapes.add(obj);
				} else if (Main.select == "Square") {
					MySquare obj = new MySquare();
					obj.createShape(firstPoint, p);
					Main.shapes.add(obj);
				} else if (Main.select == "Point") {
					MyPoint obj = new MyPoint();
					obj.createShape(firstPoint, p);
					Main.shapes.add(obj);
				} else if (Main.select == "Line") {
					MyLine obj = new MyLine();
					obj.createShape(firstPoint, p);
					Main.shapes.add(obj);
				} else if (Main.select == "Circle") {
					MyCircle obj = new MyCircle();
					obj.createShape(firstPoint, p);
					Main.shapes.add(obj);
				} else if (Main.select == "fill") {
					for (int i = Main.shapes.size() - 1; i >= 0; i--) {
						Shape pt = Main.shapes.get(i);
						try {
							OtherShape s = (OtherShape) pt;
							if (s.contains(firstPoint.x, firstPoint.y)) {
								try {
									s.fill(Main.selectColor);
								} catch (Exception ex) {
								}
								break;
							}
						} catch (Exception ex) {
						}
					}
				}
				statusBar.setMessage("ready");
				statusBar.setLocation(new Point(0, 0));
				firstPoint = null;
				lastPoint = null;
				repaint();
			}

			public void mouseDragged(MouseEvent e) {
				if (Main.select == "Move") {
					for (int i = Main.shapes.size() - 1; i >= 0; i--) {
						dx = e.getX() - x;
						dy = e.getY() - y;
						Shape sh = Main.shapes.get(i);
						if (sh.contains(x, y)) {
							sh.setX((int) (sh.getX() + dx));
							sh.setY((int) (sh.getY() + dy));
							repaint();
							x += dx;
							y += dy;
						}
					}
				}
				lastPoint = new Point(e.getX(), e.getY());
				statusBar.setLocation(e.getPoint());
				repaint();
			}
		};
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		addKeyListener(new KeyAction());
		addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
					for (Shape sh : Main.shapes) {
						try {
							OtherShape s = (OtherShape) sh;
							if (s.contains(e.getPoint().x, e.getPoint().y)) {
								try {
									float amount = e.getWheelRotation() * 5f;
									s.setWidth((int) (s.getWidth() + amount));
									s.setHeight((int) (s.getHeight() + amount));
									repaint();
								} catch (Exception ex) {
								}
							}
						} catch (Exception ex1) {
						}
					}
				}
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (Shape pt : Main.shapes) {
			pt.setStroke(stroke);
			pt.draw(g2);
		}
		if (firstPoint != null && lastPoint != null) {
			if (Main.select == "Rectangle") {
				MyRectangle obj = new MyRectangle();
				obj.createShape(firstPoint, lastPoint);
				obj.setStroke(stroke);
				obj.draw(g2);
				repaint();
			} else if (Main.select == "Oval") {
				MyOval obj = new MyOval();
				obj.createShape(firstPoint, lastPoint);
				obj.setStroke(stroke);
				obj.draw(g2);
				repaint();
			} else if (Main.select == "Square") {
				MySquare obj = new MySquare();
				obj.createShape(firstPoint, lastPoint);
				obj.setStroke(stroke);
				obj.draw(g2);
				repaint();
			} else if (Main.select == "Point") {
				MyPoint obj = new MyPoint();
				obj.createShape(firstPoint, lastPoint);
				obj.setStroke(stroke);
				obj.draw(g2);
				repaint();
			} else if (Main.select == "Line") {
				MyLine obj = new MyLine();
				obj.createShape(firstPoint, lastPoint);
				obj.setStroke(stroke);
				obj.draw(g2);
				repaint();
			} else if (Main.select == "Circle") {
				MyCircle obj = new MyCircle();
				obj.createShape(firstPoint, lastPoint);
				obj.setStroke(stroke);
				obj.draw(g2);
				repaint();
			}
		}
	}
}
