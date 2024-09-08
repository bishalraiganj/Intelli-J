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

        Set<Task> bobsTasks = TaskData.getTasks("Bob");
        sortAndPrint("Bob's Tasks",bobsTasks);

        Set<Task> carolsTasks = TaskData.getTasks("Carol");
        sortAndPrint("Carol's Tasks",carolsTasks);

        List<Set<Task>> assignedTasksList = List.of(annsTasks,bobsTasks,carolsTasks);

        Set<Task> assignedTasksSet = getUnion(new ArrayList<>(assignedTasksList));
        sortAndPrint("Assigned Tasks",assignedTasksSet);

        List<Set<Task>> all = List.of(tasks,assignedTasksSet);
        Set<Task> everyTask =getUnion(all);
        sortAndPrint("The True all tasks",everyTask);

        Set<Task> missingTasks = getDifference(everyTask,tasks);
        sortAndPrint("Missing Tasks",missingTasks);

        Set<Task> unassignedTasks = getDifference(tasks,assignedTasksSet);
        sortAndPrint("Unassigned Tasks",unassignedTasks,sortByPriority);

        Set<Task> overlap = getUnion(List.of(getIntersect(annsTasks,bobsTasks),getIntersect(bobsTasks,carolsTasks),getIntersect(annsTasks,carolsTasks)));
        sortAndPrint("Assigned to multiples",overlap,sortByPriority);

        List<Task> overlapping = new ArrayList<>();
        for( Set<Task> t: assignedTasksList)
        {
            overlapping.addAll(getIntersect(t,overlap));
        }
        sortAndPrint("Overlapping Tasks",overlapping,sortByPriority.thenComparing(Comparator.naturalOrder()));

        










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

    public static Set<Task> getIntersect(Set<Task> a, Set<Task> b)
    {

        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b);
        return intersect;

    }

    public static Set<Task> getDifference(Set<Task> a, Set<Task> b)
    {
        Set<Task> difference = new HashSet<>(a);
        difference.removeAll(b);
        return difference;
    }











}
