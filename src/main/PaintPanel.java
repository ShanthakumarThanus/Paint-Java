package main;

import tool.CircleTool;
import tool.Tool;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class PaintPanel extends JPanel {

    private Listener theListener;
    private OptionsWindow optionsWindow;
    private Graphics2D g2;
    private BufferedImage image;

    //attribut de tool
    private Color toolColor;
    private int toolX, toolY, toolRed, toolGreen, toolBlue, toolWidth, toolHeight;
    private List<Tool> strokes;

    public static final int SCALE = 8;

    public PaintPanel(OptionsWindow optionsWindow) {
        this.optionsWindow = optionsWindow;
        theListener = new Listener();
        this.addMouseListener(theListener);
        this.addMouseMotionListener(theListener);
        image = new BufferedImage(PaintWindow.WIDTH / SCALE, PaintWindow.HEIGHT / SCALE, BufferedImage.TYPE_INT_RGB);
        g2 = (Graphics2D) image.getGraphics();
        strokes = new ArrayList<Tool>();
        draw();
        repaint();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, PaintWindow.WIDTH, PaintWindow.HEIGHT, null);
    }

    public void draw() {
        drawBackground();
        drawStrokes();
    }

    public void drawBackground() {
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0, image.getWidth(), image.getHeight());
    }

    public void drawStrokes() {
        for(Tool t : strokes) {
            t.setAttributes(g2);
            t.draw(g2);
        }
    }

    public void addStroke(MouseEvent e) {
        toolX = e.getX() / SCALE;
        toolY = e.getY() / SCALE;
        toolWidth = 20;
        toolHeight = 20;
        toolRed = optionsWindow.getRedValue();
        toolGreen = optionsWindow.getGreenValue();
        toolBlue = optionsWindow.getBlueValue();
        toolColor = new Color(toolRed, toolGreen, toolBlue);
        strokes.add(new CircleTool(toolX, toolY, toolWidth, toolHeight, toolColor));
        draw();
        repaint();
    }

    private class Listener implements MouseListener, MouseMotionListener {

        public void mouseClicked(MouseEvent e) {

        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            addStroke(e);
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
