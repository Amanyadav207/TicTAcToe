package models;

import Exectionhandling.invalidMoveExecption;
import Strategies.Winnercheck;
import enums.CellStatus;
import enums.GameStatus;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> listOfPlayer;
    private int nextPlayerMoveIndex;
    private List<Move> listOfMoves;
    private GameStatus gameStatus;
    private Player player;


    private Winnercheck winnercheck;

    public Game(int size, List<Player> player) {
        this.board = new Board(size);
        this.listOfPlayer = player;
        this.listOfMoves = new ArrayList<>();
        this.gameStatus = GameStatus.In_progress;
        this.player = null;
        this.nextPlayerMoveIndex = 0;
        this.winnercheck = new Winnercheck();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getListOfPlayer() {
        return listOfPlayer;
    }

    public void setListOfPlayer(List<Player> listOfPlayer) {
        this.listOfPlayer = listOfPlayer;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public List<Move> getListOfMoves() {
        return listOfMoves;
    }

    public void setListOfMoves(List<Move> listOfMoves) {
        this.listOfMoves = listOfMoves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void printBoard() {
        this.board.printBoard();
    }

    public void makemove(Game game) throws invalidMoveExecption {
        Player currentPlayer = listOfPlayer.get(nextPlayerMoveIndex);
        Move move = currentPlayer.makeMove(board);
        if (!validateMove(move)) {
            throw new invalidMoveExecption("Invalid move by" + currentPlayer.getName());
        }
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell celltochange = board.getBoard().get(row).get(col);
        celltochange.setPlayer(currentPlayer);
        celltochange.setCellStatus(CellStatus.Filled);

        Move finalmove = new Move(celltochange,currentPlayer);
        listOfMoves.add(finalmove);
        nextPlayerMoveIndex= (nextPlayerMoveIndex +1 )% listOfPlayer.size() ;

        if (winnercheck.checkWinner(board, finalmove)) {
            gameStatus = GameStatus.Ended;
            player = currentPlayer;
        }

           
    }
    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
            return false;
        }
        return board.getBoard().get(row).get(col).getCellStatus().equals(CellStatus.Empty);
    }
}