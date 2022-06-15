package PaintApp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ToolPanel extends JPanel {
	JComboBox<String> comboBox;
	StatusBar statusBar;

	public ToolPanel(StatusBar statusBar) {
		this.statusBar = statusBar;
		setBackground(Color.darkGray);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		Dimension SizeColorBox = new Dimension(getWidth(), 38);
		setPreferredSize(SizeColorBox);

		ActionButton action = new ActionButton(statusBar);

		JButton drawPoint = new JButton("Point");
		drawPoint.addActionListener(action);
		add(drawPoint);

		JButton drawCircle = new JButton("Circle");
		drawCircle.addActionListener(action);
		add(drawCircle);

		JButton drawLine = new JButton("Line");
		drawLine.addActionListener(action);
		add(drawLine);

		JButton drawSquare = new JButton("Square");
		drawSquare.addActionListener(action);
		add(drawSquare);

		JButton drawRect = new JButton("Rectangle");
		drawRect.addActionListener(action);
		add(drawRect);

		JButton drawOval = new JButton("Oval");
		drawOval.addActionListener(action);
		add(drawOval);

		JButton FillShape = new JButton("Fill color");
		FillShape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.select = "fill";
			}
		});
		add(FillShape);

		JButton Move = new JButton("Move");
		Move.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.select = "Move";
			}
		});
		add(Move);

		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.select = "Delete";
			}
		});
		add(Delete);

		JButton clearAll = new JButton("Clear All");
		clearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.shapes.clear();
				Main.contentPane.repaint();
			}
		});
		add(clearAll);
		String[] items = { "Line Width", "1", "2", "3", "4", "5", "6", "7", "8" };

		comboBox = new JComboBox(items);
		comboBox.setActionCommand("comboBox");
		comboBox.setMaximumSize(new Dimension(100, 25));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JComboBox combo = (JComboBox) e.getSource();
					String current = (String) combo.getSelectedItem();
					PaintArea.stroke = new BasicStroke(Float.parseFloat(current));
				} catch (NumberFormatException ae) {
				}
			}
		});
		add(comboBox);
	}

}
