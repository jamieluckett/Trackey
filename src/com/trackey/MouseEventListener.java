package com.trackey;

// import NativeHook libraries

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

public class MouseEventListener implements NativeMouseInputListener {

    public void nativeMouseClicked(NativeMouseEvent e){}

    public void nativeMousePressed(NativeMouseEvent e){}

    public void nativeMouseReleased(NativeMouseEvent e){}

    public void nativeMouseDragged(NativeMouseEvent e){}

    public void nativeMouseMoved(NativeMouseEvent e){
        // logic for onMove operations goes here.
        System.out.println("Mouse position: " + e.getX() + e.getY());
    }

public static void main(String args[]) {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex){
            System.out.println(ex.getMessage());
        }

        System.exit(1);

        // Construct the example object.
        MouseEventListener example = new MouseEventListener();

        // Add the appropriate listeners.
        GlobalScreen.addNativeMouseListener(example);
        GlobalScreen.addNativeMouseMotionListener(example);
    }

}
