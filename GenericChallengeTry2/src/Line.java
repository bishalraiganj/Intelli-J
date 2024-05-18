import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line implements Mappable{


    private String LineName;
    private String LineType;
    private String LineMarker;
    private Double[][] coordinatesArray;
    public Line(String LineName,String LineType,String LineMarker,String... coordinates)
    {
        this.LineName=LineName;
        this.LineType=LineType;
        this.LineMarker=LineMarker;
        coordinatesArray=new Double[coordinates.length][];
        int index=0;
       for(String s:coordinates)
       {
        coordinatesArray[index++]=Mappable.stringToLatlon(s);
       }


    }
//    @Override
//    public String toString()
//    {
//      return  "";
//
//    }


    @Override
    public String toString() {
        return "Line{" +
                "LineName='" + LineName + '\'' +
                ", LineType='" + LineType + '\'' +
                ", LineMarker='" + LineMarker + '\'' +
                ", coordinatesArrayList=" + Arrays.deepToString(coordinatesArray) +
                '}';
    }

    public String render()
    {

      return   toString();
    }
    
}
