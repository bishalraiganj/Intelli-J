import java.util.ArrayList;
import java.util.List;




public class SportsTeam {
    private String teamName;
    public SportsTeam(String teamName)
    {
        this.teamName=teamName;
    }
    private List<Player> teamMembers = new ArrayList<>();
    private int totalWins=0;
    private int totalLosses=0;
    private int totalTies=0;
    public void addTeamMember(Player player)
    {
        if(!teamMembers.contains(player))
        {
            teamMembers.add(player);
        }
    }
    public void listTeamMembers()
    {
        System.out.println(teamName +"Roster:");
        System.out.println(teamMembers);
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
