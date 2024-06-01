public class User {


    String s1 = new Inheritor().getField();



   private class Inheritor extends Inherited{
   private String getField()
    {

        return super.inheritedField;
    }




   }

    public class Inherited {
//

       private  String inheritedField = "inherited";
    }


}
