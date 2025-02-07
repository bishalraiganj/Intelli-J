package Adhikary.X.Pirate;

public enum Loot {
    GOLDCOIN(50),PERALNECKLACE(25);

    private final int points;
    Loot(int points)
    {
        this.points = points;
    }
}
