package PaintApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ColorChoosePanel extends JPanel {
	public ColorChoosePanel() {
		setLayout(new GridLayout(8, 2));
		setBorder(BorderFactory.createRaisedSoftBevelBorder());
		setBackground(Color.darkGray);
		Dimension SizeColorBox = new Dimension(60, 20);

		JButton red = new JButton();
		red.setPreferredSize(SizeColorBox);
		red.setMaximumSize(SizeColorBox);
		red.setBackground(Color.red);
		red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.selectColor = Color.red;
			}
		});
		add(red);

		JButton blue = new JButton();
		blue.setPreferredSize(SizeColorBox);
		blue.setMaximumSize(SizeColorBox);
		blue.setBackground(Color.blue);
		blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.selectColor = Color.blue;
			}
		});
		add(blue);

		JButton green = new JButton();
		green.setPreferredSize(SizeColorBox);
		green.setMaximumSize(SizeColorBox);
		green.setBackground(Color.green);
		green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.selectColor = Color.green;
			}
		});
		add(green);

		JButton cyan = new JButton();
		cyan.setPreferredSize(SizeColorBox);
		cyan.setMaximumSize(SizeColorBox);
		cyan.setBackground(Color.cyan);
		cyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.selectColor = Color.cyan;
			}
		});
		add(cyan);

		JButton darkGray = new JButton();
		darkGray.setPreferredSize(SizeColorBox);
		darkGray.setMaximumSize(SizeColorBox);
		darkGray.setBackground(Color.black);
		darkGray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.selectColor = Color.black;
			}
		});
		add(darkGray);

		JButton orange = new JButton();
		orange.setPreferredSize(SizeColorBox);
		orange.setMaximumSize(SizeColorBox);
		orange.setBackground(Color.orange);
		orange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.selectColor = Color.orange;
			}
		});
		add(orange);

		JButton pink = new JButton();
		pink.setPreferredSize(SizeColorBox);
		pink.setMaximumSize(SizeColorBox);
		pink.setBackground(Color.pink);
		pink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.selectColor = Color.pink;
			}
		});
		add(pink);

		JButton lightGray = new JButton();
		lightGray.setPreferredSize(SizeColorBox);
		lightGray.setMaximumSize(SizeColorBox);
		lightGray.setBackground(Color.lightGray);
		lightGray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.selectColor = Color.lightGray;
			}
		});
		add(lightGray);
	}
}
