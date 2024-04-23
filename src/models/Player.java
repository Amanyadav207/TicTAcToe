package models;

import enums.Playertype;

public class Player {
    String name;
    Symbols symbols;
    Playertype playertype;

    public Player(String name, Symbols symbols, Playertype playertype) {
        this.name = name;
        this.symbols = symbols;
        this.playertype = playertype;
    }
}
