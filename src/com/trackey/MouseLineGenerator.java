package com.trackey;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MouseLineGenerator {

    void generateImage(ArrayList<Point> points)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        BufferedImage newImage = new BufferedImage(screenSize.width, screenSize.height, BufferedImage.TYPE_INT_RGB);

        ArrayList<Point> tempPoints = new ArrayList<>();
        tempPoints.add(new Point(1,1));
        tempPoints.add(new Point(6,6));
        tempPoints.add(new Point(9,7));
        tempPoints.add(new Point(15,8));
        tempPoints.add(new Point(22,11));
        tempPoints.add(new Point(30,14));
        tempPoints.add(new Point(50,23));
        tempPoints.add(new Point(59,0));
        tempPoints.add(new Point(23,50));
        tempPoints.add(new Point(100,100));
        tempPoints.add(new Point(900,900));

        points = tempPoints;

        for (int i = 0; i < points.size(); i++)
        {
        }

    }

    ArrayList<Point> generateLines(Point pointA, Point pointB)
    {

    }
}
