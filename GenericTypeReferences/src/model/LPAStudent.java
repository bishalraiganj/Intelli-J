package model;

import model.util.QueryItem;

public class LPAStudent extends Student {

    protected String thisClassName="LPAStudent";
    private double percentComplete;
    public LPAStudent()
    {
        percentComplete = random.nextDouble(0,100);
    }
    @Override
    public String toString()
    {
        return "%s %8.1f%%".formatted(super.toString(),percentComplete);
    }
    public double getPercentComplete()
    {
        return percentComplete;
    }

//    public boolean matchFieldValue(String fieldName,String fieldValue)
//    {
//        if ()
//
//    }
}
