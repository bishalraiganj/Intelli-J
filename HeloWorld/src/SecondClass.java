public class SecondClass {

public static void main(String []args)

{
    double value = 20d;
    double value2 = 80d;
    boolean isTof = ((((value + value2)*100)%40 ) ==0d) ? true : false;
    System.out.println(isTof);
    if (isTof==false)
        System.out.println("Got some remainder");



}
}
