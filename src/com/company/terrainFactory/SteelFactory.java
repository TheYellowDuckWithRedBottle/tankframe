package com.company.terrainFactory;

import com.company.enums.Dir;
import com.company.mediaLoad.ResourceMgr;

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
    public List<Terrain> CreateTerrain(int x, int y, Dir dir, int number, boolean isWhole) {
        List<Terrain> steels = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Steel steel = new Steel(x, y);
            if (isWhole) {
                steels.addAll(CreateCompWall(x, y));
            } else {
                steels.add(steel);
            }
            switch (dir) {
                case LEFT:
                    x -= steel.width;
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
    }

    @Override
    public List<Terrain> CreateCompWall(int x, int y) {
        List<Terrain> steels = new ArrayList<>();
        Steel steel1 = new Steel(x, y);
        Steel steel2 = new Steel(x + (ResourceMgr.wall.getWidth()), y);
        Steel steel3 = new Steel(x, y + ResourceMgr.wall.getHeight());
        Steel steel4 = new Steel(x + (ResourceMgr.wall.getWidth()), y + ResourceMgr.wall.getHeight());
        steels.add(steel1);
        steels.add(steel2);
        steels.add(steel3);
        steels.add(steel4);
        return steels;
    }

    ;


}
