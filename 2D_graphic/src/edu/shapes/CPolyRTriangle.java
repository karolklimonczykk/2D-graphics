package edu.shapes;

import java.awt.*;

public class CPolyRTriangle extends CPoly{
    protected int A;
    protected int B;

    public CPolyRTriangle(int x0, int y0, Color f, Color b, int a , int b1) {
        super(x0, y0, f, b, 3);
        this.A = a;
        this.B = b1;
    }

    @Override
    protected void updateCoordinates() {
        px[0] = X0;     py[0] = Y0;
        px[1] = X0 + A; py[1] = Y0;
        px[2] = X0;     py[2] = Y0 - B;
    }
    //uwaga do samodzielnego wyjaśnienia: dlaczego przy wyznaczaniu współrzędnej py[2]
    // występuje odejmowanie, a nie dodawanie
    /* ODPOWIEDŹ : Ponieważ oś Y jest skierowana do dołu, czyli wartość 0 jest na samej górze - im większa wartość tym
       niższe położenie. Dlatego jest odejmowanie - w przypadku dodania - punkt byłby niżej, więc trójkąt byłby odwrócony
       "do góry nogami"
    */
}
