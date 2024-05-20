package model.util;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class QueryList<T extends Student & QueryItem> {
    private List<T> items;
    public static <T extends QueryItem> List<T> getMatches(List<T> list,String fieldName,String fieldValue)
    {
        List<T> matches = new ArrayList<>();
        for(T item:list)
        {
            if(item.matchFieldValue(fieldName,fieldValue))
            {
                matches.add(item);
            }

        }
        return matches;
    }
    public List<T> getItems()
    {
        return items;
    }
    public QueryList(List<T> items)
    {
        this.items=items;
    }
public List<T> getMatches(String fieldName,String fieldValue)
{
List<T> matches=new ArrayList<>();

for(T item:items)
{
    if(item.matchFieldValue(fieldName,fieldValue))
    {
        matches.add(item);
    }

}
if(matches.isEmpty())
{
    System.out.println("No Matches Found");
}
return matches;
}
public String returnQueryListType()
{
    String s=items.get(0).getClass().getName();
    return s;
}
}
