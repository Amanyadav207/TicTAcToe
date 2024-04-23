package models;

import enums.CellStatus;

public class Cell {
    int row;
    int col;
    Player player;
    private CellStatus cellStatus;

    public Cell(int row, int col, Player player, CellStatus cellStatus) {
        this.row = row;
        this.col = col;
        this.player = player;
        this.cellStatus = cellStatus;
    }
}
