package Adhikary.X;

import com.sun.source.tree.Tree;

import java.time.LocalDate;
import java.time.Year;
import java.util.*;

public class Student {

    private final long studentId;
    private final String countryCode;
    private final int yearEnrolled;
    private final int ageEnrolled;
    private final String gender;
    private final boolean programmingExperience;
    private final Map<String,CourseEngagement> engagementMap;



    public Student(long studentId,String countryCode,int yearEnrolled,int ageEnrolled,String gender,boolean programmingExperience,Course[] courses) // yearEnrolled must be less than the current year otherwise logic inside this constructor would fail
    {
        this.studentId = studentId;
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageEnrolled =  ageEnrolled;
        this.gender = gender;
        this.programmingExperience = programmingExperience;
//        this.engagementMap =new TreeMap<>(Comparator.comparing((e)->engagementMap.get(e)));
//        this.engagementMap = new TreeMap<>(Comparator.comparing(CourseEngagement::engagementMap.get(e)))

        Random random = new Random();
        Map<String,CourseEngagement> courseMap  = new TreeMap<>();
        for(Course c :courses )
        {

            LocalDate currentDate = LocalDate.now();
            int courseYear = random.nextInt(yearEnrolled,currentDate.getYear()+1); // This is a random year between student enrollment and current year

            int courseMonth =  random.nextInt(1,(courseYear<currentDate.getYear()?13:currentDate.getMonthValue()+1));
            int courseDateBound ;
            if(courseMonth==2)
        {
            if(Year.isLeap(courseYear))
            {
                courseDateBound = 29;
            }
            courseDateBound=28;
        }
            else
                courseDateBound = switch(courseMonth)
                {
                    case 1->31;
                    case 2->28;
                    case 3->31;
                    case 4->30;
                    case 5->31;
                    case 6->30;
                    case 7->31;
                    case 8->31;
                    case 9->30;
                    case 10->31;
                    case 11->30;

                    default->31;
                };
            int courseDate = random.nextInt(1,courseDateBound);                 // between the year of students enrollment and current date
             // This is a random month selected between students year and current years month value

            LocalDate randomCourseEnrollmentDate = LocalDate.of(courseYear,courseMonth,courseDate);

            System.out.println("\n  "+c.getCourseCode()+"  "+randomCourseEnrollmentDate);


            int engagementYear = random.nextInt(courseYear,LocalDate.now().getYear()+1);
            int engagementMonth = random.nextInt(1,(courseYear<currentDate.getYear()?13:currentDate.getMonthValue()+1));
            int engagementDate = random.nextInt(1,(courseYear<currentDate.getYear()?29:currentDate.getDayOfMonth()+1));


            courseMap.putIfAbsent(c.getCourseCode(),new CourseEngagement(c,randomCourseEnrollmentDate,"Engagement",
                    random.nextInt(1,c.lectureCount+1),LocalDate.of(engagementYear,engagementMonth,engagementDate)));
        }
        this.engagementMap = new TreeMap<>(Comparator.comparing(courseMap::get));
        this.engagementMap.putAll(courseMap);
    }

    public long getStudentId()
    {
        return studentId;
    }
    public String getCountryCode()
    {
        return countryCode;
    }
    public int getYearEnrolled()
    {
        return yearEnrolled;
    }
    public int ageEnrolled()
    {
        return ageEnrolled;
    }
    public String getGender()
    {
        return gender;
    }
    public boolean getProgrammingExperience()
    {
        return programmingExperience;
    }

    public Map<String,CourseEngagement> getEngagementMap()
    {
        return engagementMap;
    }


    public int  getAge()
    {
        LocalDate currentDate = LocalDate.now();
        return (currentDate.getYear()-yearEnrolled)+ageEnrolled;
    }

    public int getYearsSinceEnrolled()
    {
        LocalDate currentDate = LocalDate.now();
        return (currentDate.getYear()-yearEnrolled);
    }

    public int getMonthsSinceActive(String courseCode)
    {
      return  engagementMap.get(courseCode).getMonthsSinceActive();
    }

    public double getPercentComplete(String courseCode)
    {
        return engagementMap.get(courseCode).getPercentComplete();
    }

    public int getMonthsSinceActive()
    {
       return new LinkedHashMap<>(engagementMap).firstEntry().getValue().getMonthsSinceActive();
    }

    public  void addCourse(Course course)
    {
        engagementMap.put(course.getCourseCode(),new CourseEngagement(course,LocalDate.now(),"Enrollment",new Random().nextInt(1,course.getLectureCount()+1),LocalDate.now()));
    }

    public void addCourse(Course course,LocalDate enrollDate)
    {
        engagementMap.put(course.getCourseCode(),new CourseEngagement(course,enrollDate,"Enrollment",new Random().nextInt(1,course.getLectureCount()+1),LocalDate.now()));
    }

    public void watchLecture(String courseCode,int lectureNumber,int month,int year)
    {
        engagementMap.get(courseCode).watchLecture(lectureNumber,LocalDate.of(year,month,new Random().nextInt(1,29)));
    }

//    public static Student getRandomStudent(Course... courses)
//    {
//        Student randomStudent = new Student(new Random().nextLong(6297609615L,62976096156L)
//                ,"INDIA",new Random().nextInt(2000,2025)
//                ,new Random().nextInt(17,25)
//                ,(new Random().nextBoolean()?"Male":"Female")
//                ,new Random().nextBoolean(),new TreeMap<>());
////        Arrays.stream(courses)
////                .forEach((c)->randomStudent.engagementMap.put(c.getCourseCode(),new CourseEngagement(c,LocalDate.of(new Random().nextInt(2020,2025),new Random().nextInt(1,12),new Random().nextInt(1,29)),"Enrollment",0
////                        ,LocalDate.now())));
//
//        for(Course c:courses)
//        {
//
//            randomStudent.addCourse(c,LocalDate.of(new Random().nextInt(2017,2025),new Random().nextInt(1,12),new Random().nextInt(1,29)));
//        }
//
//        randomStudent.engagementMap.forEach((k,v)->v.watchLecture(new Random().nextInt()))
//
//
//
//
//    }








}
