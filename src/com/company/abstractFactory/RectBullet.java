package com.company.abstractFactory;

import com.company.Dir;
import com.company.Group;
import com.company.ResourceMgr;
import com.company.TankFrame;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/4 21:58
 * @Version 1.0
 **/
public class RectBullet extends BaseBullet{
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int x;
    private int y;
    private final int width= 10;
    private final int height=10;
    private Dir dir = Dir.DOWN;

    public void setLiving(boolean living) {
        isLiving = living;
    }

    private boolean isLiving;
    private final int Speed = 3;
    private Group group;
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


    public void paint(Graphics g){
        if(!isLiving){
            this.tankFrame.bullets.remove(this);
        }
        Color c =g.getColor();
        g.setColor(new Color(255,0,0));
        switch (dir){
            case LEFT:
                g.fillRect(x,y,10,10);
                break;
            case RIGHT:
                g.fillRect(x,y,10,10);
                break;
            case UP:
                g.fillRect(x,y,10,10);
                break;
            case DOWN:
                g.fillRect(x,y,10,10);
                break;
            default:
                break;
        }
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
    public RectBullet(Dir dir, int x, int y, Group group, TankFrame tankFrame) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.group = group;
        this.isLiving =true;
        this.tankFrame =tankFrame;
    }

    @Override
    public void collideWithTank(BaseTank tank){
        Rectangle bulletRec = new Rectangle(this.x,this.y,this.width,this.height);
        Rectangle tankRec =new Rectangle(tank.getX(),tank.getY(),tank.getWidth(),tank.getHeight());
        if(this.group!=tank.getGroup()){
            if(bulletRec.intersects(tankRec)){
                this.isLiving =false;
                tank.setLiving(false);
                BaseExplode explode=  tank.getTankFrame().defaultFactory.createExplode(tank.getX(),tank.getY(),tankFrame);
                // Explode explode = new Explode(tank.getX(),tank.getY(),tankFrame);
                tankFrame.explodes.add(explode);
            };
        }
    }
}
