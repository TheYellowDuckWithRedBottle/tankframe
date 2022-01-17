package com.company.Collide;

import com.company.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/8 20:15
 * @Version 1.0
 **/
public class ColliderChain implements Collider {
    public List<Collider> colliderChains = new ArrayList<>();

    public ColliderChain() {
        colliderChains.add(new TankBulletCollider());
        colliderChains.add(new TankTankCollider());
        colliderChains.add(new TankWallCollider());
        colliderChains.add(new BulletWallCollider());
        colliderChains.add(new TankSteelCollide());
        colliderChains.add(new BulletSteelCollider());
    }
    public void addCollider(Collider collider){
        this.colliderChains.add(collider);
    }

    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        for(var collider:colliderChains){
            if(!collider.collide(go1,go2)){//如果撞上有问题
                return false;
            }
        }
        return true;
    }
}
