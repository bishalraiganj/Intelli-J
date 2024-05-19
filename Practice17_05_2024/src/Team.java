import java.util.ArrayList;
import java.util.List;





public class Team<T extends Player,S extends Affiliation > {
    private String teamName;
    public Team(String teamName)
    {
        this.teamName=teamName;
    }
    private List<T> teamMembers = new ArrayList<>();
    private int totalWins=0;
    private int totalLosses=0;
    private int totalTies=0;
    private S affiliation;
    public void addTeamMember(T t)
    {
        if(!teamMembers.contains(t))
        {
            teamMembers.add(t);
        }
    }
    public Team(String name,S affiliation)
    {
        this.teamName=name;
        this.affiliation=affiliation;
    }
    public void listTeamMembers()
    {
        System.out.println(teamName +" Roster:");
        System.out.println(affiliation==null?"":"Affiliation"+affiliation);
        for(T t:teamMembers)
        {
            System.out.println(t.name());
        }
    }
    public int ranking()  //ranking algorithm for giving teams points which can be used to actually rank teams based ont the
            //output from this method
    {

        return (totalLosses*2)+totalWins+1;
    }
    public String setScore(int ourScore,int theirScore)
    {
        String message="Lost to";
        if(ourScore>theirScore)
        {
            totalWins++;
            message="beat";
        }
        else if (  ourScore==theirScore )
        {
            totalTies++;
            message="tied";
        }
        else
                    {
            totalLosses++;
                    }
return message;
    }

    @Override
    public String toString()
    {
        return teamName+"(ranked"+ranking()+")";
    }
}
