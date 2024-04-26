package Controller;

import enums.GameStatus;
import models.Game;
import models.Player;

import java.util.List;

public class gameController {

    public Game StartGame(int size, List<Player> players){
        return new Game(size,players);
    }
    public void makemove(Game game){
        return;
    }
    public GameStatus checkstate(Game game){
        return game.getGameStatus();
    }
    public Player getWinner(Game game){
        return game.getPlayer();
    }
    public void printBoard(Game game){
        game.printBoard();
    }
}
