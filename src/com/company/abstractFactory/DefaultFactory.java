package com.company.abstractFactory;

import com.company.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2021/12/29 9:14
 * @Version 1.0
 **/
public class DefaultFactory extends GameFactory {

    @Override
    public BaseTank createTank(int x, int y, Group group, TankFrame tankFrame) {
        return new Tank(x,y,group,tankFrame);
    }

    @Override
    public BaseBullet createBullet(Dir dir,int x,int y,Group group,TankFrame tankFrame) {
        return new Bullet(dir,x,y,group,tankFrame);
    }

    @Override
    public BaseExplode createExplode(int x,int y,TankFrame tf) {
        return new Explode(x,y,tf);
    }

    public DefaultFactory() {
    }
}
