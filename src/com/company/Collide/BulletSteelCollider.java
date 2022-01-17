package com.company.Collide;

import com.company.Bullet;
import com.company.GameObject;
import com.company.Wall;
import com.company.terrainFactory.Steel;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/16 23:05
 * @Version 1.0
 **/
public class BulletSteelCollider implements Collider {
    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if(go1 instanceof Bullet &&go2 instanceof Steel){
            Bullet bullet = (Bullet) go1;
            Steel wall = (Steel) go2;
            Rectangle bulletRec = new Rectangle(bullet.getX(),bullet.getY(),bullet.getWidth(),bullet.getHeight());
            Rectangle wallRec =new Rectangle(wall.x,wall.y,wall.width,wall.height);
            if(bulletRec.intersects(wallRec)){
                bullet.setLiving(false);
                return false;
            };
        }
        if(go1 instanceof Steel &&go2 instanceof Bullet){
            Steel steel = (Steel) go1;
            Bullet bullet = (Bullet) go2;
            Rectangle bulletRec = new Rectangle(bullet.getX(),bullet.getY(),bullet.getWidth(),bullet.getHeight());
            Rectangle wallRec =new Rectangle(steel.x,steel.y,steel.width,steel.height);
            if(bulletRec.intersects(wallRec)){
                bullet.setLiving(false);
                return false;
            };
        }
        return true;
    }
}
