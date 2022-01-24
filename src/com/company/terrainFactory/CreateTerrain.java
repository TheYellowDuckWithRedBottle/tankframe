package com.company.terrainFactory;

import com.company.Dir;

import java.util.List;

public interface CreateTerrain {
      List<Terrain> CreateTerrain(int x, int y, Dir dir, int number);
}
