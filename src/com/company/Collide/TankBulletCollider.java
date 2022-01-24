package com.company.Collide;

import com.company.*;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/8 19:33
 * @Version 1.0
 **/
public class TankBulletCollider implements Collider {
    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if(go1 instanceof Bullet&&go2 instanceof Tank){
            Bullet bullet = (Bullet) go1;
            Tank tank = (Tank) go2;
            Rectangle bulletRec = new Rectangle(bullet.getX(),bullet.getY(),bullet.getWidth(),bullet.getHeight());
            Rectangle tankRec =new Rectangle(tank.getX(),tank.getY(),tank.getWidth(),tank.getHeight());
            if(bullet.getGroup()!=tank.getGroup()){
                if(bulletRec.intersects(tankRec)){
                    bullet.setLiving(false);
                    tank.setLiving(false);
                    Explode explode = new Explode(tank.getX(),tank.getY());
                    GameModel.getInstance().objects.add(explode);
                    return false;
                };
            }
        }
        if(go1 instanceof Tank&&go2 instanceof Bullet){
            Tank tank = (Tank) go1;
            Bullet bullet = (Bullet) go2;
            Rectangle bulletRec = new Rectangle(bullet.getX(),bullet.getY(),bullet.getWidth(),bullet.getHeight());
            Rectangle tankRec =new Rectangle(tank.getX(),tank.getY(),tank.getWidth(),tank.getHeight());
            if(bullet.getGroup()!=tank.getGroup()){
                if(bulletRec.intersects(tankRec)){
                    bullet.setLiving(false);
                    tank.setLiving(false);
                    Explode explode = new Explode(tank.getX(),tank.getY());
                    GameModel.getInstance().objects.add(explode);
                    return false;
                };
            }
        }
        return true;
    }
}
