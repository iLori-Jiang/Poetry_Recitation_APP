package PoemsRecite.PoemObj;

import java.util.ArrayList;

public class ReviewTangSongShi extends TangSongShi {    // 继承唐宋诗
    public ArrayList<Integer> studiedDays;      // 学习日期
    public ArrayList<Integer> grading;          // 学习得分

    public ReviewTangSongShi(TangSongShi tangSongShi){
        super.shiOrCi = tangSongShi.shiOrCi;
        super.setTitle(tangSongShi.getTitle());
        super.setAuthor(tangSongShi.getAuthor());
        super.setParagraphs(tangSongShi.getParagraphs());
        super.setTags(tangSongShi.getTags());
        super.setId(tangSongShi.getId());
        super.setListPosition(tangSongShi.getListPosition());
        super.setPositionInList(tangSongShi.getPositionInList());
        studiedDays = new ArrayList<Integer>();
        grading = new ArrayList<Integer>();
    }
}
