package com.company.Collide;

import com.company.*;

import java.awt.*;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/26 17:07
 * @Version 1.0
 **/
public class BulletHomeCollider implements Collider {
    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if(go1 instanceof Home && go2 instanceof Bullet){
            Home home = (Home)go1;
            Rectangle homeRec = new Rectangle(home.x,home.y,home.width,home.heigh);
            Rectangle BulletRect = ((Bullet) go2).rect;
            if(homeRec.intersects(BulletRect)){
                home.setAlive(false);
                ((Bullet) go2).setLiving(false);
                Explode explode = new Explode(home.x, home.y);
                GameModel.getInstance().objects.add(explode);
            }
            return false;
        }
        if(go1 instanceof Bullet && go2 instanceof Home){
            Home home = (Home)go2;
            Rectangle homeRec = new Rectangle(home.x,home.y,home.width,home.heigh);
            Rectangle BulletRect = ((Bullet) go1).rect;
            if(homeRec.intersects(BulletRect)){
                home.setAlive(false);
                Explode explode = new Explode(home.x, home.y);
                GameModel.getInstance().objects.add(explode);
                ((Bullet) go1).setLiving(false);
            }
            return false;
        }
        return true;
    }
}
