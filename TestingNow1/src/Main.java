import java.util.*;


class Connection {

    public Employee e ;
    public Connection(Employee e)
    {
        this.e = e;
    }
}
class Employee {

    public int id;
    public Employee(int id)
    {
        this.id = id;
    }

}
public class Main {

    public static int main(String... args)
    {


        Scanner s = new Scanner(System.in);
//        String input = s.nextLine();
//        String[] inputs = input.split(" ");
        int numOfWorkers= s.nextInt();
        int numOfConnections = s.nextInt();
        List<Employee> employees = new ArrayList<>();
        for(int i= 0;i<numOfWorkers;i++)
        {
            employees.add(new Employee(i));
        }
        LinkedHashMap<Connection,Integer> connectionsMap = new LinkedHashMap<>();
        int currRosterCount = 0;

        for(int i = 0 ; i < numOfConnections ; i++)
        {
//            String cInput = s.nextLine();
//            String[] c = cInput.split(" ");
            int id= s.nextInt();
            int friendsId = s.nextInt();

            connectionsMap.put(new Connection(employees.get(id)),friendsId);
        }

        int rosterTargetCount = s.nextInt();
        s.nextLine();


        if(inputValidation(numOfWorkers,numOfConnections,rosterTargetCount)) {
            int dayCount = 1;
            LinkedHashMap<Employee, Boolean> currDayAllStatusMap = new LinkedHashMap<>();
            for (Employee e : employees) {

                currDayAllStatusMap.put(e, true);
            }
            currRosterCount = numOfWorkers;
            while (currRosterCount < rosterTargetCount) {
                LinkedHashMap<Employee, Boolean> nextDayAllStatusMap = new LinkedHashMap<>();

                for (Employee e : employees) {
                    LinkedHashMap<Employee, Boolean> friendsStatusMap = friendsMap(employees,e, connectionsMap, currDayAllStatusMap);
                    if (officeLogicCheck(currDayAllStatusMap.get(e), friendsStatusMap))
                        currRosterCount++;


                    nextDayAllStatusMap.put(e, officeLogicCheck(currDayAllStatusMap.get(e), friendsStatusMap));
                }
                currDayAllStatusMap = nextDayAllStatusMap;
                dayCount++;
            }


            System.out.println( dayCount);
            return dayCount;
        }
        return -1;
    }
    public static boolean inputValidation(int n,int m,int k)
    {
        return n > 3 && m < 30 && k < 50 && k >1;
    }

    public static LinkedHashMap<Employee,Boolean> friendsMap(List<Employee> eList,Employee employee, Map<Connection,Integer> connectionsMap,Map<Employee,Boolean> allStatusMap)
    {
        LinkedHashMap<Employee,Boolean> friendsStatusMap = new LinkedHashMap<>();
        for(Map.Entry<Connection,Integer> entry : connectionsMap.entrySet())
        {
            if(entry.getKey().e==employee)
            {
                friendsStatusMap.put(eList.get(entry.getValue()),allStatusMap.get(eList.get(entry.getValue())));
            }
            if(entry.getValue()==employee.id)
            {
                friendsStatusMap.put(entry.getKey().e,allStatusMap.get(entry.getKey().e));
            }
        }
        return friendsStatusMap;
    }

    public static boolean officeLogicCheck(boolean workerStatus ,LinkedHashMap<Employee,Boolean> map)
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