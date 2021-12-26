package com.company;

import com.company.bulletStratage.DefaultFireStrategy;
import com.company.bulletStratage.FireStrategy;
import com.company.bulletStratage.FourDirFireStrategy;
import com.company.tankAbstract.BaseTank;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Tank extends BaseTank {
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

    private int width=ResourceMgr.goodTankL.getWidth(),
            height=ResourceMgr.goodTankL.getHeight();

    public void setLiving(boolean living) {
        isLiving = living;
    }

    private boolean isLiving =true;
    private final int Speed = 4;
    private Dir dir=Dir.UP;
    private boolean moving;
    private TankFrame tankFrame;

    public Group getGroup() {
        return group;
    }

    public TankFrame getTankFrame() {
        return tankFrame;
    }

    private Group group;
    private Random random = new Random();

    public Dir getDir() {
        return dir;
    }
    public void setDir(Dir dir) {
        this.dir = dir;
    }
    public void setMoving(boolean moving) {
        this.moving = moving;
    }
    public FireStrategy fireStrategy = null;
    @Override
    public void paint(Graphics g){
        if(this.isLiving){
            switch (dir){
                case LEFT:
                    g.drawImage(this.group ==Group.GOOD?ResourceMgr.goodTankL:ResourceMgr.badTankL,x,y,null);
                    break;
                case RIGHT:
                    g.drawImage(this.group ==Group.GOOD?ResourceMgr.goodTankR:ResourceMgr.badTankR,x,y,null);
                    break;
                case UP:
                    g.drawImage(this.group ==Group.GOOD?ResourceMgr.goodTankU:ResourceMgr.badTankU,x,y,null);
                    break;
                case DOWN:
                    g.drawImage(this.group ==Group.GOOD?ResourceMgr.goodTankD:ResourceMgr.badTankD,x,y,null);
                    break;
                default:
                    break;
            }
            move();
        }else{
                this.tankFrame.tanks.remove(this);
            return;
        }
        if(group==Group.BAD&&(random.nextInt(100)>95)){
            dir=RandomDir();
        }
        boundCheck();
    }

    private void boundCheck() {
        if(x<0) x=0;
        else if(x>TankFrame.GAME_WIDTH-this.width) x=TankFrame.GAME_WIDTH-this.width;
        if(y<30) y=30;
        else if(y>TankFrame.GAME_HEIGHT-this.height) y=TankFrame.GAME_HEIGHT-this.height;
    }

    private Dir RandomDir(){
       return Dir.values()[random.nextInt(4)];
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
        if(Group.BAD==group&&random.nextInt(100)>95){
            fireStrategy.Fire(this);
        }
    }

    public Tank(int x, int y, Dir dir, TankFrame tankFrame, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        this.group = group;
        if(group == Group.BAD){
            this.fireStrategy = new DefaultFireStrategy();
        }else{
            this.fireStrategy = new FourDirFireStrategy();
        }
    }

    public Tank(int x, int y, Group group , TankFrame tf) {
        this.x = x;
        this.y = y;
        this.group =group;
        this.tankFrame =tf;
        this.moving =true;
        if(group == Group.BAD){
            this.fireStrategy = new DefaultFireStrategy();
        }else{
            this.fireStrategy = new FourDirFireStrategy();
        }
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
        ComputeButtlePos(bullet);
        tankFrame.bullets.add(bullet);
    }
}
