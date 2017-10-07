package com.trackey;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class MouseLineGenerator {
    static Color lineColour = new Color(255,255,255); //White

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

        for (int i = 0; i < points.size()-1; i++)
        {
            newImage.setRGB(points.get(i).x, points.get(i).y, lineColour.getRGB());
            ArrayList<Point> linePoints = new ArrayList<>();
            linePoints = generateLines(points.get(i), points.get(i+1));
        }

    }

    ArrayList<Point> generateLines(Point pointA, Point pointB) //uses brenseham
    {
        ArrayList<Point> pointList = new ArrayList<>();
        int m_new = 2 * (pointB.y - pointA.y);
        int slope_error_new = m_new - (pointA.x-pointB.x);

        for (int x = pointA.x, y = pointA.y; x < pointB.x; x++)
        {
            pointList.add(new Point(x,y));
        }
        return pointList;

    }
}
