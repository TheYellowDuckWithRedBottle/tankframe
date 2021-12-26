package com.company.tankAbstract;

import com.company.*;

public class DefaultFactory extends  GameFactory{
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Tank(x,y,dir, tankFrame, group);
    }

    @Override
    public BaseBullet createBullet(int x, int y, TankFrame tankFrame) {
        return new Bullet(x,y,tankFrame);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new Explode(x,y,tankFrame);
    }
}
