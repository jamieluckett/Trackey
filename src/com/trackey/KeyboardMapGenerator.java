package com.trackey;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class KeyboardMapGenerator
{
    void generateHeatmap(Map<String, Integer> dict, int noOfPresses) {
        int highestNumberOfPresses = 10;
        int step = 255/highestNumberOfPresses;

        
        BufferedImage newImage = new BufferedImage(1024, 341, BufferedImage.TYPE_INT_RGB);
        Map locations = new HashMap<String, Point>();
        locations.put("Q", new Point(103, 69));
        locations.put("W", new Point(172, 69));
        locations.put("E", new Point(240, 69));
        locations.put("R", new Point(308, 69));
        locations.put("T", new Point(376, 69));
        locations.put("Y", new Point(444, 69));
        locations.put("U", new Point(512, 69));
        locations.put("I", new Point(580, 69));
        locations.put("O", new Point(648, 69));
        locations.put("P", new Point(716, 69));

        locations.put("A", new Point(120, 137));
        locations.put("S", new Point(189, 137));
        locations.put("D", new Point(257, 137));
        locations.put("F", new Point(326, 137));
        locations.put("G", new Point(395, 137));
        locations.put("H", new Point(464, 137));
        locations.put("J", new Point(533, 137));
        locations.put("K", new Point(602, 137));
        locations.put("L", new Point(671, 137));

        locations.put("Z", new Point(155, 206));
        locations.put("X", new Point(223, 206));
        locations.put("C", new Point(291, 206));
        locations.put("V", new Point(359, 206));
        locations.put("B", new Point(427, 206));
        locations.put("N", new Point(495, 206));
        locations.put("M", new Point(563, 206));

        int size = 66;

    }
}
