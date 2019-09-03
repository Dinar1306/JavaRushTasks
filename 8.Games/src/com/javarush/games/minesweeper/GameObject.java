package com.javarush.games.minesweeper;

import java.util.ArrayList;
import java.util.List;

public class GameObject {
    public int x,y;
    public boolean isMine;
    public int countMineNeighbors; //сколько мин в соседнних ячейках
    public boolean isOpen;
    public boolean isFlag;

    public GameObject(int x, int y, boolean b) {
        this.x = x;
        this.y = y;
        this.isMine = b;
    }


}
