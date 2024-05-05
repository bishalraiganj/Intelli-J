
import java.util.*;

public class Point implements Mappable {
    private String name;

    private double latitude;
    private double longitude;
    double[] parkCoordinates;
    public Point(String name,double latitude,double longitude)
    {
this.name=name;
        this.latitude=latitude;
        this.longitude=longitude;
        parkCoordinates=new double[]{latitude,longitude};
    }

    public void render()
    {
        System.out.printf("""
                Render %s as POINT %s
                
                """,name,Arrays.toString(parkCoordinates));
    }
}
