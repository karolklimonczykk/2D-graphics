package edu.shapes;

import java.awt.*;

public interface IDrawable {
    /**
     * Drawning the object
     * @param graphics the graphic area where the object will be drawn
     * @param selected informs if the given object is currently selected
     */
    void draw(Graphics graphics, boolean selected);


}
