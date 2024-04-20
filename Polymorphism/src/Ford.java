public class Ford extends Car {
    public Ford(int cylinders,String name)
    {
        super(cylinders,name);
    }

    @Override
    public String startEngine()
    {
        System.out.println(super.startEngine());
        return this.getClass().getSimpleName();
    }
    @Override
    public String accelerate()
    {
        System.out.println(super.accelerate());

        return this.getClass().getSimpleName();
    }
    @Override
    public String brake()
    {
        System.out.println(super.brake());

        return this.getClass().getSimpleName();
    }



}