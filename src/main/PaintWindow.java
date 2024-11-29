package main;

import javax.swing.JFrame;
import java.awt.Point;

public class PaintWindow {

    private static JFrame theWindow;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 700;
    private static PaintPanel thePanel;

    public static void main(String[] args) {

        theWindow = new JFrame("Paint");
        theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theWindow.setSize(WIDTH,HEIGHT);

        theWindow.setLocationRelativeTo(null); //au centre de l'écran, applicable uniquement après avoir defini wifth & height
        thePanel = new PaintPanel();

        theWindow.setResizable(false);
        theWindow.add(thePanel);
        theWindow.setVisible(true);
    }

    public static Point getWindowLocation() {
        return theWindow.getLocation();
    }
}
