package main;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PaintPanel extends JPanel {

    private Listener theListener;
    private int x, y;
    private OptionsWindow optionsWindow;

    public PaintPanel() {
        optionsWindow = new OptionsWindow();
        theListener = new Listener();
        this.addMouseListener(theListener);
        repaint(); //appel méthode paintComponent
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0, PaintWindow.WIDTH, PaintWindow.HEIGHT);
        g.setColor(Color.BLACK);
        g.fillOval(x,y,50,50);
    }

    private class Listener implements MouseListener {

        public void mouseClicked(MouseEvent e) {

        }

        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            repaint();
        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
    }
}