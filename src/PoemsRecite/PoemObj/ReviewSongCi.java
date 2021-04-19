package PoemsRecite.PoemObj;

import java.util.ArrayList;

public class ReviewSongCi extends SongCi {
    public ArrayList<Integer> studiedDays;
    public ArrayList<Integer> grading;

    public ReviewSongCi(SongCi songCi){
        super.shiOrCi = songCi.shiOrCi;
        super.setRhythmic(songCi.getRhythmic());
        super.setAuthor(songCi.getAuthor());
        super.setParagraphs(songCi.getParagraphs());
        super.setTags(songCi.getTags());
        super.setListPosition(songCi.getListPosition());
        super.setPositionInList(songCi.getPositionInList());
        studiedDays = new ArrayList<Integer>();
        grading = new ArrayList<Integer>();
    }
}
