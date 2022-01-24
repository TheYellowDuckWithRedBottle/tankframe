package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        TankFrame tankFrame = new TankFrame();
        while (true) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tankFrame.repaint();
        }

    }
}
