package bishal.adhikary;

import java.util.Map;

public  class Location {


    private String description;
    private Map<String,String> nextPlace;
    public Location(String description,Map<String,String> nextPlace)
    {
        this.description = description;
        this.nextPlace = nextPlace;
    }
    public String getDescription()
    {
        return description;
    }
    public Map<String,String> getNextPlace()
    {
        return nextPlace;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public void setNextPlace(Map<String,String> nextPlace)
    {
        this.nextPlace = nextPlace;
    }



}
