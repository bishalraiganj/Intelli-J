package com.bishal.company;


public class Song {
    private String title;
    private double duration;
    public Song(String songTitle,double duration)
    {
        this.title=songTitle;
        this.duration=duration;
    }
    public Song(String songTitle)
    {
        this.title = songTitle;


    }
    public String getTitle()
    {


        return title;
    }

    @Override
    public String toString() {
        return title+": "+duration;
    }
}