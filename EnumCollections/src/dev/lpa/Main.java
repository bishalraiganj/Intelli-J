package dev.lpa;


import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Main
{

    enum WeekDay{SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY}

    public static void main(String... args)
    {

        List<WeekDay> annsWorkDays =  new ArrayList<>(List.of(WeekDay.MONDAY,WeekDay.TUESDAY,WeekDay.THURSDAY,WeekDay.FRIDAY));

        var annsDaysSet = EnumSet.copyOf(annsWorkDays);
        System.out.println(annsDaysSet.getClass().getSimpleName());
        annsDaysSet.forEach(System.out::println);

        var allDaysSet = EnumSet.allOf(WeekDay.class);
        System.out.println("-".repeat(48));
        allDaysSet.forEach(System.out::println);

        Set<WeekDay> newPersonDays = EnumSet.complementOf(annsDaysSet);
        System.out.println("-".repeat(50));
        newPersonDays.forEach(System.out::println);

        Set<WeekDay> anotherWay = EnumSet.copyOf(allDaysSet);
        anotherWay.removeAll(annsDaysSet);
        System.out.println("-".repeat(50));
        anotherWay.forEach(System.out::println);

        Set<WeekDay> businessDays = EnumSet.range(WeekDay.MONDAY,WeekDay.FRIDAY);
        System.out.println("-".repeat(50));
        businessDays.forEach((s)->System.out.println(s.toString()));

    }
}
