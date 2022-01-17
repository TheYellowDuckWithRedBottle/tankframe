package com.company.terrainFactory;

import com.company.Dir;
import com.company.Wall;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/16 18:13
 * @Version 1.0
 **/
public abstract class TerrainFactory {
    public  abstract  List<Terrain> CreateTerrain(int x, int y, Dir dir, int number);
}
