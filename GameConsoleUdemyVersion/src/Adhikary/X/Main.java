package Adhikary.X;

import Adhikary.X.Pirate.Pirate;
import Adhikary.X.Pirate.PirateGame;
import Adhikary.X.Pirate.Weapon;
import Adhikary.X.game.GameConsole;
import Adhikary.X.game.Shooter;
import Adhikary.X.game.ShooterGame;

import java.util.List;

public class Main {
    public static void main(String... args)
    {
//        GameConsole<ShooterGame> console = new GameConsole<>(new ShooterGame("" +
//                "The Shootout Game") );
//        int playerIndex = console.addPlayer();
//        console.playGame(playerIndex);

        Weapon weapon = Weapon.getWeaponByChar('P');
        System.out.println("Weapon = "+ weapon + ", hitPoints=" + weapon.getHitPoints()+
                ", minLevel = " + weapon.getMinLevel());

        List<Weapon> list = Weapon.getWeaponsByLevel(1);
        list.forEach(System.out::println);

        Pirate tim = new Pirate("Tim");
        System.out.println(tim);

        PirateGame.getTowns(0).forEach(System.out::println);
        System.out.println("-".repeat(50));
        PirateGame.getTowns(1).forEach(System.out::println);
        System.out.println("-".repeat(50));





    }
}
