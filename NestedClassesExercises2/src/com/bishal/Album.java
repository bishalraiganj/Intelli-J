package com.bishal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
        private String name;
        private String artist;

      private SongList songs ;



    public Album(String name,String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }


    public boolean addSong(String title, double duration) {

        if (songs.findSong(title) == null)
        {
            songs.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }


    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {

        int index = trackNumber - 1;
        if (songs.findSong(trackNumber)!=null) {
            playList.add(songs.findSong(trackNumber));
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

    public  static class SongList {

        private  ArrayList<Song> songs = new ArrayList<>();
        private SongList()
        {


        }
        private boolean add(Song song)
        {
            if(songs.contains(song))
            {

                return false;

            }
            return songs.add(song);


        }

        private Song findSong(String songTitle)
        {

            for(Song s:songs)
            {
                if(s.getTitle().equalsIgnoreCase(songTitle))
                {
                    return s;
                }
            }
            return null;

        }
        private Song findSong(int trackNum)
        {
            for(Song s: songs)
            {
                if(songs.indexOf(s) == trackNum-1)
                {
                    return s;
                }
            }
            return null;
        }
    }
}
