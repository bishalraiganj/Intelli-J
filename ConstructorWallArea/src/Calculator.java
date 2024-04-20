public class Calculator {

    private Floor f;
    private Carpet c;
    public Calculator(Floor f,Carpet c)
    {
        setF(f);
        setC(c);

    }
    public void setF(Floor f)
    {
        this.f=f;
    }
    public void setC(Carpet c)
    {
        this.c=c;

    }
    public double getTotalCost()
    {

        return f.getArea()*c.getCost();
    }
}
