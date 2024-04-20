public class Car {


    private String description;

    public Car()
    {
        this.description=" Default Contructor is used";

    }
    public Car(String description)
    {
        this.description=description;

    }
    public String getDescription()
    {
        return description;

    }

    public void setDescription(String description)
    {

        this.description=description;
    }


    public void startEngine()
    {
        System.out.println(" Car description  :"+description);
        System.out.println("Runtime Instance Name : "+this.getClass().getSimpleName());
    }



}
class HybridCar extends Car {
    private double avgKmPerLitre;
    private int cylinders;

    public HybridCar(String description) {
        super(description);
        this.avgKmPerLitre = 90;
        this.cylinders = 4;
    }
    public HybridCar(Double avgKmPerLire,int cylinders)
    {
        this.avgKmPerLitre=avgKmPerLitre;
        this.cylinders=cylinders;
    }

    @Override
    public void startEngine()
    {
        super.startEngine();
    }

    public void extraMileageMode()
    {
        System.out.printf(""" 
                 Hybrid MODE IS ON 
                 Total MIleage is :110kms  """);
         System.out.println(this.getClass().getSimpleName());

    }
}
 class ElectricCar extends Car{

    private double avgKmPerCharge;
    private int batterySize;
    public ElectricCar()
    {   super();
        this.avgKmPerCharge=300;
        batterySize=40;
    }

    public ElectricCar(double avgKmPerCharge,int batterySize)
    {
        this.avgKmPerCharge=avgKmPerCharge;
        this.batterySize=batterySize;
    }
}
class GasPoweredCar extends Car
{
    private double avgKmPerLitre;
    private int cylinders;
    public GasPoweredCar()
    {   super("it's a Gas powered Car");
        this.avgKmPerLitre=70;
        this.cylinders=9;

    }
    public GasPoweredCar( double avgKmPerLitre,int cylinders)
    {     super("its a gas powered car");
        this.avgKmPerLitre=avgKmPerLitre;
        this.cylinders=cylinders;
    }

    @Override
    public void startEngine() {
        super.startEngine();

        System.out.println(this.getClass().getSimpleName());
    }
}
