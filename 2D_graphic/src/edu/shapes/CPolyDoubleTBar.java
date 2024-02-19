package edu.shapes;

import java.awt.*;

public class CPolyDoubleTBar extends CPoly{
    protected int A;
    protected int H;


    public CPolyDoubleTBar(int x0, int y0, Color f, Color b, int a , int h) {
        super(x0, y0, f, b, 12);
        this.A = a;
        this.H = h;
    }

    @Override
    protected void updateCoordinates() {
        px[0] = X0;                 py[0] = Y0;
        px[1] = X0;                 py[1] = Y0 - H + g;
        px[2] = X0 - (A/2) + (g/2); py[2] = Y0 - H + g;
        px[3] = X0 - (A/2) + (g/2); py[3] = Y0 - H;
        px[4] = X0 + (A/2) + (g/2); py[4] = Y0 - H;
        px[5] = X0 + (A/2) + (g/2); py[5] = Y0 - H + g;
        px[6] = X0 + g;             py[6] = Y0 - H + g;
        px[7] = X0 + g;             py[7] = Y0;
        px[8] = X0 + (A/2) + (g/2); py[8] = Y0;
        px[9] = X0 + (A/2) + (g/2); py[9] = Y0 + g;
        px[10] =X0 - (A/2) + (g/2); py[10] = Y0 + g;
        px[11] =X0 - (A/2) + (g/2); py[11] =Y0;
    }
}
