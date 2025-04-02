import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LastChallengeMain {

    public static void main(String... args)
    {
        Course pymc = new Course("PYMC","Python Masterclass");
        Course jmc = new Course("JMC","Java Masterclass");
        Course dsa = new Course("DSA","Data Structures and Algorithms",new Random().nextInt(41,100));
        Course microservices = new Course("MSV","Microservices",new Random().nextInt(41,100));
        Course spring = new Course("SSPB","Spring and SpringBoot ", new Random().nextInt(41,100));

        List<Student> students = Stream.generate(()->Student.getRandomStudent(dsa,jmc,microservices))
                .limit(10000)
                .collect(()->new ArrayList<>(),(ArrayList<Student> e1,Student e2)->e1.add(e2),(e3,e4)->e3.addAll(e4));
//        students.forEach((e)->System.out.println(e.getEngagementMap().keySet()));



        List<Student> enrolledInAll =
                students.stream()
                        .filter((e)->{
                            boolean dsaStatus = false;
                            boolean jmcStatus = false;
                            boolean microservicesStatus = false;
                            for(String courseCode:e.getEngagementMap().keySet())
                            {
                                if(courseCode.equals("DSA"))
                                {
                                    dsaStatus = true;
                                }else if(courseCode.equals("JMC"))
                                {
                                    jmcStatus = true;
                                }
                                else if(courseCode.equals("MSV"))
                                {
                                    microservicesStatus = true;
                                }
                            }
                            if(dsaStatus&&jmcStatus&&microservicesStatus)
                            {
                                return true;
                            }
                            else
                                return false;

                        })
                .collect(()->new ArrayList<>(),(ArrayList<Student> e1,Student e2)->e1.add(e2),(e3,e4)->e3.addAll(e4));

//                enrolledInAll.forEach((e)->System.out.println(e.getEngagementMap().keySet()));

                System.out.println(enrolledInAll.size());

                System.out.println("-".repeat(50));


               /* List<Student> enrolledInAll2 = students.stream()
                        .collect()
*/





    }

}
