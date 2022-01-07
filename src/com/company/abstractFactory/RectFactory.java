package com.company.abstractFactory;

import com.company.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2021/12/29 9:15
 * @Version 1.0
 **/
public class RectFactory extends GameFactory{
    @Override
    public BaseTank createTank(int x, int y, Group group, TankFrame tankFrame) {
        return new RecTank(x,y,group,tankFrame);
    }

    @Override
    public BaseBullet createBullet(Dir dir, int x, int y, Group group, TankFrame tankFrame) {
        return new RectBullet(dir,x,y,group,tankFrame);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x,y,tf);
    }

    public RectFactory() {
    }
}
