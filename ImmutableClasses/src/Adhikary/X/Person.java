package Adhikary.X;

import java.util.Arrays;

public class Person {

    private String name;
    private String dob;
    private Person[] kids;

    public String getName()
    {
        return name;
    }
    public String getDob()
    {
        return dob;
    }
    public Person[] getKids()
    {
        return kids;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setDob(String dob)
    {
        this.dob= dob;
    }
    public void setKids(Person[] kids)
    {
        this.kids = kids;
    }

    @Override
    public String toString()
    {
        String kidString =  "n/a";
        if(kids != null)
        {
            String[] names = new String[kids.length];
            Arrays.setAll(names,i-> names[i] = kids[i] == null ? "" : kids[i].name);
        }
        return name + ", dob = " + dob + ", kids = "  + kidString;

    }


}
