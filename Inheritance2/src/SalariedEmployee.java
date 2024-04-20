public class SalariedEmployee extends Employee {


    private double annualSalary;
    private boolean isRetired;
    public SalariedEmployee(String name,String birthDate,String hireDate,double annualSalary)
    {
        super(name,birthDate,hireDate);
        this.annualSalary=annualSalary;
    }


}
