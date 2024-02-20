package edu.shapes;

import java.awt.*;

public class CPolyAngle extends CPoly{
    protected int A;
    protected int B;


    public CPolyAngle(int x0, int y0, Color f, Color b, int a , int b1) {
        super(x0, y0, f, b, 6);
        this.A = a;
        this.B = b1;
    }

    @Override
    protected void updateCoordinates() {
        px[0] = X0;     py[0] = Y0;
        px[1] = X0;     py[1] = Y0 - B;
        px[2] = X0 + g; py[2] = Y0 - B;
        px[3] = X0 + g; py[3] = Y0 - g;
        px[4] = X0 + A; py[4] = Y0 - g;
        px[5] = X0 + A; py[5] = Y0;
    }
}
