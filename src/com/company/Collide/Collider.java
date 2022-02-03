package com.company.Collide;

import com.company.model.GameObject;

public interface Collider {
    boolean collide(GameObject go1,GameObject go2);
}
