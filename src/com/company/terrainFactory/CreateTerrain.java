package com.company.terrainFactory;

import com.company.enums.Dir;

import java.util.List;

public interface CreateTerrain {
      List<Terrain> CreateTerrain(int x, int y, Dir dir, int number);
}
