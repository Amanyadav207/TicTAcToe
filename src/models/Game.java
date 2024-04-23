package models;

import enums.GameStatus;

import java.util.List;

public class Game {
    Board board;
    List<Player> listOfPlayer;
    int nextPlayerMoveIndex;
    List<Move> listOfMoves;
    GameStatus gameStatus;
    Winner winner;

}
