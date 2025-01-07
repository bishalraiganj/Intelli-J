package Adhikary.X;

public class Parent {
    
    private final Mutable a ;
    private final Mutable b;
    
    public Parent(Mutable a,Mutable b)
    {
        this.a = a;
        this.b = b;
    }
    
    public Parent(Parent parent)
    {
        this.a =new Mutable(parent.a.getId());
        this.b= new Mutable(parent.b.getId());
    }
    
    public Mutable getA()
    {
        return a;
    }
    public Mutable getB()
    {
        return b;
    }
    @Override
    public String toString()
    {
        return " Parent a = "+a+" b = "+b;
    }
    
}
