package BlackJack.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface StartElements {
    default String setPlayerName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        System.out.println("hi, "+ name);
        return name;
    }
    default int setBalances() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }
    default void start(){
        System.out.println("hi! ");
    }
    default void tellName(){
        System.out.println("tell your name");
    }
    default void wantRules(){
        System.out.println("want rules?");
    }
    default void getRules(){
        System.out.println("rules");
    }
    default void howMuch(){
        System.out.println("set your balance");
    }
}
