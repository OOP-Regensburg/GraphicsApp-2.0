package de.ur.mi.graphics;

import de.ur.mi.graphicsapp.GraphicsApp;

/**
 * Created by Florin Schwappach on 16.06.2017.
 */
public class GraphicsObject {

    protected double x;
    protected double y;

    protected double width;
    protected double height;
    protected double borderWeight;

    protected Color borderColor;
    protected Color fillColor;

    protected boolean mousePressed;

    public GraphicsObject(GraphicsApp graphicsApp, double x, double y, int width, int height, Color color) {
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;
        this.fillColor = color;

        //borderColor = Color.BLACK;
        borderWeight = 0;

        graphicsApp.addObject(this);
    }
}
