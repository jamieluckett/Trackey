package com.trackey;

public class Main {

    public static void main(String args[]) throws InterruptedException {
        MouseControl mc = new MouseControl();

        System.out.println("Open!");
        Thread.sleep(5000l);
        System.out.println("Slept!");

        mc.callMouseImageGenerator();
        System.out.println("Generated image!");

        mc.startMouseTracking();
        System.out.println("Mouse tracking resumed!");
        Thread.sleep(5000l);
        System.exit(0);


    }
}
