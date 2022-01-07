package com.company;

import com.company.abstractFactory.DefaultFactory;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TankFrame tankFrame = new TankFrame();
        for(var i=1;i<5;i++){
            tankFrame.tanks.add(tankFrame.defaultFactory.createTank(i*100,i*100,Group.BAD,tankFrame));
            //tankFrame.tanks.add(new Tank(i*100,i*100,Group.BAD,tankFrame));
        }
        while(true) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tankFrame.repaint();
        }

    }
}
