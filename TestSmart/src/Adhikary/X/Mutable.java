package Adhikary.X;

public class Mutable {
    private String id;
    public Mutable(String id)
    {
        this.id = id;
    }
    public String getId()
    {
        return id;
    }
    public void setA(String a)
    {
        this.id =a;
    }
    @Override
    public String toString()
    {
        return id;
    }
}
