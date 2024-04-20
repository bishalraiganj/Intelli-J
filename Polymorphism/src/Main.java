public class Main {


    public static void main(String[] args)
    {
        Car car=new Car(7,"base class car");

      methodCaller(car);
        Car carType2=new Holden(10,"Holden");
        methodCaller(carType2);
        Car carType3=new Mitsubishi(10,"Mitsubishi");
        methodCaller(carType3);
        Car carType4= new Ford(15,"ford");
        methodCaller(carType4);

    }
    public static void methodCaller( Car car)
    {
       System.out.println( car.startEngine() +car.accelerate()+car.brake());
    }
}
