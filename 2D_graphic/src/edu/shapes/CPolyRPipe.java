package edu.shapes;

import java.awt.*;
import java.awt.geom.Area;

public class CPolyRPipe extends CPoly{
    protected int A;
    protected int B;

    public CPolyRPipe(int x0, int y0, Color f, Color b, int a, int b1) {
        super(x0, y0, f, b, 10);
        this.A = a;
        this.B = b1;
    }

    @Override
    protected void updateCoordinates() {
        px[0] = X0;           py[0] = Y0;
        px[1] = X0;           py[1] = Y0 - B;
        px[2] = X0 + A;       py[2] = Y0 - B;
        px[3] = X0 + A;       py[3] = Y0 ;
        px[4] = X0;           py[4] = Y0 ;

        px[5] = X0 + g;       py[5] = Y0 - g;
        px[6] = X0 + g;       py[6] = Y0 - B + g;
        px[7] = X0 + A - g;   py[7] =  Y0 - B + g;
        px[8] = X0 + A - g;   py[8] = Y0 - g;
        px[9] = X0 + g;       py[9] = Y0 - g;


    }

    @Override
    protected void drawShape(Graphics2D g2d) {

        int[] ax = new int[4];
        int[] ay = new int[4];
        int[] bx = new int[4];
        int[] by = new int[4];
        ax[0] = X0;           ay[0] = Y0;
        ax[1] = X0;           ay[1] = Y0 - B;
        ax[2] = X0 + A;       ay[2] = Y0 - B;
        ax[3] = X0 + A;       ay[3] = Y0 ;


        bx[0] = X0 + g;       by[0] = Y0 - g;
        bx[1] = X0 + g;       by[1] = Y0 - B + g;
        bx[2] = X0 + A - g;   by[2] =  Y0 - B + g;
        bx[3] = X0 + A - g;   by[3] = Y0 - g;


        Polygon poly = new Polygon(ax,ay,4);


        Polygon poly2 = new Polygon(bx,by,4);
        Area area = new Area(poly);
        area.subtract(new Area(poly2));
        g2d.setColor(fillColor);
        g2d.fill(area);
        g2d.setColor(borderColor);
        g2d.draw(area);


    }
}
