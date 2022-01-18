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
 * @Date 2022/1/17 13:36
 * @Version 1.0
 **/
public class Bomb extends Prop {



    public Bomb() {
        x = randomPos.nextInt(TankFrame.GAME_WIDTH);
        y = randomPos.nextInt(TankFrame.GAME_HEIGHT);
    }

    @Override
    public void paint(Graphics g) {
        if(!isLiving){
            GameModel.getInstance().objects.remove(this);
        }
        if(isLiving){
            g.drawImage(ResourceMgr.bomb,x,y,null);
        }
    }
}
