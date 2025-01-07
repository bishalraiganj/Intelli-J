package Adhikary.X;

public class Child extends Parent{
    public Child(Parent p)
    {
        super(p);
    }

    @Override
    public String toString()
    {
        return " Child a =" +super.getA()+" b ="+super.getB();
    }
}
