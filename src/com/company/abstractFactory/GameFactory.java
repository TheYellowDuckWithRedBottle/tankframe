package com.company.abstractFactory;

import com.company.Dir;
import com.company.Group;
import com.company.TankFrame;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2021/12/29 9:12
 * @Version 1.0
 **/
public abstract class GameFactory {
   public abstract BaseTank createTank(int x, int y, Group group, TankFrame tankFrame);
   public abstract BaseBullet createBullet(Dir dir, int x, int y, Group group, TankFrame tankFrame);
   public abstract BaseExplode createExplode(int x,int y,TankFrame tf);

}
