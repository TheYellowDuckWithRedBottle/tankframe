package com.company.bulletStrategy;

import com.company.Bullet;
import com.company.Tank;
import com.company.abstractFactory.BaseBullet;
import com.company.abstractFactory.BaseTank;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2021/12/28 14:21
 * @Version 1.0
 **/
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void Fire(BaseTank tank) {
        BaseBullet bullet =  tank.getTankFrame().defaultFactory.createBullet(tank.getDir(),tank.getX(),tank.getY(),tank.getGroup(),tank.getTankFrame());
        int x =(int)(tank.getWidth()/2-bullet.getWidth()/2+bullet.getX());
        int y = (int)(tank.getHeight()/2-bullet.getHeight()/2+bullet.getY());
        bullet.setX(x);
        bullet.setY(y);
        tank.getTankFrame().bullets.add(bullet);
    }
}
