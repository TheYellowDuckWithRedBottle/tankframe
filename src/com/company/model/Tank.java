package com.company.model;

import com.company.GameModel;
import com.company.TankFrame;
import com.company.bulletStrategy.*;
import com.company.enums.Dir;
import com.company.enums.Group;
import com.company.mediaLoad.ResourceMgr;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject {

    public int oldX;
    public int oldY;
    public int width = ResourceMgr.tankL.getWidth();
    public int height = ResourceMgr.tankL.getHeight();
    private boolean isLiving = true;
    private final int Speed = 10;
    private Dir dir = Dir.UP;
    private boolean moving = true;
    public int startNum=0;
    public int life = 1;
    private Group group;
    private Random randomDir = new Random();
    public FireStrategy fireStrategy;


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
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    @Override
    public void paint(Graphics g) {
        if(life>0){
            if (this.isLiving) {
                switch (dir) {
                    case LEFT:
                        if(startNum ==0){
                            g.drawImage(group == Group.GOOD ? ResourceMgr.tankL : ResourceMgr.badTankL, x, y, null);
                        }else if(startNum ==1){
                            if(group == Group.GOOD){
                                g.setColor(Color.GREEN);
                                g.drawRect(x,y,30,30);
                                g.drawImage(ResourceMgr.tankL1, x, y, null);
                            }
                        }else if(startNum ==2){
                            if(group ==Group.GOOD){
                                g.setColor(Color.YELLOW);
                                g.drawRect(x,y,30,30);
                                g.drawImage(ResourceMgr.tank2L, x, y, null);
                            }
                        }
                        break;
                    case RIGHT:
                        if(startNum ==0){
                            g.drawImage(group == Group.GOOD ? ResourceMgr.tankR : ResourceMgr.badTankR, x, y, null);
                        }else if(startNum ==1){
                            if(group ==Group.GOOD){
                                g.setColor(Color.GREEN);
                                g.drawRect(x,y,30,30);
                                g.drawImage(ResourceMgr.tankR1, x, y, null);
                            }
                        }else if(startNum ==2){
                            if(group ==Group.GOOD){
                                g.setColor(Color.YELLOW);
                                g.drawRect(x,y,30,30);
                                g.drawImage(ResourceMgr.tank2R, x, y, null);
                            }
                        }
                        break;
                    case UP:
                        if(startNum ==0){
                            g.drawImage(group == Group.GOOD ? ResourceMgr.tankU : ResourceMgr.badTankU, x, y, null);
                        }
                        else if(startNum ==1) {
                            if(group ==Group.GOOD){
                                g.setColor(Color.GREEN);
                                g.drawRect(x,y,30,30);
                                g.drawImage(ResourceMgr.tankU1, x, y, null);
                            }

                        }else if(startNum ==2){
                            if(group ==Group.GOOD){
                                g.setColor(Color.YELLOW);
                                g.drawRect(x,y,30,30);
                               g.drawImage(ResourceMgr.tank2U, x, y, null);
                            }

                        }
                        break;
                    case DOWN:
                        if(startNum ==0){
                            g.drawImage(group == Group.GOOD ? ResourceMgr.tankD : ResourceMgr.badTankD, x, y, null);
                        } else if(startNum ==1){
                            if(group ==Group.GOOD){
                                g.setColor(Color.GREEN);
                                g.drawRect(x,y,30,30);
                                g.drawImage(ResourceMgr.tankD1, x, y, null);
                            }
                        }else if(startNum ==2){
                            if(group ==Group.GOOD){
                                g.setColor(Color.YELLOW);
                                g.drawRect(x,y,30,30);
                                g.drawImage(ResourceMgr.tank2D, x, y, null);
                            }
                        }
                        break;
                    default:
                        break;
                }
                move();
            } else {
                GameModel.getInstance().objects.remove(this);
                return;
            }
        }
    }
    public void transform(){

    }
    public void setFireStrategy(){
        if(startNum ==1){
            fireStrategy = new SpeedFireStrategy();
        }else if(startNum ==2){
            fireStrategy = new AttackWallStrategy();
        }
    }

    private void move() {
        oldX = this.x;
        oldY = this.y;
        if (!moving) return;
        switch (dir) {
            case LEFT:
                x -= Speed;
                break;
            case RIGHT:
                x += Speed;
                break;
            case UP:
                y -= Speed;
                break;
            case DOWN:
                y += Speed;
                break;
            default:
                break;
        }
        if (group == Group.BAD && randomDir.nextInt(100) > 95) {
            this.setDir(GenerateRandomDir());
            this.fire();
        }
        checkBround();
    }

    public Dir GenerateRandomDir() {
        Dir[] dirs = Dir.values();
        return dirs[randomDir.nextInt(4)];
    }
    private void freeze(){
        this.x=oldX;
        this.y=oldY;
    }


    private void checkBround() {
        if (this.x < 2) {
            x = 2;
        } else if (this.x > TankFrame.GAME_WIDTH - this.width) {
            x = TankFrame.GAME_WIDTH - this.width;
        }
        if (this.y < 30) {
            y = 30;
        } else if (this.y > TankFrame.GAME_HEIGHT - this.height) {
            y = TankFrame.GAME_HEIGHT - this.height;
        }
    }

    public Tank(int x, int y, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.group = group;
        if (group == Group.GOOD) {
            moving = false;
            fireStrategy = new DefaultFireStrategy();
        } else {
            fireStrategy = new DefaultFireStrategy();
        }
    }

    private Bullet ComputeButtlePos(Bullet bullet) {
        int x = (int) (width / 2 - bullet.getWidth() / 2 + bullet.getX());
        int y = (int) (height / 2 - bullet.getHeight() / 2 + bullet.getY());
        bullet.setX(x);
        bullet.setY(y);
        return bullet;
    }

    public void fire() {
//        Bullet bullet = new Bullet(this.dir,this.x,this.y,this.group,this.tankFrame);
//        bullet = ComputeButtlePos(bullet);
//        tankFrame.bullets.add(bullet);
        fireStrategy.Fire(this);
    }
}
