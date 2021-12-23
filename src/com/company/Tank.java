package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Tank {
    private int x;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int y;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private int width=ResourceMgr.tankL.getWidth(),
            height=ResourceMgr.tankL.getHeight();

    public void setLiving(boolean living) {
        isLiving = living;
    }

    private boolean isLiving =true;
    private final int Speed = 2;
    private Dir dir=Dir.UP;
    private boolean moving;
    private TankFrame tankFrame;
    private Group group;

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
        if(this.isLiving){
            switch (dir){
                case LEFT:
                    g.drawImage(ResourceMgr.tankL,x,y,null);
                    break;
                case RIGHT:
                    g.drawImage(ResourceMgr.tankR,x,y,null);
                    break;
                case UP:
                    g.drawImage(ResourceMgr.tankU,x,y,null);
                    break;
                case DOWN:
                    g.drawImage(ResourceMgr.tankD,x,y,null);
                    break;
                default:
                    break;
            }
            move();
        }else{
                this.tankFrame.tanks.remove(this);
            return;
        }

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

    public Tank(int x, int y,Group group ,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.group =group;
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
        System.out.println("字单数量"+tankFrame.tank);
    }
}
