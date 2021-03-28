package Compulsory.Poligon;

import java.awt.*;

/**
 * Class that describe a regular polygon
 */
public class RegularPoligon extends Polygon {
    public RegularPoligon(int x0, int y0, int radius, int sides) {
        double alpha = 2 * Math.PI / sides;
        for (int i = 0; i < sides; i++) {
            double x = x0 + radius * Math.cos(alpha * i);
            double y = y0 + radius * Math.sin(alpha * i);
            this.addPoint((int) x, (int) y);
        }
    }
}
