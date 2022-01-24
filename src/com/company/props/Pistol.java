package com.company.props;

import com.company.GameObject;
import com.company.ResourceMgr;
import com.company.TankFrame;

import java.awt.*;
import java.util.Random;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/16 23:15
 * @Version 1.0
 **/
public class Pistol extends Prop {
    boolean isLiving = true;

    public Pistol() {
        x = randomPos.nextInt(TankFrame.GAME_WIDTH);
        y = randomPos.nextInt(TankFrame.GAME_HEIGHT);
    }

    @Override
    public void paint(Graphics g) {
        if(isLiving){
            g.drawImage(ResourceMgr.pantacel,x,y,null);
        }
    }
}
