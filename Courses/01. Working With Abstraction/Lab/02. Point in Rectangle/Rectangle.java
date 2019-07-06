package com.company;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {

        boolean insideX = false;

        if (point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX()) insideX = true;

        boolean insideY = false;

        if (point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY()) insideY = true;

        return insideX && insideY;
    }

}
