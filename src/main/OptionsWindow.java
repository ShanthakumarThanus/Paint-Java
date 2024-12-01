package main;

import tool.Tool;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsWindow {

    //panel
    private JFrame theWindow;
    private JPanel thePanel;

    //slider pour selectioner les couleurs RGB + largeur et hauteur du curseur
    private JSlider redSlider, greenSlider, blueSlider, widthSlider, heightSlider;


    //boutons
    private JButton circleToolBut, squareToolBut, fillBut, triangleToolbut;

    //listener
    private OptionsListener theOptionsListener;

    // outil sélectionné
    private int currentTool;

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
        widthSlider = new JSlider(0,100);
        heightSlider = new JSlider(0,100);
        theOptionsListener = new OptionsListener();
        circleToolBut = new JButton("Cercle");
        squareToolBut = new JButton("Carré");
        fillBut = new JButton("Remplir");
        triangleToolbut = new JButton("Triangle");
        currentTool = Tool.CIRCLETOOL; //outil selectionné par defaut
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

        widthSlider.setBorder(BorderFactory.createTitledBorder("Largeur du pinceau"));
        widthSlider.setMajorTickSpacing(20);
        widthSlider.setValue(2);
        widthSlider.setPaintTicks(true);
        widthSlider.setPaintLabels(true);
        widthSlider.addChangeListener(theOptionsListener);

        heightSlider.setBorder(BorderFactory.createTitledBorder("Hauteur du pinceau"));
        heightSlider.setMajorTickSpacing(20);
        heightSlider.setValue(2);
        heightSlider.setPaintTicks(true);
        heightSlider.setPaintLabels(true);
        heightSlider.addChangeListener(theOptionsListener);

        circleToolBut.addActionListener(theOptionsListener);
        squareToolBut.addActionListener(theOptionsListener);
        fillBut.addActionListener(theOptionsListener);
        triangleToolbut.addActionListener(theOptionsListener);
    }

    public void addStuffToPanel() {
        thePanel.add(redSlider);
        thePanel.add(greenSlider);
        thePanel.add(blueSlider);
        thePanel.add(widthSlider);
        thePanel.add(heightSlider);
        thePanel.add(circleToolBut);
        thePanel.add(squareToolBut);
        thePanel.add(fillBut);
        thePanel.add(triangleToolbut);
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
    public int getWidthValue() { return widthSlider.getValue(); }
    public int getHeightValue() { return heightSlider.getValue(); }
    public int getCurrentTool() { return currentTool; }

    private class OptionsListener implements ChangeListener, ActionListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            int red = redSlider.getValue();
            int green = greenSlider.getValue();
            int blue = blueSlider.getValue();
            Color c = new Color(red, green, blue);
            thePanel.setBackground(c);
            redSlider.setBackground(c);
            greenSlider.setBackground(c);
            blueSlider.setBackground(c);
            widthSlider.setBackground(c);
            heightSlider.setBackground(c);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == circleToolBut) {
                currentTool = Tool.CIRCLETOOL;
            } else if (e.getSource() == squareToolBut) {
                currentTool = Tool.SQUARETOOL;
            } else if (e.getSource() == triangleToolbut) {
                currentTool = Tool.TRIANGLETOOL;
            }
        }

    }
}
