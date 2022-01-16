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

    private static final GameModel INSTANCE = new GameModel();
    public static GameModel getInstance() {
        return INSTANCE;
    }
    private GameModel() {
        for (var i = 1; i < 2; i++) {
            objects.add(new Tank(i * 100, i * 100, Group.BAD, this));
        }
        objects.add(tank);
        objects.add(new Wall(500,100));
        objects.add(new Wall(600,100));
        objects.add(new Wall(700,100));
        objects.add(new Wall(800,100));
    }
    public void add(GameObject gm){
        this.objects.add(gm);
    }
    public void remove(GameObject gm){
        this.objects.remove(gm);
    }
    public void paint(Graphics g) {
        //tank.paint(g);
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

    }
}
