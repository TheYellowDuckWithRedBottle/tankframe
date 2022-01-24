package com.company.Collide;

import com.company.GameObject;

public interface Collider {
    boolean collide(GameObject go1,GameObject go2);
}
