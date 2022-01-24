package com.company.Collide;

import com.company.*;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/8 22:58
 * @Version 1.0
 **/
public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if(go1 instanceof Bullet &&go2 instanceof Wall){
            Bullet bullet = (Bullet) go1;
            Wall wall = (Wall) go2;
            Rectangle bulletRec = new Rectangle(bullet.getX(),bullet.getY(),bullet.getWidth(),bullet.getHeight());
            Rectangle wallRec =new Rectangle(wall.x,wall.y,wall.width,wall.height);
                if(bulletRec.intersects(wallRec)){
                    bullet.setLiving(false);
                    return false;
                };
        }
        if(go1 instanceof Wall &&go2 instanceof Bullet){
            Wall wall = (Wall) go1;
            Bullet bullet = (Bullet) go2;
            Rectangle bulletRec = new Rectangle(bullet.getX(),bullet.getY(),bullet.getWidth(),bullet.getHeight());
            Rectangle wallRec =new Rectangle(wall.x,wall.y,wall.width,wall.height);
            if(bulletRec.intersects(wallRec)){
                bullet.setLiving(false);
                return false;
            };
        }
        return true;
    }
}
