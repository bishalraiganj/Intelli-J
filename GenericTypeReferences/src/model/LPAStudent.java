package model;

import model.util.QueryItem;

public class LPAStudent extends Student {

    protected String thisClassName = "LPAStudent";
    private double percentComplete;

    public LPAStudent() {
        percentComplete = random.nextDouble(0, 100);
    }


    @Override
    public String toString() {
        return "%s %8.1f%%\n".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String fieldValue) {
        String fName = fieldName.toUpperCase();
        return switch (fName) {
            case "STUDENTID" -> super.getName().equals(fieldValue);
            case "PERCENTCOMPLETE" -> percentComplete <= Double.parseDouble(fieldValue);
            case "NAME" -> super.getName().equals(fieldValue);
            case "COURSE" -> super.getCourse().equals(fieldValue);
            case "YEARSTARTED" -> super.getYearStarted() == Integer.parseInt(fieldValue);
            default -> false;
        };
    }


//    public boolean matchFieldValue(String fieldName,String fieldValue)
//    {
//        if ()
//
//    }
}
