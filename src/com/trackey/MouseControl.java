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
    final Runnable beeper = new Runnable() {

        public void run() {
            mouseArrayList.add(mg.getMouseLocation());

        }
    };

    ScheduledFuture<?> beeperHandle =
            scheduler.scheduleAtFixedRate(beeper, 10, 100, MILLISECONDS);

    public void startMouseTracking(){
        beeperHandle = scheduler.scheduleAtFixedRate(beeper, 10, 100, MILLISECONDS);
    }
    public void callMouseImageGenerator(){
        // stop the mouse thread and then restart it afterwards
        beeperHandle.cancel(true);
        mouseArrayList.forEach(System.out::println);
        MouseLineGenerator mlg = new MouseLineGenerator();
        try {
            mlg.generateImage(mouseArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("dONE");
    }



    }





