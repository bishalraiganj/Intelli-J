package dev.lpa;


import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Main
{

    enum WeekDay{SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY}

    public static void main(String... args)
    {

        List<WeekDay> annsWorkDays =  new ArrayList<>(List.of(WeekDay.MONDAY,WeekDay.TUESDAY,WeekDay.THURSDAY,WeekDay.FRIDAY));

        var annsDaysSet = EnumSet.copyOf(annsWorkDays);
        System.out.println(annsDaysSet.getClass().getSimpleName());
    }
}
