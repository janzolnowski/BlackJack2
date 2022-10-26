package BlackJack.Players;

public class Player extends PlayerAbs{
    public String name;

    public Player(String name) {
        super();
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
