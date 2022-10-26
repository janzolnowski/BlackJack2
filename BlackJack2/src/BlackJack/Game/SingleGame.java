package BlackJack.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public interface SingleGame {
    default int makeThrow(){
        Random random = new Random();
        return random.nextInt(10) + 2;
    }
    default boolean yesOrNo() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return !reader.readLine().equals("x");
    }
    default void wantMore(){
        System.out.println("want more?");
    }
    default int placeBet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("place your bet");
        return Integer.parseInt(reader.readLine());
    }
    default void startCards(){
        System.out.println("your first cards:");
    }
    default void nextThrow(){
        System.out.print("your next card: ");
    }
    default void currentScore(){
        System.out.print("your current score: ");
    }
    default void tooMuch(){
        System.out.println("too much");
        System.out.println();
    }
    default void congrats(){
        System.out.println();
        System.out.println("Congratulations");
    }
    default void blackJack(){
        System.out.println();
        System.out.println("blackjack!");
    }
    default void finalScore() {
        System.out.println();
        System.out.print("your final score: ");
    }
    default void finalCards(){
        System.out.print("your cards: ");
    }
    default void compScore(){
        System.out.print("your enemy's score: ");
    }
    default void compCards(){
        System.out.print("his cards: ");
    }
    default int chance(int num) {
        Random random = new Random();
        return random.nextInt(num);
    }
    default void youWon(){
        System.out.println("you won");
    }
    default void compWon(){
        System.out.println("you lost");
    }
    default void tie(){
        System.out.println("tie");
    }
    default void yourBalance() {
        System.out.println();
        System.out.print("your balance now: ");
    }
    default void enemyBalance(){
        System.out.println();
        System.out.print("and your opponent's: ");
    }
    default void pbankrupt(){
        System.out.println("you are bankrupt");
    }
    default void cbankrupt(){
        System.out.println("you rip off the comp");
    }
    default void thanks(){
        System.out.println("thanks for playing");
    }
    default void oneMore(){
        System.out.println("one more time?");
    }
}
