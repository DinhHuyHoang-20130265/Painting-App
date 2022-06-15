package PaintApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class Main extends JFrame {

	public static String select = "Point";
	public static Color selectColor = Color.black;
	public static ArrayList<Shape> shapes = new ArrayList<Shape>();
	ToolPanel toolPanel;
	PaintArea paintArea;
	ColorChoosePanel colorChoose;
	StatusBar statusBar;
	public static JPanel contentPane;

	public Main() {
		super("Simple Paint");
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);

		statusBar = new StatusBar();
		colorChoose = new ColorChoosePanel();
		paintArea = new PaintArea(statusBar);
		toolPanel = new ToolPanel(statusBar);

		contentPane.add(toolPanel, BorderLayout.NORTH);
		contentPane.add(paintArea, BorderLayout.CENTER);
		contentPane.add(colorChoose, BorderLayout.WEST);
		contentPane.add(statusBar, BorderLayout.SOUTH);
		menuBar();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setMinimumSize(getSize());
		setVisible(true);
	}

	private void menuBar() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);

		JMenuItem exit = new JMenuItem("Exit", KeyEvent.VK_E);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menu.add(exit);
		JMenu modify = new JMenu("Modify");
		menuBar.add(modify);
		JMenuItem setBgColor = new JMenuItem("Set Background Color");
		setBgColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color initialcolor = Color.RED;
				Color color = JColorChooser.showDialog(null, "Select a color", initialcolor);
				contentPane.setBackground(color);
			}
		});
		modify.add(setBgColor);
		JMenuItem DrawColor = new JMenuItem("More Draw Color");
		DrawColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color initialcolor = Color.RED;
				Color color = JColorChooser.showDialog(null, "Select a color", initialcolor);
				selectColor = color;
			}
		});
		modify.add(DrawColor);
	}

	public static void main(String[] args) {
		new Main();
	}
}
