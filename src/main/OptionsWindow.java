package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class OptionsWindow {

    //fenêtre
    private JFrame theWindow;
    private JPanel thePanel;

    //slider pour selectioner les couleurs RGB
    private JSlider redSlider, greenSlider, bludeSlider;

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
        bludeSlider = new JSlider(0,255);
    }

    public void setAttributes() {
        redSlider.setBorder(BorderFactory.createTitledBorder("Rouge"));
        redSlider.setMajorTickSpacing(100);
        redSlider.setValue(100);
        redSlider.setPaintTicks(true);
        redSlider.setPaintLabels(true);

        greenSlider.setBorder(BorderFactory.createTitledBorder("Green"));
        greenSlider.setMajorTickSpacing(100);
        greenSlider.setValue(100);
        greenSlider.setPaintTicks(true);
        greenSlider.setPaintLabels(true);

        bludeSlider.setBorder(BorderFactory.createTitledBorder("Bleu"));
        bludeSlider.setMajorTickSpacing(100);
        bludeSlider.setValue(100);
        bludeSlider.setPaintTicks(true);
        bludeSlider.setPaintLabels(true);
    }

    public void addStuffToPanel() {
        thePanel.add(redSlider);
        thePanel.add(greenSlider);
        thePanel.add(bludeSlider);
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
}
