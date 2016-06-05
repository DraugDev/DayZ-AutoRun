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
        button = new JButton("Not running");
        button.setBackground(new Color(1, 0, 0));

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
                    thread.interrupt();
                    button.setBackground(new Color(255, 0, 0));
                    button.setText("Not running");
                    return;
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                button.setText("Running");
                button.setBackground(new Color(0, 255, 0));

                programRunning = true;
                thread = new Thread(DayZAutoRun.this::run);
                thread.start();
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
