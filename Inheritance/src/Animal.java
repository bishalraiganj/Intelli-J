public class Animal {
    protected String type;
    private String size;
    private double weight;
    public Animal()
    {

    }
    public Animal(String type,String size,double weight)

    { this.size=size;
        this.type=type;
        this.weight=weight;

    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }
    public void move(String speed)
    {
        System.out.println(type+" moves "+speed);

    }
    public void move()
    {
        System.out.println(" Move from superclass animal");
    }


    public void makeNoise()
    {
        System.out.println(type+" makes some kind of noise");
    }

}



