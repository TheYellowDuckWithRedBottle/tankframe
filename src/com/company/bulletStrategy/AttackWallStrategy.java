package com.company.bulletStrategy;

import com.company.model.Bullet;
import com.company.GameModel;
import com.company.model.Tank;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/30 9:59
 * @Version 1.0
 **/
public class AttackWallStrategy implements FireStrategy {
    @Override
    public void Fire(Tank tank) {
        Bullet bullet = new Bullet(tank.getDir(),tank.getX(),tank.getY(),tank.getGroup());
        bullet.attackSteel = true;
        bullet.Speed =20;
        int x =(int)(tank.getWidth()/2-bullet.getWidth()/2+bullet.getX());
        int y = (int)(tank.getHeight()/2-bullet.getHeight()/2+bullet.getY());
        bullet.setX(x);
        bullet.setY(y);
        GameModel.getInstance().objects.add(bullet);
    }
}
