package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        TankFrame tankFrame = new TankFrame();

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tankFrame.repaint();
        }

    }
}
