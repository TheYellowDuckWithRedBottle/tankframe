package com.company;

import java.awt.*;

public class Bullet {

    private int x, y;
    private final int width=10;
    private final int height=10;
    private final int Speed = 2;
    private Dir dir = Dir.DOWN;
    private boolean isLiving = true;
    private TankFrame tankFrame;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isLiving() {
        return isLiving;
    }
    public void setLiving(boolean living) {
        isLiving = living;
    }


    public void setDir(Dir dir) {
        this.dir = dir;
    }
    public Bullet(Dir dir, int x, int y,TankFrame tankFrame) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.tankFrame =tankFrame;
    }
    public void paint(Graphics g){
        if(!isLiving){
            this.tankFrame.bullets.remove(this);
        }
        Color c =g.getColor();
        g.setColor(new Color(255,0,0));
        g.fillOval(x,y,width,height);
        g.setColor(c);
        move();
    }
    public void move(){
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
        if(x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_WIDTH){
            this.isLiving=false;
        }
    }

}
