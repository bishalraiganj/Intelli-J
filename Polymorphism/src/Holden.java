public class Holden  extends Car{

    public Holden(int cylinders,String name )
    {
        super(cylinders,name);
    }

    @Override
    public String startEngine()
    {
        System.out.println(  super.startEngine());
        return "\n Current runtime instance is :"+this.getClass().getSimpleName();
    }
    @Override
    public String accelerate()
    {
        System.out.println(super.accelerate());

        return "\tCurrent runtime instance is :"+ this.getClass().getSimpleName();
    }
    @Override
    public String brake()
    {
        System.out.println(super.brake());

        return " \tCurrent runtime instance is :"+this.getClass().getSimpleName();
    }
}
