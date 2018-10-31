package com.tdefense.world.map.map;

import com.tdefense.system.Constant;

public class MapUtils {
    public static int[][] getMap() {
        return new int[][] {
                // y index: 0  1  2  3  4  5  6  7  8       x index:
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 0
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 1
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 2
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 3
                { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, // 4
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 5
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 6
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 7
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }  // 8
        };
    }

    static void translateCellMap(Cell[][] cells, int[][] mapData) {
        for (int x = 0; x < Constant.MAP_LENGTH_X; x++) {
            for (int y = 0; y < Constant.MAP_LENGTH_Y; y++) {

                if (mapData[x][y] == Constant.GRASS_CODE) {
                    cells[x][y] = new Cell(CellType.GRASS, scale(x), scale(x), x, y);
                }

                else if (mapData[x][y] == Constant.PATH_CODE) {
                    cells[x][y] = new Cell(CellType.PATH, scale(x), scale(x), x, y);
                }

                else if (mapData[x][y] == Constant.FINAL_CODE) {
                    Cell finalCell = new Cell(CellType.PATH_FINAL, scale(x), scale(x), x, y);
                    CellMap.setFinalCell(finalCell);
                }

                else if (mapData[x][y] == Constant.ORIGIN_CODE) {
                    Cell startCell = new Cell(CellType.PATH_ORIGIN, scale(x), scale(x), x, y);
                    CellMap.setStartCell(startCell);
                }
            }
        }
    }

    /**
     * Scales provided value, by {@link Constant#TILE_SCALE}, so that after transformation - the value returned to caller
     * represents tile position in relation to other tiles, as if it was a part of map's tile "grid". (which is not
     * a real thing in this project as of now)
     * @param value the value to be scaled
     * @return scaled value
     * @author mx
     */
    public static float scale(float value) {
        return value * Constant.TILE_SCALE;
    }
}
