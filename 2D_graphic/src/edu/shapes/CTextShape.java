package edu.shapes;

import java.awt.*;

public class CTextShape implements IShape {
    protected int x;
    protected int y;
    protected String text;
    protected Font font;
    protected Color fillColor;

    private static final Font DEFAULT_FONT = new Font("Calibre", Font.BOLD, 30);
    private int offsetX;
    private int offsetY;

    public CTextShape(int x, int y, String text, Color fillColor) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.font = DEFAULT_FONT;
        this.fillColor = fillColor;
    }

    @Override
    public void draw(Graphics graphics, boolean selected) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setFont(font);
        g2d.setColor(fillColor);

        g2d.drawString(text, x, y);

        if (selected) {
            g2d.setStroke(new BasicStroke(2));
            g2d.drawRect(x, y - font.getSize(), g2d.getFontMetrics(font).stringWidth(text), font.getSize());
        }
    }

    @Override
    public void moveBy(int dx, int dy) {
        x += dx - offsetX;
        y += dy - offsetY;
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = x - offsetX;
        this.y = y - offsetY;
    }

    @Override
    public boolean select(int xk, int yk) {
        boolean res = (xk >= x && xk <= x + getTextWidth() && yk >= y - getTextHeight() && yk <= y);
        if (res) {
            offsetX = xk - x;
            offsetY = yk - y;
        } else {
            offsetX = 0;
            offsetY = 0;
        }
        return res;
    }

    private int getTextWidth() {
        return new Canvas().getFontMetrics(font).stringWidth(text);
    }

    private int getTextHeight() {
        return new Canvas().getFontMetrics(font).getHeight();
    }
}
