package com.company.props;

import com.company.GameModel;
import com.company.GameObject;
import com.company.ResourceMgr;
import com.company.TankFrame;

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
    Random randomPos = new Random();
    public boolean isLiving = true;
    public PropType type;
    public int lifeTime = 4500;
    public int time = 0;

    public Prop() {
        x = randomPos.nextInt(TankFrame.GAME_WIDTH);
        y = randomPos.nextInt(TankFrame.GAME_HEIGHT);
        type = generatePropType();
    }
    private  PropType generatePropType(){
        PropType[] props = PropType.values();
        return props[randomPos.nextInt(6)];
    }
    private void changePos(){
        x = randomPos.nextInt(TankFrame.GAME_WIDTH);
        y = randomPos.nextInt(TankFrame.GAME_HEIGHT);
        type = generatePropType();
    }

    @Override
    public  void paint(Graphics g){
        if(!isLiving){
            time+=30;
            if(time>5000){
                isLiving = true;
                changePos();
                time=0;
            }
            return;
        }else{
            if(time<lifeTime){
                time+=30;
                switch (type){
                    case Pantacle:
                        g.drawImage(ResourceMgr.pantacel, x, y, null);
                        break;
                    case Bomb:
                        g.drawImage(ResourceMgr.bomb, x, y, null);
                        break;
                    case Helmet:
                        g.drawImage(ResourceMgr.protect, x, y, null);
                        break;
                    case Timer:
                        g.drawImage(ResourceMgr.timer, x, y, null);
                        break;
                    case Pistol:
                        g.drawImage(ResourceMgr.gun, x, y, null);
                        break;
                    case Iron:
                        g.drawImage(ResourceMgr.iron, x, y, null);
                        break;
                    default:
                        break;
                }
            }else{
                time =0;
                isLiving=false;
            }
        }
    }
}
