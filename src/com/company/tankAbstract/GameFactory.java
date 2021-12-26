package com.company.tankAbstract;

import com.company.Dir;
import com.company.Group;
import com.company.Tank;
import com.company.TankFrame;

public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame);
    public abstract BaseBullet createBullet(int x,int y,TankFrame tankFrame);
    public abstract BaseExplode createExplode(int x,int y,TankFrame tankFrame);
}
