package Adhikary.X.game;

public record Shooter(String name) {

    boolean findPrize()
    {
        System.out.println("Prize found, Score should be adjusted. ");
        return false;
    }

    boolean useWeapon(String weapon)
    {
        System.out.println("You Shot your " + weapon);
        return false;
    }
}
