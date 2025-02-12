package Adhikary.X.Pirate;

import java.util.*;

public final class Pirate extends Combatant{

//    private final String name;
//
//    private final Map<String,Integer> gameData;

    private final List<Town> townsVisited = new LinkedList<Town>();

    private List<Loot> loot;

    private List<Combatant> opponents;

    private List<Feature> features;

//    private Weapon currentWeapon ;

//    public Pirate(String name)
//    {
//        this.name = name;
//    }

    public Pirate(String name)
    {
        super(name,Map.of("level",0,"townIndex",0));
        visitTown();
    }

    //-------------------------------------------------
//
//    {
//        gameData = new HashMap<>(Map.of("health",100,"score",0,
//                "level",0,"townIndex",0));
//        visitTown();
//    }

//    public Weapon getCurrentWeapon()
//    {
//        return currentWeapon;
//    }
//
//    void  setCurrentWeapon(Weapon currentWeapon)
//    {
//        this.currentWeapon=currentWeapon;
//    }

//    int value(String name)
//    {
//        return gameData.get(name);
//    }
//
//    private void setValue(String name,int value)
//    {
//        gameData.put(name,value);
//    }
//    private void adjustValue(String name,int adj)
//    {
//        gameData.compute(name,(k,v)->v+=adj);
//    }
//    private void adjustHealth(int adj)
//    {
//        int health = value("health");
//        health += adj;
//        setValue("health",((health<0? 0:(health>100?100:health))));
//    }
    boolean useWeapon()
    {
        System.out.println("Used the "+ super.getCurrentWeapon());
        return visitNextTown();
    }
    boolean visitTown()
    {
       List<Town> levelTowns = PirateGame.getTowns(value("level"));
       if(levelTowns == null) return true;
       Town town = levelTowns.get(value("townIndex"));

        if(town != null)
        {
            townsVisited.add(town);
            return false;
        }
        return true;
    }
//    @Override
//    public String name()
//    {
//        return name;
//    }


    public String information()
    {
        String current = ((LinkedList<String>) townsVisited).getLast();
        String[] simpleNames = new String[townsVisited.size()];
        Arrays.setAll(simpleNames,(i)->townsVisited.get(i).split(",")[0]);
        return "--->" + current + "\n" + super.information() +
                "\n\ttownsVisited=" +Arrays.toString(simpleNames);
    }

    private boolean visitNextTown() {
        int townIndex = value("townIndex");
        List<Town> towns = PirateGame.getTowns(value("level"));
        if (towns == null) return true;
        if (townIndex >= (towns.size() - 1)) {
            System.out.println("Leveling up! Bonus: 500 points!");
            adjustValue("score", 500);
            adjustValue("level", 1);
            setValue("townIndex", 0);
        } else
        {
            System.out.println("Sailing to next town! Bonus: 50  points !");
            adjustValue("townIndex",1);
            adjustValue("score",50);
        }
        return visitTown();
    }
}
