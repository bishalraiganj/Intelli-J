import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
  ArrayList<Song> bSongs=new ArrayList<>();

  bSongs.addAll(Arrays.asList(new Song("b1",1.0),new Song("b2",2.0),new Song("b3",3.0)));

        System.out.println(bSongs);
      Album album=new Album("Bishal","Bishal",bSongs);

album.addSong("b5",4.6);
Album b1=new Album("Suparna","Suparna",bSongs);
b1.addSong("s",5.0);
System.out.println("album"+album.songs);
        LinkedList<Song> l1=new LinkedList<>();
        b1.addToPlayList(2,l1);
        b1.addToPlayList("s",l1);

        System.out.println(l1);
    }



}
