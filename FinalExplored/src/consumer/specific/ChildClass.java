package consumer.specific;

import Adhikary.X.generic.BaseClass;

public class ChildClass extends BaseClass {

    public static void recommendedStatic()
    {
        System.out.println("[Child.recommended]: My own important stuff");
    }

    @Override
    public void optionalMethod()
    {
        System.out.println("[Child:optionalMethod]: EXTRA Stuff Here");
        super.optionalMethod();
    }
//
//    @Override
//    public void recommendedMethod()
//    {
//        System.out.println("[Child:recommendedMethod]: I'll do things my way ");
//        optionalMethod();
//    }


    private static void mandatoryMethod()
    {

        System.out.println("[Child:mandatoryMethod]: NON-NEGOTIABLE");
    }


}
