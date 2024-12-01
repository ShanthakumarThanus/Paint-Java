package tool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FillTool extends Tool {

    private BufferedImage image;
    private int oldColor, newColor;

    public FillTool(int x, int y, int width, int height, Color color,
                    BufferedImage image, int oldColor, int newColor) {
        super(x, y, width, height, color);
    }

    public void flood(int x, int y, int oldColor, int newColor) {
        
    }

    @Override
    public void draw(Graphics2D g) {
        flood(x, y, oldColor, newColor);
    }
}
