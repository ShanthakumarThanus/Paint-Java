package main;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class OptionsWindow {

    //panel
    private JFrame theWindow;
    private JPanel thePanel;

    //slider pour selectioner les couleurs RGB
    private JSlider redSlider, greenSlider, blueSlider;

    //listener
    private OptionsListener theOptionsListener;


    public static final int WIDTH = 220;

    public OptionsWindow() {
        initializeFields();
        setAttributes();
        addStuffToPanel();
        createWindow();
    }

    // options de la fenêtre
    public void initializeFields() {
        theWindow = new JFrame("Options");
        thePanel = new JPanel();
        redSlider = new JSlider(0,255);
        greenSlider = new JSlider(0,255);
        blueSlider = new JSlider(0,255);
        theOptionsListener = new OptionsListener();
    }

    public void setAttributes() {
        redSlider.setBorder(BorderFactory.createTitledBorder("Rouge"));
        redSlider.setMajorTickSpacing(100);
        redSlider.setValue(100);
        redSlider.setPaintTicks(true);
        redSlider.setPaintLabels(true);
        redSlider.addChangeListener(theOptionsListener);

        greenSlider.setBorder(BorderFactory.createTitledBorder("Vert"));
        greenSlider.setMajorTickSpacing(100);
        greenSlider.setValue(100);
        greenSlider.setPaintTicks(true);
        greenSlider.setPaintLabels(true);
        greenSlider.addChangeListener(theOptionsListener);

        blueSlider.setBorder(BorderFactory.createTitledBorder("Bleu"));
        blueSlider.setMajorTickSpacing(100);
        blueSlider.setValue(100);
        blueSlider.setPaintTicks(true);
        blueSlider.setPaintLabels(true);
        blueSlider.addChangeListener(theOptionsListener);
    }

    public void addStuffToPanel() {
        thePanel.add(redSlider);
        thePanel.add(greenSlider);
        thePanel.add(blueSlider);
    }

    public void createWindow() {
        theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theWindow.setResizable(false); // fenêtre à taille statique
        theWindow.setSize(WIDTH,PaintWindow.HEIGHT);

        Point locationPoint = PaintWindow.getWindowLocation();
        locationPoint.setLocation(locationPoint.getX() - WIDTH,locationPoint.getY());
        theWindow.setLocation(locationPoint);
        theWindow.add(thePanel);
        theWindow.setVisible(true);
    }

    public int getRedValue() { return redSlider.getValue(); }
    public int getGreenValue() { return greenSlider.getValue(); }
    public int getBlueValue() { return blueSlider.getValue(); }

    private class OptionsListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            int red = redSlider.getValue();
            int green = greenSlider.getValue();
            int blue = blueSlider.getValue();
            Color c = new Color(red, green, blue);
            thePanel.setBackground(c);
        }
    }
}
