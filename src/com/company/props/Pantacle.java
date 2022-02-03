package com.company.props;

import com.company.mediaLoad.ResourceMgr;
import com.company.TankFrame;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/16 23:14
 * @Version 1.0
 **/
public class Pantacle extends Prop {

    public Pantacle() {
        x = randomPos.nextInt(TankFrame.GAME_WIDTH);
         y = randomPos.nextInt(TankFrame.GAME_HEIGHT);
         width = ResourceMgr.pantacel.getWidth();
         heigh =ResourceMgr.pantacel.getHeight();
    }

    @Override
    public void paint(Graphics g) {
        if(isLiving) {
            g.drawImage(ResourceMgr.pantacel, x, y, null);
        }
    }
}
