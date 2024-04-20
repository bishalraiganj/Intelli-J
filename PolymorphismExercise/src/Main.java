public class Main {

    public static void main(String[] args)
    {   String s;
        Object car= new Car("Its the base class");
        Car car1=  (Car) car;
        car1.startEngine();
        Object unknownObject=new HybridCar("its a hybrid car");
        if(unknownObject.getClass().getSimpleName()=="HybridCar" )
        {
            HybridCar car2 = (HybridCar)unknownObject;
            car2.startEngine();

        }
   if(unknownObject instanceof HybridCar uo)
   {
       uo.startEngine();
   }



     Object gasCar= new GasPoweredCar(80,10);
   if(gasCar instanceof GasPoweredCar gc)
   {
       gc.startEngine();

   }
    }

    }






