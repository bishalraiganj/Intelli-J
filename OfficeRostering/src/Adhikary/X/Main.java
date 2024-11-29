package Adhikary.X;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String... args)
    {

        rosterCalculation();







    }
    public static boolean inputValidation(int n,int m,int k)
    {
        return n > 3 && m < 30 && k < 50 && k < 1;
    }
    public static int rosterCalculation()
    {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String[] inputs = input.split(" ");
        int numOfWorkers= Integer.parseInt(inputs[0]);
        int numOfConnections = Integer.parseInt(inputs[1]);
        LinkedHashMap<Integer,Integer> connectionsMap = new LinkedHashMap<>();
        int currRosterCount = 0;

        for(int i = 0 ; i < numOfConnections ; i++)
        {
            String cInput = s.nextLine();
            String[] c = cInput.split(" ");
            int id= Integer.parseInt(inputs[0]);
            int friendsId = Integer.parseInt(inputs[1]);
            connectionsMap.put(id,friendsId);
        }

        int rosterTargetCount = s.nextInt();
        s.nextLine();

        if(inputValidation(numOfWorkers,numOfConnections,rosterTargetCount)) {
            int dayCount = 1;
            LinkedHashMap<Integer, Boolean> currDayAllStatusMap = new LinkedHashMap<>();
            for (int i = 0; i < numOfWorkers; i++) {
                currDayAllStatusMap.put(i, true);
            }
            currRosterCount = numOfWorkers;
            while (currRosterCount < rosterTargetCount) {
                LinkedHashMap<Integer, Boolean> nextDayAllStatusMap = new LinkedHashMap<>();

                for (int i = 0; i < numOfWorkers; i++) {
                    LinkedHashMap<Integer, Boolean> friendsStatusMap = friendsMap(i, connectionsMap, currDayAllStatusMap);
                    if (officeLogicCheck(currDayAllStatusMap.get(i), friendsStatusMap))
                        currRosterCount++;

                    nextDayAllStatusMap.put(i, officeLogicCheck(currDayAllStatusMap.get(i), friendsStatusMap));
                }
                currDayAllStatusMap = nextDayAllStatusMap;
                dayCount++;
            }


            return dayCount;
        }
        return 0;



    }

    public static LinkedHashMap<Integer,Boolean> friendsMap(int id, Map<Integer,Integer> connectionsMap,Map<Integer,Boolean> allStatusMap)
    {
        LinkedHashMap<Integer,Boolean> friendsStatusMap = new LinkedHashMap<>();
        for(Map.Entry<Integer,Integer> entry : connectionsMap.entrySet())
        {
            if(entry.getKey()==id)
            {
                friendsStatusMap.put(entry.getValue(),allStatusMap.get(entry.getValue()));
            }
            if(entry.getValue()==id)
            {
                friendsStatusMap.put(entry.getKey(),allStatusMap.get(entry.getKey()));
            }
        }
        return friendsStatusMap;
    }

    public static boolean officeLogicCheck(boolean workerStatus ,LinkedHashMap<Integer,Boolean> map)
    {
        if(workerStatus == true )
        {
            int wfoCount=0;
            for(Boolean e: map.values())
            {
                if (e==true)
                {
                    wfoCount++;
                }
            }
            if(wfoCount==3)
            {
                return true;
            }
        }
         if (workerStatus== false)
        {
            int wfoCount = 0;
            for(boolean e : map.values())
            {
                if(e == true)
                {
                    wfoCount++;
                }
            }
            if(wfoCount<3)
            {
                return true;
            }
        }
            return false;
    }





}
