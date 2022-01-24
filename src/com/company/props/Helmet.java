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
public class Helmet extends Prop {

    public Helmet() {
        x = randomPos.nextInt(TankFrame.GAME_WIDTH);
        y = randomPos.nextInt(TankFrame.GAME_HEIGHT);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.pantacel,x,y,null);
    }
}
