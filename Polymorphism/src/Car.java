public class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;


    public Car(int cylinder,String name)
    {
        this.cylinders=cylinder;
        this.name=name;
    }
    public String startEngine()
    {
        return  name+ " engine is starting\n";
    }
    public String accelerate()
    {
        return name +" is accelerating\n";
    }
    public String brake()
    {

        return name+" is braking\n";
    }
    public int getCylinders()
    {
      return   this.cylinders;
    }
   public String getName()
   {
       return  this.name;
   }

}
