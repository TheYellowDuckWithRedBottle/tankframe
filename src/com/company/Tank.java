package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Tank {
    private int x;
    private int y;
    private int width=ResourceMgr.tankL.getWidth(),
            height=ResourceMgr.tankL.getHeight();
    private boolean isLiving =true;
    private final int Speed = 5;
    private Dir dir=Dir.UP;
    private boolean moving = true;
    private Group group;
    private Random randomDir = new Random();
    private TankFrame tankFrame;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void setLiving(boolean living) {
        isLiving = living;
    }
    public Group getGroup() {
        return group;
    }
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
                    g.drawImage(group==Group.GOOD?ResourceMgr.tankL:ResourceMgr.badTankL,x,y,null);
                    break;
                case RIGHT:
                    g.drawImage(group==Group.GOOD?ResourceMgr.tankR:ResourceMgr.badTankR,x,y,null);
                    break;
                case UP:
                    g.drawImage(group==Group.GOOD?ResourceMgr.tankU:ResourceMgr.badTankU,x,y,null);
                    break;
                case DOWN:
                    g.drawImage(group==Group.GOOD?ResourceMgr.tankD:ResourceMgr.badTankD,x,y,null);
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
        if(group==Group.BAD&&randomDir.nextInt(100)>95){
            this.setDir(GenerateRandomDir());
            this.fire();
        }
        checkBround();
    }

    public Dir  GenerateRandomDir() {
        Dir[] dirs = Dir.values();
        return dirs[randomDir.nextInt(4)];
    }

    private void checkBround() {
        if(this.x<tankFrame.getX()) {
            x =tankFrame.getX();
        } else if(this.x>tankFrame.getWidth()+tankFrame.getX()-this.width) {
            x = tankFrame.getWidth()+tankFrame.getX()-this.width;
        }
        if(this.y<tankFrame.getY()+30) {
            y=tankFrame.getY()+30;
        } else if(this.y>tankFrame.getHeight()+tankFrame.getY()-this.height) {
            y = tankFrame.getHeight()+tankFrame.getY()-this.height;
        }
    }

    public Tank(int x, int y,Group group ,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.group =group;
        if(group == Group.GOOD){
            moving = false;
        }
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
        Bullet bullet = new Bullet(this.dir,this.x,this.y,this.group,this.tankFrame);
        bullet = ComputeButtlePos(bullet);
        tankFrame.bullets.add(bullet);
        System.out.println("字单数量"+tankFrame.bullets.size());
        System.out.println("字单数量"+tankFrame.explodes.size());
    }
}
