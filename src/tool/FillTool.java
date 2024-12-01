package tool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FillTool extends Tool {

    private BufferedImage image;
    private int oldColor, newColor;

    public FillTool(int x, int y, int width, int height, Color color, BufferedImage image) {
        super(x, y, width, height, color);
        oldColor = image.getRGB(x,y);
        newColor = color.getRGB();
        this.image = image;
    }

    public void flood(int x, int y) {
        if(x < 0) return;
        if(y < 0) return;
        if(x >= image.getWidth()) return;
        if(y >= image.getHeight()) return;

        if(image.getRGB(x, y) != oldColor) return;

        image.setRGB(x, y, newColor);

        flood(x-1,y);
        flood(x-1,y);
        flood(x,y-1);
        flood(x,y+1);
    }

    @Override
    public void draw(Graphics2D g) {
        flood(x,y);
    }

    @Override
    public boolean contains(int px, int py) {
        return false; // FillTool ne contient pas de forme détectable
    }
}
