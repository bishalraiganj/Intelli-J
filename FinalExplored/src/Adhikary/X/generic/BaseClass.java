package Adhikary.X.generic;

public class BaseClass {

    public final void recommendedMethod() {
        System.out.println("[BaseClass.recommendedMethod]: Best Way to do it");
        optionalMethod();
        mandatoryMethod();
    }

    public static void recommendedStatic()
    {
        System.out.println("[BaseClass.recommendedStatic] : BEST Way to do it");
        optionalStatic();
        mandatoryStatic();
    }

    protected static void optionalStatic()
    {
        System.out.println("[BaseClass.optionalStatic] : Optional");
    }
    protected static void mandatoryStatic()
    {
        System.out.println("[BaseClass.mandatoryStatic] : Mandatory");

    }
    protected void optionalMethod() {
        System.out.println("[BaseClass.optionalMethod]: Customize Optional Method");
    }

    private void mandatoryMethod()
    {
        System.out.println("[BaseClass.mandatoryMethod]: NON-NEGOTIABLE");
    }



}
