package com.company.abstractFactory;

import com.company.*;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2021/12/29 9:13
 * @Version 1.0
 **/
public  abstract class BaseBullet {
    private int x, y;
    private TankFrame tankFrame;
    private final int width=ResourceMgr.bulletL.getWidth();
    private final int height=ResourceMgr.bulletL.getHeight();
    private boolean isLiving = true;

    public Group getGroup() {
        return group;
    }

    private Group group;

    public TankFrame getTankFrame() {
        return tankFrame;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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

    public void paint(Graphics g){}
    public abstract void collideWithTank(BaseTank tank);


}
