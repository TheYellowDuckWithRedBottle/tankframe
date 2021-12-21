package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private int x, y;
    private int width=20,height=20;
    private final int Speed = 2;
    private Dir dir=Dir.UP;
    private boolean moving;
    private TankFrame tankFrame;
    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g){
        g.fillRect(x,y,width,height);
        move();
    }
    private void move(){
        if(!moving) return;
        switch (dir){
            case LEFT:
                x-=Speed;
                break;
            case RIGHT:
                x+=Speed;
                break;
            case UP:
                y-=Speed;
                break;
            case DOWN:
                y+=Speed;
                break;
            default:
                break;
        }
    }

    public Tank(int x, int y,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tankFrame =tf;
    }

    private Bullet ComputeButtlePos(Bullet bullet){
        int x =(int)(width/2-bullet.getWidth()/2+bullet.getX());
        int y = (int)(height/2-bullet.getHeight()/2+bullet.getY());
        bullet.setX(x);
        bullet.setY(y);
        return bullet;
    }
    public void fire() {
        Bullet bullet = new Bullet(this.dir,this.x,this.y,this.tankFrame);
        bullet = ComputeButtlePos(bullet);
        tankFrame.bullets.add(bullet);
        System.out.println("字单数量"+tankFrame.bullets.size());
    }
}
