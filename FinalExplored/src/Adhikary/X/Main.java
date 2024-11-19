package Adhikary.X;

import Adhikary.X.generic.BaseClass;
import consumer.specific.ChildClass;

public class Main
{
    public static void main(String... args)
    {
        BaseClass parent = new BaseClass();
        ChildClass child = new ChildClass();
        BaseClass childReferredToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("-".repeat(50));
        childReferredToAsBase.recommendedMethod();
        System.out.println("-".repeat(50));
        child.recommendedMethod();
        System.out.println("-".repeat(50));





    }

}
