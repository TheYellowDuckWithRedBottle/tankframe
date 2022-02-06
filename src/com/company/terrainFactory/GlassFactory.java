package com.company.terrainFactory;

import com.company.enums.Dir;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/16 18:38
 * @Version 1.0
 **/
public class GlassFactory implements CreateTerrain {
    @Override
    public  List<Terrain> CreateTerrain (int x, int y, Dir dir, int number){
        List<Terrain> glasses = new ArrayList<>();
        for(int i=0;i<number;i++){
            Glass glass = (new Glass(x,y));
            glasses.add(glass);
            switch (dir) {
                case LEFT:
                    x -=glass.width ;
                    break;
                case RIGHT:
                    x += glass.width;
                    break;
                case UP:
                    y -= glass.height;
                    break;
                case DOWN:
                    y += glass.height;
                    break;
                default:
                    break;
            }

        }
        return glasses;
    }

    @Override
    public List<Terrain> CreateCompWall(int x, int y) {
        return null;
    }

    ;
}
