package com.trackey;

import java.awt.*;

public class MouseGrabber {

    public void setMouseLocation(){
        this.mouseLocation = MouseInfo.getPointerInfo().getLocation();

    }

    public Point getMouseLocation(){
        this.mouseLocation = MouseInfo.getPointerInfo().getLocation();
        return this.mouseLocation;
    }

    private Point mouseLocation;

}
