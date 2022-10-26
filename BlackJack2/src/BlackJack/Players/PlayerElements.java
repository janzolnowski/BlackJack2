package BlackJack.Players;

import java.util.List;

public interface PlayerElements {
    void addToBalance(int bet);
    void removeFromBalance(int bet);
    void addToScore(int singleScore);
    void winBet(int bet);
    void printScores ();

}
