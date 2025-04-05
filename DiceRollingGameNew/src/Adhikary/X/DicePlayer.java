package Adhikary.X;

public class DicePlayer implements Player{

    private static int id=0;
    private final int instanceId= ++id ;
    private  final String name;


    public DicePlayer(String name)
    {
        this.name=name;
    }

    @Override
    public String name()
    {
        return name;
    }
    @Override
    public int instanceId()
    {
        return instanceId;
    }

    @Override
    public String toString()
    {
        return "Name = %s  UniqueID = %d ".formatted(name,instanceId);
    }





}
