package Adhikary.X;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args)
    {
        Parent parent = new Parent(new Mutable("1"),new Mutable("2"));
        Child child = new Child(parent);

        if(child.getA() == parent.getA())
        {
            System.out.println("True");
        }

        child.getA().setA("84");
        System.out.println(child);
        System.out.println(parent);
    }

}
