package dev.lpa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TaskData {

    private static String tasks= """
            Infrastructure, Logging, High
            Infrastructure, DB Access, Medium
            Infrastructure, Security, High
            Infrastructure, Password Policy, Medium
            Data design, Task Table, Medium
            Data Design, Employee Table, Medium
            Data Design, Cross Reference Tables, High
            Data Design, Encryption Policy, High
            Data Access, Write Views, Low
            Data Access, Set up Users, Low
            Data Access, Set Up Access Policy, Low
            """;

    private static String annsTasks= """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy, Medium, In Progress
            Research, Cloud solutions, Medium, In Progress
            Data design, Encryption Policy, High
            Data design, Project Table, Medium
            Data Access, Write views, Low, In Progress
            """;

    private static String bobsTasks = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy, Medium
            Data Design, Encryption Policy, High
            Data Access, Write Views, Low, In Progress
            """;
    private static String carolsTasks= """
            Infrastructure, Logging, High, In Progress
            Infrastructure, DB Acesss, Medium
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, High
            Data Design, Write Views, Low
            """;


    public static Set<Task> getTasksScanner(String owner)
    {
        Set<Task> taskList = new HashSet<>();
        String user = ("ann,bob,carol".contains(owner.toLowerCase())? owner:null);
        String selectedList = switch(owner.toLowerCase())
        {
            case "ann" -> annsTasks;
            case "bob" ->bobsTasks;
            case "carol" ->carolsTasks;
            default ->tasks;
        };

        Scanner scanner = new Scanner(selectedList);
        while(scanner.hasNext())
        {


            String[] fields = scanner.nextLine().split(",");
            Arrays.asList(fields).replaceAll((s)->s.trim().replace(" ",""));

            for(int i=0;i<fields.length;i++)
            {
                fields[i] = switch(fields[i])
                {
                    case "High" -> "HIGH";
                    case "Low" -> "LOW";
                    case "Medium"-> "MEDIUM";
                    case "InProgress" -> "IN_PROGRESS";
                    case "Assigned" -> "ASSIGNED";
                    case "InQueue" -> "IN_QUEUE";
                    default -> fields[i];
                };

            }
            if(fields.length==3)
            {
                Task t =new Task(fields[0],fields[1],user,Priority.valueOf(fields[2]));
                taskList.add(t);

            }

            else if(fields.length==4)
            {
                Task t=new Task(fields[0],fields[1],user,Priority.valueOf(fields[2]),Status.valueOf(fields[3]));
                taskList.add(t);
            }
        }

        return taskList;
    }

    public static Set<Task> getTasks(String owner)
    {

        Set<Task> taskList = new HashSet<>();
        String user = ("ann,bob,carol".contains(owner.toLowerCase())? owner:null);
        String selectedList = switch(owner.toLowerCase())
        {
            case "ann" -> annsTasks;
            case "bob" ->bobsTasks;
            case "carol" ->carolsTasks;
            default ->tasks;
        };






    }





}
