package tool;

import java.awt.*;

public class CircleTool extends Tool {

    public CircleTool(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics2D g) {
        g.fillOval(x,y,width,height);
    }

    @Override
    public boolean contains(int px, int py) {
        return false;
    }
}
