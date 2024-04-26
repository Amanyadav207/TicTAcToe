package models;

import enums.Playertype;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbols symbols;
    private Playertype playertype;
    private static Scanner scanner = new Scanner(System.in);

    public Player(String name, Symbols symbols, Playertype playertype) {
        this.name = name;
        this.symbols = symbols;
        this.playertype = playertype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbols getSymbols() {
        return symbols;
    }

    public void setSymbols(Symbols symbols) {
        this.symbols = symbols;
    }

    public Playertype getPlayertype() {
        return playertype;
    }

    public void setPlayertype(Playertype playertype) {
        this.playertype = playertype;
    }

    public Move makeMove(Board board) {
        //Ask the user where they want to place the symbol.

        System.out.println("Please enter the row number where you want to make a move ?");
        int row = scanner.nextInt();

        System.out.println("Please enter the col number where you want to make a move ?");
        int col = scanner.nextInt();

        return new Move(new Cell(row, col), this);
    }

}
