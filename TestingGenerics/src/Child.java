public class Child implements Parent{
    public Child()
    {
        super();
    }
    public String parentMethod()
    {
        return this.getClass().getName();
    }
}
