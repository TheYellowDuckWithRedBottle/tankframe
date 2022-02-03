package com.company.props;

import com.company.*;
import com.company.mediaLoad.ResourceMgr;
import com.company.model.GameObject;

import java.awt.*;
import java.util.Random;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/17 13:38
 * @Version 1.0
 **/
public  class Prop extends GameObject {
    static Random randomPos = new Random();
    public boolean isLiving = true;
    private int timer=0;
    private int aliveTime=4500;//显示的持续时间
    public PropType propType;

    private Prop(int x,int y) {
        this.x=x;
        this.y =y;
        PropType[] props = PropType.values();
        propType = props[randomPos.nextInt(6)];
    }

    public Prop() {
        x = randomPos.nextInt(TankFrame.GAME_WIDTH);
        y = randomPos.nextInt(TankFrame.GAME_HEIGHT);
        propType = getRandomProp();
        width = ResourceMgr.pantacel.getWidth();
        heigh = ResourceMgr.pantacel.getHeight();
    }

    public void changeProp(){
        x = randomPos.nextInt(TankFrame.GAME_WIDTH);
        y = randomPos.nextInt(TankFrame.GAME_HEIGHT);
        propType = getRandomProp();
        this.isLiving = true;
    }


    @Override
    public  void paint(Graphics g){
        if(!isLiving) {
            timer+=30;
            if(timer>randomPos.nextInt(5000)+1000) {
                isLiving = true;
                changeProp();
                timer = 0;
            }
        }else {
            if(timer<aliveTime) {
            timer+=30;
                switch (propType){
                    case Bomb:
                        g.drawImage(ResourceMgr.bomb, x, y, null);
                        break;
                    case Helmet:
                        g.drawImage(ResourceMgr.protect, x, y, null);
                        break;
                    case shovel:
                        g.drawImage(ResourceMgr.shovel,x,y,null);
                    case Pantcle:
                        g.drawImage(ResourceMgr.pantacel, x, y, null);
                        break;
                    case Pistol:
                        g.drawImage(ResourceMgr.gun, x, y, null);
                        break;
                    case Timer:
                        g.drawImage(ResourceMgr.timer, x, y, null);
                        break;
                    default:
                        break;
                }
            }else{
                timer =0;
                isLiving=false;
            }
        }
    }
    public static Prop getToolInstance() {
        int x = randomPos.nextInt(TankFrame.GAME_WIDTH);
        int y = randomPos.nextInt(TankFrame.GAME_HEIGHT);
        return new Prop(x,y);
    }
    public  PropType getRandomProp(){
        PropType[] props = PropType.values();
        propType = props[randomPos.nextInt(6)];
       return propType;
    }
}
