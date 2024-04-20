public class HourlyEmployee extends Employee{
    private double hourlyPayRate;
    public HourlyEmployee()
    {
        super();
    }
    public HourlyEmployee(String name,String birthDate,String hireDate,double hourlyPayRate)
    {
        super(name,birthDate,hireDate);
        this.hourlyPayRate=hourlyPayRate;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "hourlyPayRate=" + hourlyPayRate +
                "} " + super.toString();
    }
}
