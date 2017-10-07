package com.trackey;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class MouseLineGenerator {
    static Color lineColour = new Color(255,255,255); //White

    void generateImage(ArrayList<Point> points) throws IOException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        BufferedImage newImage = new BufferedImage(screenSize.width, screenSize.height, BufferedImage.TYPE_INT_RGB);

        ArrayList<Point> tempPoints = new ArrayList<>();
        tempPoints.add(new Point(500,500));
        tempPoints.add(new Point(700,700));
        tempPoints.add(new Point(500,899));
        tempPoints.add(new Point(300,700));
        tempPoints.add(new Point(500,500));


        points = tempPoints;

        for (int i = 0; i < points.size()-1; i++)
        {
            newImage.setRGB(points.get(i).x, points.get(i).y, lineColour.getRGB());
            ArrayList<Point> linePoints = new ArrayList<>();
            linePoints = generateLines(points.get(i), points.get(i+1));
            for (int j = 0; j < linePoints.size(); j++)
            {
                System.out.println(linePoints.get(j));
                newImage.setRGB(linePoints.get(j).x, linePoints.get(j).y, lineColour.getRGB());
                System.out.println("drawn \n");
            }
        }

        File outputFile = new File("mouse.png");
        ImageIO.write(newImage, "png", outputFile);
    }

    ArrayList<Point> generateLines(Point pointA, Point pointB) //uses brenseham
    {
        ArrayList<Point> pointList = new ArrayList<>();
        int x, x2, y, y2;
        x = pointA.x;
        x2 = pointB.x;
        y = pointA.y;
        y2 = pointB.y;
        int w = x2 - x ;
        int h = y2 - y ;

        int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0 ;
        if (w<0) dx1 = -1 ; else if (w>0) dx1 = 1 ;
        if (h<0) dy1 = -1 ; else if (h>0) dy1 = 1 ;
        if (w<0) dx2 = -1 ; else if (w>0) dx2 = 1 ;
        int longest = Math.abs(w) ;
        int shortest = Math.abs(h) ;
        if (!(longest>shortest)) {
            longest = Math.abs(h) ;
            shortest = Math.abs(w) ;
            if (h<0) dy2 = -1 ; else if (h>0) dy2 = 1 ;
            dx2 = 0 ;
        }
        int numerator = longest >> 1 ;
        for (int i=0;i<=longest;i++) {
            pointList.add(new Point(x, y));
            numerator += shortest;
            if (!(numerator < longest)) {
                numerator -= longest;
                x += dx1;
                y += dy1;
            } else {
                x += dx2;
                y += dy2;
            }
        }
        return pointList;
    }
}