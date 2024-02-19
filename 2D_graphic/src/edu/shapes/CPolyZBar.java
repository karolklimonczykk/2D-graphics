package edu.shapes;

import java.awt.*;

public class CPolyZBar extends CPoly{
    protected int A;
    protected int H;


    public CPolyZBar(int x0, int y0, Color f, Color b, int a , int h) {
        super(x0, y0, f, b, 8);
        this.A = a;
        this.H = h;
    }

    @Override
    protected void updateCoordinates() {
        px[0] = X0;         py[0] = Y0;
        px[1] = X0;         py[1] = Y0 - H + g;
        px[2] = X0 - A + g; py[2] = Y0 - H + g;
        px[3] = X0 - A + g; py[3] = Y0 - H;
        px[4] = X0 + g;     py[4] = Y0 - H;
        px[5] = X0 + g;     py[5] = Y0 - g;
        px[6] = X0 + A;     py[6] = Y0 - g;
        px[7] = X0 + A;     py[7] = Y0;
    }
}
