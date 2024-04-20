public class MainForPoint {
    public static void main(String[] args)
    {

        Point point = new Point();
        Point point2=new Point(1,1);
        point2.setX(6);
        point2.setY(5);
        System.out.println("when Distance(0,0)"+point.distance());
        System.out.println("When distance(x,y) is called :"+point2.distance(2,2));


    }
}
