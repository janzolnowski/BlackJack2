package BlackJack.Players;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayerAbs implements PlayerElements {
    private int balance;
    private int score;
    public List<Integer> scoreTable;
    public boolean blackJack;

    public PlayerAbs() {
        this.balance = 0;
        this.score = 0;
        this.scoreTable = new ArrayList<>();
        this.blackJack = false;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void addToBalance(int bet) {
        this.balance += bet;
    }

    @Override
    public void removeFromBalance(int bet) {
        this.balance -= bet;
    }

    @Override
    public void addToScore(int singleScore) {
        this.score += singleScore;
    }


    @Override
    public void winBet(int bet) {
        this.balance +=  (bet*2);
    }

    @Override
    public void printScores() {
        for (Integer element : this.scoreTable) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
