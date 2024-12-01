package tool;

import java.awt.*;

public abstract class Tool {

    protected int x, y, width, height;
    protected Color color;

    public Tool(int x, int y, int width, int height, Color color) {
        this.x = x - width / 2; // x soustrait par la largeur divisé par 2 pour centrer le curseur
        this.y = y - height / 2; // x soustrait par l'hauteur divisé par 2 pour centrer le curseur
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void setAttributes(Graphics2D g) {
        g.setColor(color);
    }

    public abstract void draw(Graphics2D g);
}
