package com.company;

import com.company.tankAbstract.BaseBullet;

import java.awt.*;

public class Bullet extends BaseBullet {

    private int x, y;
    private final int width=ResourceMgr.bulletL.getWidth();
    private final int height=ResourceMgr.bulletL.getHeight();
    private final int Speed = 3;
    private Dir dir = Dir.DOWN;
    private boolean isLiving = true;
    private Group group;

    public Bullet(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

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
    public Bullet(Dir dir, int x, int y,Group group,TankFrame tankFrame) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.group = group;
        this.tankFrame =tankFrame;
    }
    @Override
    public void paint(Graphics g){
        if(!isLiving){
            this.tankFrame.bullets.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            default:
                break;
        }
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
    public void collideWithTank(Tank tank){
        Rectangle bulletRec = new Rectangle(this.x,this.y,this.width,this.height);
        Rectangle tankRec =new Rectangle(tank.getX(),tank.getY(),tank.getWidth(),tank.getHeight());
        if(this.group!=tank.getGroup()){
            if(bulletRec.intersects(tankRec)){
                this.isLiving =false;
                int x =(int)(width/2-tank.getWidth()/2+tank.getX());
                int y = (int)(height/2-tank.getHeight()/2+tank.getY());
                Explode explode = new Explode(x,y,tankFrame);
                this.tankFrame.explodes.add(explode);
                tank.setLiving(false
                );
            };
        }

    }
}
