package com.company;

import com.company.Collide.Collider;
import com.company.Collide.ColliderChain;
import com.company.Collide.TankBulletCollider;
import com.company.Collide.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/7 23:36
 * @Version 1.0
 **/
public class GameModel {
    //    public List<Bullet> bullets=new ArrayList<>();
//    List<Tank> tanks = new ArrayList<>();
//    List<Explode> explodes = new ArrayList<>();
    public List<GameObject> objects = new ArrayList<>();
    Tank tank = new Tank(200, 200, Group.GOOD, this);
    ColliderChain colliderChain = new ColliderChain();
    Collider collider = new TankBulletCollider();
    Collider collider1 = new TankTankCollider();

    public GameModel() {
        for (var i = 1; i < 7; i++) {
            objects.add(new Tank(i * 100, i * 100, Group.BAD, this));
        }
    }
    public void add(GameObject gm){
        this.objects.add(gm);
    }
    public void remove(GameObject gm){
        this.objects.remove(gm);
    }
    public void paint(Graphics g) {
        tank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
        for (var i = 0; i < objects.size(); i++) {
            for (var j = i + 1; j < objects.size(); j++) {
                var object1 = objects.get(i);
                var object2 = objects.get(j);
                colliderChain.collide(object1,object2);
            }
        }
//        for(int i =0;i<tanks.size();i++){
//            objects.get(i).paint(g);
//        }
//        for(var i =0;i<bullets.size();i++){
//            for(var j=0;j<tanks.size();j++){
//                bullets.get(i).collideWithTank(tanks.get(j));
//            }
//        }
//        for(var i =0;i<explodes.size();i++){
//            explodes.get(i).paint(g);
//        }
    }
}
