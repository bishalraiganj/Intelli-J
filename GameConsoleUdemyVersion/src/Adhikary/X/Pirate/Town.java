package Adhikary.X.Pirate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public record Town(String name, String island, int level, List<Loot> loot,List<Feature> features,List<Combatant> opponents)
{

    public Town{
        loot = randomReduce(new ArrayList<>(EnumSet.allOf(Loot.class)),level+2);

        features = randomReduce(new ArrayList<>(EnumSet.allOf(Feature.class)),level+3);
        opponents = new ArrayList<>();
        if(level == 0)
        {
            opponents.add(new Islander("Joe",Weapon.KNIFE));
        }
        else
        {
            opponents.add(new Islander("Joe",Weapon.MACHETE));
            opponents.add(new Soldier("John",Weapon.PISTOL));
        }
    }

    public Town(String name,String island, int level)
    {
        this(name,island,level,null,null,null);
    }

    private <T> List<T> randomReduce(List<T> list,int size)
    {
        Collections.shuffle(list);
        return list.subList(0,size);
    }

    @Override
    public String toString()
    {
        return name + ", " + island;
    }

    public String information() {
        return "Town: " + this + "\n\tloot=" + loot +
                "\n\tfeatures=" + features +
                "\n\topponents=" + opponents;
    }

    @Override
    public List<Loot> loot()
    {
        return (loot==null?null:new ArrayList<>(loot));
    }

    @Override
    public List<Combatant> opponents()
    {
        return (opponents == null?null:new ArrayList<>(opponents));
    }

    @Override
    public List<Feature> features()
    {
        return (features == null ? null : new ArrayList<>(features));
    }




}
