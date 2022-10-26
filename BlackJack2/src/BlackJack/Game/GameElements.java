package BlackJack.Game;

import BlackJack.Players.Computer;
import BlackJack.Players.Player;
import BlackJack.Players.PlayerAbs;

import java.io.IOException;

public class GameElements implements StartElements, SingleGame {
    public PlayerAbs player;
    public PlayerAbs comp;
    private int bet;
    public boolean another;

    public GameElements() throws IOException {
        start();
        tellName();
        this.player = new Player(setPlayerName());
        this.comp = new Computer();
        this.another = true;
        wantRules();
        if (!yesOrNo())
            getRules();
        howMuch();
        int value = setBalances();
        player.setBalance(value);
        comp.setBalance(value);
    }

    public void singleStart() throws IOException {
        player.setScore(0);
        comp.setScore(0);
        player.scoreTable.clear();
        comp.scoreTable.clear();
        this.bet = placeBet();
        player.removeFromBalance(bet);
        comp.removeFromBalance(bet);
        for (int i = 0; i < 2; i++) {
            int playerThrow = makeThrow();
            int compThrow = makeThrow();
            player.addToScore(playerThrow);
            comp.addToScore(compThrow);
            player.scoreTable.add(playerThrow);
            comp.scoreTable.add(compThrow);
        }
        startCards();
        player.printScores();
        currentScore();
        System.out.println(player.getScore());
        if (player.getScore() == 21 || player.getScore() == 22) {
            congrats();
            blackJack();
            player.blackJack = true;
        }
        else
            wantMore();
    }

    public void takeCards() throws IOException {
        while (yesOrNo()) {
            int next = makeThrow();
            player.addToScore(next);
            player.scoreTable.add(next);
            nextThrow();
            System.out.println(next);
            currentScore();
            System.out.println(player.getScore());
            if (player.getScore() == 21){
                player.blackJack = true;
                break;
            }
            if (player.getScore() > 21)
                break;
            wantMore();
        }
        finalScore();
        System.out.println(player.getScore());
        finalCards();
        player.printScores();
        if (player.getScore() > 21) {
            tooMuch();
        }
        else if (player.getScore() == 21) {
            blackJack();
            congrats();
        }
        else
            System.out.println();
    }

    public void computerGame(){
        if (comp.getScore() == 21 || comp.getScore() == 22){
            compScore();
            System.out.println(comp.getScore());
            compCards();
            comp.printScores();
            blackJack();
            comp.blackJack = true;

        } else {
            while (comp.getScore() < 17) {
                int next = makeThrow();
                comp.addToScore(next);
                comp.scoreTable.add(next);
            }
            if (comp.getScore() == 19){
                if (chance(4) == 1) {
                    int next = makeThrow();
                    comp.addToScore(next);
                    comp.scoreTable.add(next);
                }
            }
            if (comp.getScore() < 19){
                if (chance(3) == 1) {
                    int next = makeThrow();
                    comp.addToScore(next);
                    comp.scoreTable.add(next);
                }
            }
            compScore();
            System.out.println(comp.getScore());
            compCards();
            comp.printScores();
            if (comp.getScore() == 21){
                blackJack();
                comp.blackJack = true;
            }
            if (comp.getScore() > 21) {
                tooMuch();
            }
        }
    }
    public void getWinner(){
        if (player.blackJack && comp.blackJack) {
            tie();
            player.addToBalance(bet);
            comp.addToBalance(bet);
        }
        else if (player.getScore() > 21 && comp.getScore() > 21) {
            tie();
            player.addToBalance(bet);
            comp.addToBalance(bet);
        }
        else if (player.getScore() == comp.getScore()){
            tie();
            player.addToBalance(bet);
            comp.addToBalance(bet);
        }
        else if (player.blackJack && !comp.blackJack){
            youWon();
            player.winBet(bet);
        }
        else if (comp.blackJack && !player.blackJack){
            compWon();
            comp.winBet(bet);
        }
        else if (player.getScore() > 21 && comp.getScore() < 21){
            compWon();
            comp.winBet(bet);
        }
        else if (comp.getScore() > 21 && player.getScore() < 21){
            youWon();
            player.winBet(bet);
        }
        else if (player.getScore() > comp.getScore()){
            youWon();
            player.winBet(bet);
        }
        else if (player.getScore() < comp.getScore()) {
            compWon();
            comp.winBet(bet);
        }
        yourBalance();
        System.out.println(player.getBalance());
        enemyBalance();
        System.out.println(comp.getBalance());
    }

    public void anotherRound() throws IOException {
        if (player.getBalance() == 0){
            pbankrupt();
            thanks();
            another = false;
        } else if (comp.getBalance() == 0) {
            congrats();
            cbankrupt();
            thanks();
            another = false;
        } else{
            oneMore();
            another = yesOrNo();
            if (!another)
                thanks();
        }
    }



}
