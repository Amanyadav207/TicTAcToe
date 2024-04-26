package models;

import enums.BotDiffcultlevel;
import enums.CellStatus;
import enums.Playertype;

import java.util.List;

public class bot extends Player {

    private BotDiffcultlevel diffcultlevel;

    public bot(String name, Symbols symbols, Playertype playertype, BotDiffcultlevel diffcultlevel) {
        super(name, symbols, playertype);
        this.diffcultlevel = diffcultlevel;
    }

    @Override
    public Move makeMove(Board board){
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellStatus().equals(CellStatus.Empty)) {
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }
}
