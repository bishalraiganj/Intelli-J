package Adhikary.X.Pirate;

import Adhikary.X.game.Player;

import java.util.*;

public sealed abstract class Combatant implements Player permits Pirate , Islander , Soldier
{

    private final String name;

    private final Map<String,Integer> gameData;

//    private final List<String> townsVisited = new LinkedList<>();

    private Weapon currentWeapon ;

    public Combatant(String name)
    {
        this.name = name;
    }

    public Combatant(String name,Map<String,Integer> gameData)
    {
        this.name = name;
        if(gameData !=null)
        {
            this.gameData.putAll(gameData);
        }
    }

    //-------------------------------------------------

    {
        gameData = new HashMap<>(Map.of("health",100,"score",0));

    }

    public Weapon getCurrentWeapon()
    {
        return currentWeapon;
    }

    void  setCurrentWeapon(Weapon currentWeapon)
    {
        this.currentWeapon=currentWeapon;
    }

    int value(String name)
    {
        return gameData.get(name);
    }

    protected void setValue(String name,int value)
    {
        gameData.put(name,value);
    }
    protected void adjustValue(String name,int adj)
    {
        gameData.compute(name,(k,v)->v+=adj);
    }
    protected void adjustHealth(int adj)
    {
        int health = value("health");
        health += adj;
        setValue("health",((health<0? 0:(health>100?100:health))));
    }
    boolean useWeapon(Combatant opponent)
    {
        System.out.println(name + " used the " + currentWeapon);
        if(new Random().nextBoolean())
        {
            System.out.println(" and HIT ***" + opponent.name() + "! ***");
            opponent.adjustHealth(-currentWeapon.getHitPoints());
            System.out.printf("%s's health=%d, %s's health=%d%n",name,value("health"),opponent.name(),opponent.value("health"));
            adjustValue("score",50);
        }
        else {
            System.out.println( " and Missed ");
        }
        return (opponent.value("health") <= 0 );
    }
//    boolean visitTown()
//    {
//       List<String> levelTowns = PirateGame.getTowns(value("level"));
//       if(levelTowns == null) return true;
//       String town = levelTowns.get(value("townIndex"));
//
//        if(town != null)
//        {
//            townsVisited.add(town);
//            return false;
//        }
//        return true;
//    }
    @Override
    public String name()
    {
        return name;
    }
//    @Override
//    public String toString()
//    {
//        String current = ((LinkedList<String>) townsVisited).getLast();
//        String[] simpleNames = new String[townsVisited.size()];
//        Arrays.setAll(simpleNames,(i)->townsVisited.get(i).split(",")[0]);
//        return "--->" + current + "\nPirate "+name + " " + gameData +
//                "\n\ttownsVisited=" +Arrays.toString(simpleNames);
//    }
//
//    private boolean visitNextTown() {
//        int townIndex = value("townIndex");
//        var towns = PirateGame.getTowns(value("level"));
//        if (towns == null) return true;
//        if (townIndex >= (towns.size() - 1)) {
//            System.out.println("Leveling up! Bonus: 500 points!");
//            adjustValue("score", 500);
//            adjustValue("level", 1);
//            setValue("townIndex", 0);
//        } else
//        {
//            System.out.println("Sailing to next town! Bonus: 50  points !");
//            adjustValue("townIndex",1);
//            adjustValue("score",50);
//        }
//        return visitTown();
//    }


    @Override
    public String toString()
    {
        return name;
    }

    public String information()
    {
        return name+" " + gameData;
    }
}
