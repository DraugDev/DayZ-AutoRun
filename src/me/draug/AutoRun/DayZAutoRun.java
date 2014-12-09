package me.draug.AutoRun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class DayZAutoRun {

    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private boolean programRunning = false;
    private boolean pressed = false;
    private Robot robot;
    private Thread thread;

    public DayZAutoRun() throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        robot = new Robot();
        frame = new JFrame("DayZ Autorun");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel();
        button = new JButton("Press me!");

        frame.setContentPane(panel);
        panel.add(button);

        frame.setSize(200, 80);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (programRunning) {
                    programRunning = false;
                    thread.stop();
                    return;
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                programRunning = true;
                thread = new Thread(DayZAutoRun.this::run);
            }
        });
    }

    protected void run() {
        while (programRunning) {
            if (!pressed) {
                robot.keyPress(KeyEvent.VK_W);
                robot.keyRelease(KeyEvent.VK_W);
                robot.keyPress(KeyEvent.VK_W);
                pressed = true;
            }
        }

        pressed = false;
    }
}
