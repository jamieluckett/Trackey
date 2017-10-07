package com.trackey;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

// import NativeHook libraries

class MouseControl {

    static MouseGrabber mg = new MouseGrabber();
    static ArrayList<Point> mouseArrayList = new ArrayList<>();

    private static final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    public static void main(String args[]) {
            final Runnable beeper = new Runnable() {

                public void run() {
                    mouseArrayList.add(mg.getMouseLocation());

                }
            };

            final ScheduledFuture<?> beeperHandle =
                    scheduler.scheduleAtFixedRate(beeper, 10, 100, MILLISECONDS);

            scheduler.schedule(new Runnable() {
                public void run() {beeperHandle.cancel(true);
                    mouseArrayList.forEach(System.out::println);
                    MouseLineGenerator mlg = new MouseLineGenerator();
                    try {
                        mlg.generateImage(mouseArrayList);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("dONE");
                }
            }, 5, SECONDS);


    }
    }





