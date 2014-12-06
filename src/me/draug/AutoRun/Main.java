package me.draug.AutoRun;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

/**
 * Created by Draug on 05.12.2014.
 */

public class Main {

    public static void main(String[] args) throws Exception {
        KeyPressed pressed = new KeyPressed();
        Robot robot = new Robot();

        while(pressed.isOn){
            System.out.println("CapsLock is activated");
            robot.keyPress(KeyEvent.VK_W);
        }
    }
}
