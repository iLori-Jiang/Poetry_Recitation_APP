package PoemsRecite.UserInformation;

import PoemsRecite.PoemObj.ReviewSongCi;
import PoemsRecite.PoemObj.ReviewTangSongShi;
import PoemsRecite.PoemObj.SongCi;
import PoemsRecite.PoemObj.TangSongShi;
import PoemsRecite.ProgrammeStart;

import java.util.ArrayList;

public class User {
    private String userName;     // 用户名
    private int studiedDays;     // 已学习天数
    private int studiedPoemsNumbers;    // 已学习诗词数
    private ArrayList<ReviewTangSongShi> unfinishedShiList;    // 待复习诗List
    private ArrayList<ReviewSongCi> unfinishedCiList;          // 待复习词List

    public User(){
    }

    public User(String userName){
        this.userName = userName;
        studiedDays = 0;
        studiedPoemsNumbers = 0;
        unfinishedCiList = new ArrayList<ReviewSongCi>();
        unfinishedShiList = new ArrayList<ReviewTangSongShi>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStudiedDays() {
        return studiedDays;
    }

    public void setStudiedDays(int studiedDays) {
        this.studiedDays = studiedDays;
    }

    public int getStudiedPoemsNumbers() {
        return studiedPoemsNumbers;
    }

    public void setStudiedPoemsNumbers(int studiedPoemsNumbers) {
        this.studiedPoemsNumbers = studiedPoemsNumbers;
    }

    public ArrayList<ReviewTangSongShi> getUnfinishedShiList() {
        return unfinishedShiList;
    }

    public void setUnfinishedShiList(ArrayList<ReviewTangSongShi> unfinishedShiList) {
        this.unfinishedShiList = unfinishedShiList;
    }


    public ArrayList<ReviewSongCi> getUnfinishedCiList() {
        return unfinishedCiList;
    }

    public void setUnfinishedCiList(ArrayList<ReviewSongCi> unfinishedCiList) {
        this.unfinishedCiList = unfinishedCiList;
    }


    public static boolean ifExist(int shiOrCi, int listPosition, int poemInList){
        boolean ifExist = false;

        if(shiOrCi == 0){
            for(int i = 0; i< ProgrammeStart.currentUser.unfinishedShiList.size(); i++){
                if(ProgrammeStart.currentUser.unfinishedShiList.get(i).getListPosition() == listPosition && ProgrammeStart.currentUser.unfinishedShiList.get(i).getPositionInList() == poemInList){
                    ifExist = true;
                    break;
                }
            }
        }else if(shiOrCi == 1){
            for(int i=0; i<ProgrammeStart.currentUser.unfinishedCiList.size(); i++){
                if(ProgrammeStart.currentUser.unfinishedCiList.get(i).getListPosition() == listPosition && ProgrammeStart.currentUser.unfinishedCiList.get(i).getPositionInList() == poemInList){
                    ifExist = true;
                    break;
                }
            }
        }

        return ifExist;
    }

    public static int[] findReviewPoemIndex(int shiOrCi, int listPosition, int poemInList){
        if(shiOrCi == 0){
            for(int i=0; i<ProgrammeStart.currentUser.unfinishedShiList.size(); i++){
                if(ProgrammeStart.currentUser.unfinishedShiList.get(i).getListPosition() == listPosition && ProgrammeStart.currentUser.unfinishedShiList.get(i).getPositionInList() == poemInList){
                    return new int[]{0, i};
                }
            }
        }else if(shiOrCi == 1){
            for(int i=0; i<ProgrammeStart.currentUser.unfinishedCiList.size(); i++){
                if(ProgrammeStart.currentUser.unfinishedCiList.get(i).getListPosition() == listPosition && ProgrammeStart.currentUser.unfinishedCiList.get(i).getPositionInList() == poemInList){
                    return new int[]{1, i};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void studiedShiTimesSorting(){
        for(int i=0; i<ProgrammeStart.currentUser.unfinishedShiList.size(); i++){
            ReviewTangSongShi tangSongShi;
            for(int j=i+1; j<ProgrammeStart.currentUser.unfinishedShiList.size(); j++){
                if(ProgrammeStart.currentUser.unfinishedShiList.get(i).studiedDays.size() > ProgrammeStart.currentUser.unfinishedShiList.get(j).studiedDays.size()){
                    tangSongShi = ProgrammeStart.currentUser.unfinishedShiList.get(j);
                    ProgrammeStart.currentUser.unfinishedShiList.set(j, ProgrammeStart.currentUser.unfinishedShiList.get(i));
                    ProgrammeStart.currentUser.unfinishedShiList.set(i, tangSongShi);
                }
            }
        }
    }

    public static void studiedShiGradeSorting(){
        for(int i=0; i<ProgrammeStart.currentUser.unfinishedShiList.size(); i++){
            ReviewTangSongShi tangSongShi;
            for(int j=i+1; j<ProgrammeStart.currentUser.unfinishedShiList.size(); j++){
                if(ProgrammeStart.currentUser.unfinishedShiList.get(i).grading.get(ProgrammeStart.currentUser.unfinishedShiList.get(i).grading.size()-1) > ProgrammeStart.currentUser.unfinishedShiList.get(j).grading.get(ProgrammeStart.currentUser.unfinishedShiList.get(j).grading.size()-1)){
                    tangSongShi = ProgrammeStart.currentUser.unfinishedShiList.get(j);
                    ProgrammeStart.currentUser.unfinishedShiList.set(j, ProgrammeStart.currentUser.unfinishedShiList.get(i));
                    ProgrammeStart.currentUser.unfinishedShiList.set(i, tangSongShi);
                }
            }
        }
    }

    public static void studiedCiGradeSorting(){
        for(int i=0; i<ProgrammeStart.currentUser.unfinishedCiList.size(); i++){
            ReviewSongCi songCi;
            for(int j=i+1; j<ProgrammeStart.currentUser.unfinishedCiList.size(); j++){
                if(ProgrammeStart.currentUser.unfinishedCiList.get(i).grading.get(ProgrammeStart.currentUser.unfinishedCiList.get(i).grading.size()-1) > ProgrammeStart.currentUser.unfinishedCiList.get(j).grading.get(ProgrammeStart.currentUser.unfinishedCiList.get(j).grading.size()-1)){
                    songCi = ProgrammeStart.currentUser.unfinishedCiList.get(j);
                    ProgrammeStart.currentUser.unfinishedCiList.set(j, ProgrammeStart.currentUser.unfinishedCiList.get(i));
                    ProgrammeStart.currentUser.unfinishedCiList.set(i, songCi);
                }
            }
        }
    }
}
