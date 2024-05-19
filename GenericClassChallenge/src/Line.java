import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line implements Mappable {
    private String name;
    List<List<String>> riverCoordinates=new ArrayList<>( );
    List<List<Double>> dRiverCoordinates=new ArrayList<>();
    private String multipleCoordinates;

    public Line(String name,String multipleCoordinates)
    {   this.multipleCoordinates=multipleCoordinates;
        this.name=name;
    }

    public void stringCoordinates()
    {
        String[] cArray=multipleCoordinates.split("/");
        int i=0;
        for(String c:cArray)
        {
            riverCoordinates.add( i,List.of(c.split(",")));
            i++;
        }
        for(List<String> c:riverCoordinates)
        { for(List<Double> d:dRiverCoordinates) {
            d.add(0, Double.parseDouble(c.get(0)));
            d.add(1,Double.parseDouble(c.get(1)));
        }
        }
    }
    public void render()
    { stringCoordinates();

        System.out.printf("""
                Render %s River as LINE %s
                
                """,name,riverCoordinates);
//        System.out.print(riverCoordinates);
    }

    }

