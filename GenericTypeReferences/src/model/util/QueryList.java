package model.util;

import model.Student;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

public class QueryList<T extends Student & QueryItem> extends ArrayList<T>{

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
//    public List<T> getItems()
//    {
//        return items;
//    }
    public QueryList()
    {

    }
    public QueryList(List<T> items)
    {
        this.addAll(items);
    }
public List<T> getMatches(String fieldName,String fieldValue)
{
List<T> matches=new ArrayList<>();

for(T item:this)
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
    String s=this.get(0).getClass().getName();
    return s;
}
}
