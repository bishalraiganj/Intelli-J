package Adhikary.X;

public final class  Course {
    private final String courseCode;
    private final String title;
    private final int lectureCount;

    public Course(String courseCode,String title,int lectureCount)
    {
        this.courseCode = courseCode;
        this.title = title;
        this.lectureCount = lectureCount;
    }

    public String getCourseCode()
    {
        return courseCode;
    }

    public String  getTitle()
    {
        return title;
    }

    public int getLectureCount()
    {
        return lectureCount;
    }

    @Override
    public String toString()
    {
        return "Course Code =%s Title = %s Lecture Count = %s".formatted(courseCode,title,lectureCount);
    }


}
