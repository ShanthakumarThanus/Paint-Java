package tool;

import java.awt.*;

public abstract class Tool {

    protected int x, y, width, height;
    protected Color color;

    public static final int CIRCLETOOL = 1;
    public static final int SQUARETOOL = 2;
    public static final int FILL_TOOL = 3;
    public static final int TRIANGLETOOL = 4;

    public Tool(int x, int y, int width, int height, Color color) {
        this.x = x - width / 2; // x soustrait par la largeur divisé par 2 pour centrer le curseur
        this.y = y - height / 2; // x soustrait par l'hauteur divisé par 2 pour centrer le curseur
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void setAttributes(Graphics2D g) {
        g.setColor(color);
    }

    public abstract void draw(Graphics2D g);

    public abstract boolean contains(int px, int py);
}
