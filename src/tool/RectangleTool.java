package tool;

import java.awt.*;

public class RectangleTool extends Tool {

    public RectangleTool(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics2D g) {
        // Dessiner un rectangle basé sur les coordonnées (x, y) et les dimensions (width, height)
        g.setColor(color);
        g.fillRect(x - width / 2, y - height / 2, width, height); // Le rectangle est dessiné avec le coin supérieur gauche comme point de départ
    }

    @Override
    public boolean contains(int px, int py) {
        // Vérifier si le point (px, py) est à l'intérieur du rectangle
        // Le rectangle est centré autour de (x, y) avec une largeur 'width' et une hauteur 'height'
        return px >= x - width / 2 && px <= x + width / 2 &&
                py >= y - height / 2 && py <= y + height / 2;
    }
}
