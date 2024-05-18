import java.util.ArrayList;
import java.util.*;

public class Point  implements Mappable {


    private String pointName;
    private String pointType;
    private String pointMarker;
    private String coordinates;
    private Double[] coordinatesArray;
    public Point(String pointName, String pointType, String pointMarker, String coordinates) {
        this.pointName = pointName;
        this.pointType = pointType;
        this.pointMarker = pointMarker;
        coordinatesArray=Mappable.stringToLatlon(coordinates);



    }


    @Override
    public String toString() {
        return "Label{" +
                "pointName='" + pointName + '\'' +
                ", pointType='" + pointType + '\'' +
                ", pointMarker='" + pointMarker + '\'' +
                ", coordinates='"  + Arrays.toString(coordinatesArray)+'\'' +
                '}';
    }


    public String render()
    {

        return   toString();
    }
}