public class Dog  extends Animal{
private String earShape;
private String tailShape;

public Dog()
{
    super("Mutt","Big",50);
}
public Dog(String type,double weight)
{
    this(type,weight,"Perky","Curled");
}
    public Dog(String type,  double weight, String earShape, String tailShape) {
        super(type, weight<15?"small":(weight<35?"medium":"large"), weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }


    @Override
    public String toString() {
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} "+super.toString();
    }
    public void makeNoise()
    {
if(type=="wolf")
{
    System.out.println(" Ow woooo!");

}
    }
    public void move()
    {
        super.move();
//        System.out.println(" (ANIMAL CLASS)Dog's walk,run and wag their tail");

    }
    public void move(String  speed)
    {
        super.move(speed);
//        System.out.println("Dog's walk , run and wag their tail");

    }
    private void bark()
    {
  System.out.println("Woof! ");

    }
    private void run()
    {
        System.out.println(" Dog running ");

    }
    private void walk()
    {
        System.out.println(" Dog Walking");

    }
    private void wagTail()
    {
        System.out.println("Woof !");
    }
}
