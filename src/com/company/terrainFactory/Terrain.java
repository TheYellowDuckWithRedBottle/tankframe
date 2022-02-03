package com.company.terrainFactory;

import com.company.model.GameObject;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/16 18:14
 * @Version 1.0
 **/
public abstract class  Terrain extends GameObject {
    public boolean isAlive;
    public abstract void disappear();
}
