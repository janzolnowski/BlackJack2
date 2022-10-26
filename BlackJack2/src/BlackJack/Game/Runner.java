package BlackJack.Game;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        GameElements official = new GameElements();
        while (official.another) {
            official.singleStart();
            if (!official.player.blackJack)
                official.takeCards();
            official.computerGame();
            official.getWinner();
            official.anotherRound();
        }
    }
}
