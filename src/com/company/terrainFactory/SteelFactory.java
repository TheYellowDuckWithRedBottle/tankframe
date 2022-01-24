package com.company.terrainFactory;

import com.company.Dir;
import com.company.Wall;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author LeviFan
 * @Date 2022/1/16 18:36
 * @Version 1.0
 **/
public class SteelFactory implements CreateTerrain {
@Override
    public  List<Terrain> CreateTerrain(int x, int y, Dir dir, int number){
        List<Terrain> steels = new ArrayList<>();
        for(int i=0;i<number;i++){
            Steel steel = (new Steel(x,y));
            steels.add(steel);
            switch (dir) {
                case LEFT:
                    x -=steel.width ;
                    break;
                case RIGHT:
                    x += steel.width;
                    break;
                case UP:
                    y -= steel.height;
                    break;
                case DOWN:
                    y += steel.height;
                    break;
                default:
                    break;
            }

        }
        return steels;
    };


}
