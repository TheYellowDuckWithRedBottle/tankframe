package com.company.bulletStrategy;

import com.company.model.Bullet;
import com.company.GameModel;
import com.company.model.Tank;
import com.company.decorator.BulletRecDecorator;
import com.company.decorator.BulletTailDecorator;
import com.company.decorator.GameObectDecorator;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2021/12/28 14:21
 * @Version 1.0
 **/
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void Fire(Tank tank) {
        Bullet bullet = new Bullet(tank.getDir(),tank.getX(),tank.getY(),tank.getGroup());
        GameObectDecorator bulletRecDecorator = new BulletTailDecorator(new BulletRecDecorator(bullet));
        int x =(int)(tank.getWidth()/2-bullet.getWidth()/2+bullet.getX());
        int y = (int)(tank.getHeight()/2-bullet.getHeight()/2+bullet.getY());
        bullet.setX(x);
        bullet.setY(y);
        GameModel.getInstance().objects.add(bullet);
    }
}
