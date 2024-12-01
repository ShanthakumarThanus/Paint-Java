package tool;

import java.awt.*;

public class TriangleTool extends Tool {

    public TriangleTool(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics2D g) {
        // Dessiner un triangle basé sur les coordonnées (x, y) et les dimensions (width, height)
        // Le sommet du triangle est en (x, y), et la base est en dessous
        int[] xPoints = {x, x + width / 2, x - width / 2}; // Points X du triangle (centrés autour de x)
        int[] yPoints = {y - height, y, y};                // Points Y du triangle, sommet en haut et base en bas
        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, 3); // Dessiner le triangle rempli
    }

    @Override
    public boolean contains(int px, int py) {
        // Logique pour vérifier si le point (px, py) est à l'intérieur du triangle
        // Cette méthode devra être modifiée pour tenir compte de la géométrie du triangle
        int[] xPoints = {x, x + width / 2, x - width / 2};
        int[] yPoints = {y - height, y, y};
        Polygon triangle = new Polygon(xPoints, yPoints, 3);
        return triangle.contains(px, py);
    }
}
