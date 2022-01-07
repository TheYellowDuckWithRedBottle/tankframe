package com.company.abstractFactory;

import com.company.Dir;
import com.company.Group;
import com.company.ResourceMgr;
import com.company.TankFrame;
import com.company.bulletStrategy.DefaultFireStrategy;
import com.company.bulletStrategy.FireStrategy;
import com.company.bulletStrategy.FourDirStrategy;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2021/12/29 9:12
 * @Version 1.0
 **/
public abstract class BaseTank {
    private int x;
    private int y;
    private int width= ResourceMgr.tankL.getWidth(),
            height=ResourceMgr.tankL.getHeight();
    private boolean isLiving =true;
    private final int Speed = 5;
    private Dir dir=Dir.UP;
    private boolean moving = true;
    private FireStrategy fireStrategy;

    protected BaseTank() {
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public BaseTank(int x,int y,Group group,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.group =group;
        if(group == Group.GOOD){
            moving = false;
            fireStrategy = new FourDirStrategy();
        }else{
            fireStrategy = new DefaultFireStrategy();
        }
        this.tankFrame =tankFrame;
    }

    public TankFrame getTankFrame() {
        return tankFrame;
    }

    private TankFrame tankFrame;

    public void setLiving(boolean living) {
        isLiving = living;
    }

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

    public boolean isLiving() {
        return isLiving;
    }

    public int getSpeed() {
        return Speed;
    }

    public Dir getDir() {
        return dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public Group getGroup() {
        return group;
    }

    private Group group;
    public abstract void paint(Graphics g);

    public abstract void fire();

}
