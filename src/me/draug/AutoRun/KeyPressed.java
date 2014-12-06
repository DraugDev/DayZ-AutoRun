package me.draug.AutoRun;


import java.awt.Toolkit;
import java.awt.event.KeyEvent;

/**
 * Created by Draug on 05.12.2014.
 */

public class KeyPressed {

    boolean isOn = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_NUM_LOCK);

}
