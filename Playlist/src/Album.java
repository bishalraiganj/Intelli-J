import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    ArrayList<Song> songs;
    public String getName()
    {

        return name;

    }
public Album(String name,String artist,ArrayList<Song> aList)
{
    this.name=name;
    this.artist=artist;
    songs=new ArrayList<> (aList);
   System.out.println(songs);
}
public  boolean addSong(String title,double duration)
{   if(findSong(title)==null) {
    songs.add(new Song(title, duration));
    System.out.printf("Adding song %s to Album %s :\n",title,getName()+songs);
return true;
}
System.out.println("Duplicate found :"+findSong(title)+"\n\n"+songs);
return false;
}
public  Song findSong(String title)
{
    for(Song i:songs)
    {
        if(i.getTitle()==title)
        {
            return i;
        }
    }
    return null;
}
public  boolean addToPlayList(int trackCount, LinkedList<Song> lList)
{
if(songs.size()-trackCount>=0)
{

    lList.add(songs.get(trackCount-1));
    return true;
}

return false;

}
public boolean addToPlayList(String title,LinkedList<Song> lList)
{
if(findSong(title)!=null)
{
    lList.add(findSong(title));
    return true;
}

    return false;
}
}

class Song {
    private String title;
    private double duration;
    public Song(String songTitle,double duration)
    {
        this.title=songTitle;
        this.duration=duration;
    }
public String getTitle()
{


    return title;
}

    @Override
    public String toString() {
        return "title: "+title+":"+" duration: "+duration;
    }
}
