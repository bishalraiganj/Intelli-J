import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp {
    public static void main(String[] args)
    {
        String[] stringArray=new String[]{"apples","balls","clothes"};
        List<String> list=List.of(stringArray);
        System.out.println(list);
       GroceryItems[] gInstances=new GroceryItems[] {

               new GroceryItems("football",3),new GroceryItems(("phone"),4)
       };

        System.out.println("Grocery Array :"+ Arrays.toString(gInstances));

        List<GroceryItems> gList=List.of(gInstances);

        List<GroceryItems>  list2=Arrays.asList(gInstances);
        System.out.println("Arrays.asList :"+list2);


//        System.out.println(gList);
//        ArrayList<GroceryItems> aList=new ArrayList<> (gList);
//        aList.add(new GroceryItems("tablets",4));
//        System.out.println(aList);
//        ArrayList<GroceryItems> gList2=new ArrayList<>(List.of( new GroceryItems("football",3),new GroceryItems(("phone"),4)));
//        gList2.addAll(aList);
//        System.out.println(gList2);

    }
}
 record GroceryItems(String type,int Count)
 {


 }