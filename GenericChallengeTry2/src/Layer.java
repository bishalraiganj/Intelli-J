import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Layer<T extends Mappable> {

    private List<T> mappingElements=new ArrayList<>();
    public Layer(T... mappables)
    {
        mappingElements.addAll(  List.of(mappables));

    }
    public void addMappable(T mappable)
    {
        mappingElements.add(mappable);

    }
   public void printMappables()
   {
       System.out.println(mappingElements);
   }

   public void renderLayer()
   {
       for(T t:mappingElements)
       {
           t.render();
       }
   }
}
