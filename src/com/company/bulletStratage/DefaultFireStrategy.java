package com.company.bulletStratage;

import com.company.Bullet;
import com.company.Dir;
import com.company.Tank;

public class DefaultFireStrategy implements FireStrategy
{
    @Override
    public void Fire(Tank tank) {

            Bullet bullet = new Bullet(tank.getDir(),tank.getX(),tank.getY(),tank.getGroup(),tank.getTankFrame());
            int x =(int)(tank.getWidth()/2-bullet.getWidth()/2+bullet.getX());
            int y = (int)(tank.getHeight()/2-bullet.getHeight()/2+bullet.getY());
            bullet.setX(x);
            bullet.setY(y);
            tank.getTankFrame().bullets.add(bullet);
    }
}
