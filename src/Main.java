import Controller.gameController;
import enums.BotDiffcultlevel;
import enums.GameStatus;
import enums.Playertype;
import models.Game;
import models.Player;
import models.Symbols;
import models.bot;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        gameController gameController = new gameController();

        int dimension = scanner.nextInt();
        List<Player> players = List.of(
                new Player("Aman", new Symbols('X'), Playertype.Human),
                new bot("Scaler", new Symbols('O'), Playertype.BOT, BotDiffcultlevel.Easy)
        );

        Game game = gameController.StartGame(dimension, players);
        while (game.getGameStatus().equals(GameStatus.In_progress)) {
            gameController.printBoard(game);

            //2. Player's turn
            gameController.makemove(game);
        }

        if (!gameController.checkstate(game).equals(GameStatus.Ended)) {
            game.setGameStatus(GameStatus.Drawn);
            System.out.println("Game DRAW");
        } else {
            gameController.printBoard(game);
            System.out.println("Player " + gameController.getWinner(game).getName() + " is the winner");
        }
    }
}
