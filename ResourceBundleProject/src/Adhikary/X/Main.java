package Adhikary.X;

import javax.swing.*;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String... args)
    {
//        ResourceBundle rb = ResourceBundle.getBundle("BasicText");
//        System.out.println(rb.getClass().getName());
//        System.out.println(rb.getBaseBundleName());
//        System.out.println(rb.keySet());
//
//        System.out.printf("%s %s!%n",rb.getString("hello"),rb.getString("world"));
//
//        System.out.println("-".repeat(50));
//
        for(Locale l : List.of(Locale.US,Locale.CANADA_FRENCH,Locale.CANADA))
        {
            ResourceBundle rb = ResourceBundle.getBundle("BasicText",l);
            String message = "%s %s!%n".formatted(rb.getString("hello"),rb.getString("world"));


            ResourceBundle ui = ResourceBundle.getBundle("UIComponents",l);

            JOptionPane.showOptionDialog(null,message,ui.getString("first.title"),JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,
                    null
                    ,new Object[] {rb.getString("yes"),rb.getString("no")}
                    ,null);
        }
        





    }


}
