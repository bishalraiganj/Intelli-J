package dev.lpa;

import java.util.*;

public class Main {

    public static void main(String... args)
    {


//        System.out.println(TaskData.getTasksScanner("carol"));

        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All Tasks",tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);

        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's Tasks",annsTasks,sortByPriority);




    }

    public static void sortAndPrint(String header,Collection<Task> collection)
    {

        sortAndPrint(header,collection,null);

    }

    public static void sortAndPrint(String header, Collection<Task> collection, Comparator<Task> sorter)
    {

        System.out.println("-".repeat(90));
        System.out.println(header);
        System.out.println("-".repeat(90));

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);


    }

    public static Set<Task> getUnion(List<Set<Task>> list)
    {
        Set<Task> union = new HashSet<>();
        for(Set<Task> set : list)
        {
            union.addAll(set);

        }

        return union;

    }

    public static Set<Task> getIntersect(Set<Task> set1, Set<Task> set2)
    {

        Set<Task> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);
        return intersect;

    }

    public static Set<Task> getDifference(Set<Task> set1, Set<Task> set2)
    {
        Set<Task> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }











}
