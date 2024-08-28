package dev.lpa;

import java.util.HashSet;
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
            Infrastructure, Security, High, In progress
            Infrastructure, Password Policy, Medium, In Progress
            Research, Cloud solutions, Medium, In progress
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


    public static Set<Task> getTasks(String owner)
    {
        Set<Task> taskList = new HashSet<>();
        String user = ("ann,bob,carol".contains(owner.toLowerCase())? owner:null);
        String selectedList = switch(user)
        {
            case "ann" -> annsTasks;
            case "bob" ->bobsTasks;
            case "carol" ->carolsTasks;
            default ->tasks;


        };




        return taskList;



    }





}
