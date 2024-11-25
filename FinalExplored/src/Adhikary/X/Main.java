package Adhikary.X;

import Adhikary.X.generic.BaseClass;
import consumer.specific.ChildClass;
import external.util.Logger;

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

        parent.recommendedStatic();
        System.out.println("-".repeat(50));
        childReferredToAsBase.recommendedStatic();
        System.out.println("-".repeat(50));
        child.recommendedStatic();
        System.out.println("-".repeat(50));

        BaseClass p1 = new ChildClass();
        p1.recommendedMethod();

        String xArgument = "This is all I've got to say about this  ";
        doXYZ(xArgument,16);

        StringBuilder tracker = new StringBuilder("Step 1 is abc");
        Logger.logToConsole(tracker.toString());
        tracker.append(", Step 2 is xyz.");
        Logger.logToConsole(tracker.toString());
        System.out.println("After Logging, tracker = "+ tracker);

    }

    public static void doXYZ(String x, int y)
    {
        final String c = x + y ;
        System.out.println("c = "+c);
    }

}
