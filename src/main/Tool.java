package main;

import java.awt.*;

public abstract class Tool {

    protected int x, y, width, height;
    protected Color color;

    public void Tool(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void setAttributes(Graphics2D g) {
        g.setColor(color);
    }

    public abstract void draw(Graphics2D g);
}
