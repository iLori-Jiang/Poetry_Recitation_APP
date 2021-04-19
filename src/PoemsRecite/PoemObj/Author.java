package PoemsRecite.PoemObj;

import java.util.ArrayList;

public class Author {
    public String name;
    public ArrayList<SongCi> songCiArrayList;
    public ArrayList<TangSongShi> tangSongShiArrayList;

    public Author(String name){
        this.name = name;
        songCiArrayList = new ArrayList<SongCi>();
        tangSongShiArrayList = new ArrayList<TangSongShi>();
    }
}
