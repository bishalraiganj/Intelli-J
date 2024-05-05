import java.util.ArrayList;
import java.util.List;

public class Layer <T extends Mappable> {
    private List<T> maps=new ArrayList<>();
    public Layer()
    {

    }
    public Layer(List<T> m)
    {
        this.maps=m;
    }
    public void addElements(T t)
    {
        this.maps.add(t);
    }
    public void renderLayer()
    {
for(T t:maps)
{
    t.render();
}

    }

}
