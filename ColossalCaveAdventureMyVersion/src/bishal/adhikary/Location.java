package bishal.adhikary;

import java.util.Map;

public  class Location {


    private String description;
    private Map<Character,String> nextPlace;
    public Location(String description,Map<Character,String> nextPlace)
    {
        this.description = description;
        this.nextPlace = nextPlace;
    }
    public String getDescription()
    {
        return description;
    }
    public Map<Character,String> getNextPlace()
    {
        return nextPlace;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public void setNextPlace(Map<Character,String> nextPlace)
    {
        this.nextPlace = nextPlace;
    }

    @Override
    public String toString()
    {
        return " \n Locations Description : %s  ".formatted(description)+"\n NearBy Places :"+nextPlace+"\n"+"-".repeat(50)+"\n";
    }



}
