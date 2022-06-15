package PaintApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;

public class ActionButton implements ActionListener {

    StatusBar statusBar;

    public ActionButton(StatusBar statusBar) {
        this.statusBar = statusBar;
    }

    public void actionPerformed(ActionEvent e) {
        String com = e.getActionCommand();
        if (com.equals("Point")) {
            Main.select = "Point";
            statusBar.setMessage("Point choosed");
        } else if (com.equals("Line")) {
            Main.select = "Line";
            statusBar.setMessage("Line choosed");
        } else if (com.equals("Oval")) {
            Main.select = "Oval";
            statusBar.setMessage("Oval choosed");
        } else if (com.equals("Rectangle")) {
            Main.select = "Rectangle";
            statusBar.setMessage("Rectangle choosed");
        } else if (com.equals("Circle")) {
            Main.select = "Circle";
            statusBar.setMessage("Circle choosed");
        } else if (com.equals("Square")) {
            Main.select = "Square";
            statusBar.setMessage("Square choosed");
        }
    }

}
