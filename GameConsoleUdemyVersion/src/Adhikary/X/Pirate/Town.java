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

    private <T> List<T> randomReduce(List<T> list,int size)
    {
        Collections.shuffle(list);
        return list.subList(0,size);
    }


}
