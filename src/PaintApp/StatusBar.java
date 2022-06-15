package PaintApp;

import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.*;

public class StatusBar extends JPanel {
	JLabel status;
	JLabel locate;

	public StatusBar() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		status = new JLabel("ready");
		locate = new JLabel("x: " + "y: ");
		add(status);
		add(locate);
	}

	public void setMessage(String text) {
		this.status.setText(text);
	}

	public void setLocation(Point p) {
		this.locate.setText("x: " + p.x + ", y: " + p.y);
	}
}
