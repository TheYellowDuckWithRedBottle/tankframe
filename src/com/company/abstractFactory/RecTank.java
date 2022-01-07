package com.company.abstractFactory;

import com.company.Dir;
import com.company.Group;
import com.company.ResourceMgr;
import com.company.TankFrame;
import com.company.bulletStrategy.DefaultFireStrategy;
import com.company.bulletStrategy.FireStrategy;
import com.company.bulletStrategy.FourDirStrategy;

import java.awt.*;
import java.util.Random;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/4 21:58
 * @Version 1.0
 **/
public class RecTank extends BaseTank{


    private int x;
    private int y;
    private final int width= 30;
    private final int height=30;
    private Dir dir= Dir.UP;
    private final int Speed = 5;
    private Group group;
    private TankFrame tankFrame;
    private boolean isLiving=true;
    private boolean moving = true;
    private FireStrategy fireStrategy;
    private Random randomDir = new Random();
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
    @Override
    public TankFrame getTankFrame() {
        return tankFrame;
    }

    public RecTank(int x, int y, Group group , TankFrame tf) {
        this.x = x;
        this.y = y;
        this.group =group;
        if(group == Group.GOOD){
            moving = false;
            fireStrategy = new FourDirStrategy();
        }else{
            fireStrategy = new DefaultFireStrategy();
        }
        this.tankFrame =tf;
    }
    @Override
    public void paint(Graphics g){
        if(this.isLiving){
            g.fillRect(x,y,width,height);
            move();
        }else{
            this.tankFrame.tanks.remove(this);
            return;
        }
    }

    @Override
    public void fire() {
        fireStrategy.Fire(this);
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
    public Dir  GenerateRandomDir() {
        Dir[] dirs = Dir.values();
        return dirs[randomDir.nextInt(4)];
    }
}
