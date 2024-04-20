public class Bedroom {

    private String name;
    private Wall wall1=new Wall("Right"),wall2=new Wall("North"),wall3= new Wall("South")
            ,wall4=new Wall("Left");
    private Ceiling ceiling =new Ceiling(2,22);
    private Bed bed=new Bed("Soft",4,5,5,5);
    private Lamp lamp=new Lamp("Indian Lamp",true,5);
    public Bedroom(String name,Wall wall1,Wall wall2,Wall wall3,Wall wall4,Ceiling ceiling,Bed bed,Lamp lamp)
    {
        this.name=name;
        this.wall1=wall1;
        this.wall2=wall2;
        this.wall3=wall3;
        this.wall4=wall4;
        this.ceiling=ceiling;
        this.bed=bed;
        this.lamp=lamp;
    }
    public Lamp getLamp()
    {
        return lamp;
    }
public void makeBed()
{
    System.out.println("That the bed is being made");
    bed.make();

}


}
