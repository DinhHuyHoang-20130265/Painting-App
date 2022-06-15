package PaintApp;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyAction implements KeyListener {
	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_R:
			if (e.isControlDown())
				Main.selectColor = Color.RED;
			break;
		case KeyEvent.VK_B:
			if (e.isControlDown())
				Main.selectColor = Color.BLUE;
			break;
		case KeyEvent.VK_G:
			if (e.isControlDown())
				Main.selectColor = Color.GREEN;
			break;
		case KeyEvent.VK_P:
			if (e.isControlDown())
				Main.selectColor = Color.PINK;
			break;
		case KeyEvent.VK_Y:
			if (e.isControlDown())
				Main.selectColor = Color.YELLOW;
			break;
		}

	}

	public void keyReleased(KeyEvent e) {
	}
}
