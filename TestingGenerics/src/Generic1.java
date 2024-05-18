import java.util.ArrayList;
import java.util.List;

public class  Generic1 <T extends Parent> {

    private T s;
    public Generic1()
    {

    }
    public  T getS()
    {
        return s;
    }
public Generic1(T s)
{
    this.s=s;
}
public <T > T instanceFind(T Child){
        return Child;

}


}
