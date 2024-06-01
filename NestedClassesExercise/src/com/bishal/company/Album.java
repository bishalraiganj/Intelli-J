package com.bishal.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    public Album(String name, String artist)
    {
        this.name = name;
        this.artist = artist;
    }

    SongList songs = new SongList();
   class SongList extends ArrayList<Song> {

       public  boolean add(Song title) {

            if (findSong(title.getTitle()) == null)
            {
                songs.add(title);
                return true;
            }
            return false;
        }


        Song findSong(String title) {

            for (Song checkedSong : songs) {
                if (checkedSong.getTitle().equalsIgnoreCase(title)) {
                    return checkedSong;
                }
            }
            return null;
        }

         Song findSong(int trackCount) {

            for (Song checkedSong : songs) {
                if (songs.indexOf(checkedSong) + 1 == trackCount) {
                    return checkedSong;
                }
            }
            return null;
//
        }

    }


public boolean addSong(String title, double duration) {
//
    if (songs.findSong(title) == null) {
        songs.add(new Song(title, duration));
        return true;
    }
    return false;
}

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {

        int index = trackNumber - 1;
        if ((index >= 0) && (index <= songs.size())) {
            playList.add(songs.get(index));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {

        Song checkedSong = songs.findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        return false;
    }
}
