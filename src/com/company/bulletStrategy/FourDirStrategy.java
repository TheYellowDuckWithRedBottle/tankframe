package com.company.bulletStrategy;

import com.company.Bullet;
import com.company.Dir;
import com.company.GameModel;
import com.company.Tank;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2021/12/28 14:22
 * @Version 1.0
 **/
public class FourDirStrategy implements FireStrategy{
    @Override
    public void Fire(Tank tank) {
        Dir[] dirs= Dir.values();
        for(Dir dir:dirs){
            Bullet bullet = new Bullet(dir,tank.getX(),tank.getY(),tank.getGroup());
            int x =(int)(tank.getWidth()/2-bullet.getWidth()/2+bullet.getX());
            int y = (int)(tank.getHeight()/2-bullet.getHeight()/2+bullet.getY());
            bullet.setX(x);
            bullet.setY(y);
            GameModel.getInstance().objects.add(bullet);
        }
    }
}
