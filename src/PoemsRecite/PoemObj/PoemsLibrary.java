package PoemsRecite.PoemObj;

import PoemsRecite.ProgrammeStart;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PoemsLibrary {
    public static ArrayList<TangSongShiList> tangSongShiListCollection;  //
    public static ArrayList<SongCiList> songCiListCollection;            //

    public PoemsLibrary(){
        tangSongShiListCollection = new ArrayList<TangSongShiList>();
        songCiListCollection = new ArrayList<SongCiList>();
    }

    public static void loadLibrary() {
        // 读取宋词
        for(int i=0; i<22; i++){
            int index = i * 1000;
            String ind = Integer.toString(index);
            String fileName = "/Users/iloris/NutstoreCloudBridge/SUSTC/作业/DSAA/Project/DSAAProject/PoemJson/ci.song.";
            fileName += ind;
            fileName += ".json";
            // System.out.println(fileName);

            SongCiList songCiList = SongCiJson2Obj(fileName);
            songCiListCollection.add(songCiList);
        }

        SongCiList tempSongCiList = SongCiJson2Obj("/Users/iloris/NutstoreCloudBridge/SUSTC/作业/DSAA/Project/DSAAProject/PoemJson/ci.song.2019y.json");
        songCiListCollection.add(tempSongCiList);

        // 添加位置与作者
        for(int i=0; i<songCiListCollection.size(); i++){
            for(int j=0; j<songCiListCollection.get(i).getSongCi().size(); j++){
                songCiListCollection.get(i).getSongCi().get(j).setListPosition(i);
                songCiListCollection.get(i).getSongCi().get(j).setPositionInList(j);

                boolean ifUserExist = false;
                for(int k=0; k< ProgrammeStart.authorLibrary.size(); k++){
                    if(songCiListCollection.get(i).getSongCi().get(j).getAuthor().equals(ProgrammeStart.authorLibrary.get(k).name)){
                        ProgrammeStart.authorLibrary.get(k).songCiArrayList.add(songCiListCollection.get(i).getSongCi().get(j));
                        ifUserExist = true;
                        break;
                    }
                }
                if(!ifUserExist){
                    Author author = new Author(songCiListCollection.get(i).getSongCi().get(j).getAuthor());
                    ProgrammeStart.authorLibrary.add(author);
                    ProgrammeStart.authorLibrary.get(ProgrammeStart.authorLibrary.size()-1).songCiArrayList.add(songCiListCollection.get(i).getSongCi().get(j));
                }
            }
        }

        /*// 测试宋词Collection
        for(int i=0; i<songCiListCollection.size(); i++){
            for(SongCi songCi : songCiListCollection.get(i).getSongCi()){
                System.out.println(songCi.getAuthor() + " - " + songCi.getParagraphs() + " - " + songCi.getRhythmic() + " - " + songCi.getTags());
            }
        }*/

        // 读取宋诗
        for(int i=0; i<61; i++){
            int index = i * 1000;
            String ind = Integer.toString(index);
            String fileName = "/Users/iloris/NutstoreCloudBridge/SUSTC/作业/DSAA/Project/DSAAProject/PoemJson/poet.song.";
            fileName += ind;
            fileName += ".json";

            TangSongShiList tangSongShiList = TangSongShiJson2Obj(fileName);
            tangSongShiListCollection.add(tangSongShiList);
        }

        // 读取唐诗
        for(int i=0; i<58; i++){
            int index = i * 1000;
            String ind = Integer.toString(index);
            String fileName = "/Users/iloris/NutstoreCloudBridge/SUSTC/作业/DSAA/Project/DSAAProject/PoemJson/poet.tang.";
            fileName += ind;
            fileName += ".json";

            TangSongShiList tangSongShiList = TangSongShiJson2Obj(fileName);
            tangSongShiListCollection.add(tangSongShiList);
        }

        // 添加位置
        for(int i=0; i<tangSongShiListCollection.size(); i++){
            for(int j=0; j<tangSongShiListCollection.get(i).getTangSongShi().size(); j++){
                tangSongShiListCollection.get(i).getTangSongShi().get(j).setListPosition(i);
                tangSongShiListCollection.get(i).getTangSongShi().get(j).setPositionInList(j);

                boolean ifUserExist = false;
                for(int k=0; k< ProgrammeStart.authorLibrary.size(); k++){
                    if(tangSongShiListCollection.get(i).getTangSongShi().get(j).getAuthor().equals(ProgrammeStart.authorLibrary.get(k).name)){
                        ProgrammeStart.authorLibrary.get(k).tangSongShiArrayList.add(tangSongShiListCollection.get(i).getTangSongShi().get(j));
                        ifUserExist = true;
                        break;
                    }
                }
                if(!ifUserExist){
                    Author author = new Author(tangSongShiListCollection.get(i).getTangSongShi().get(j).getAuthor());
                    ProgrammeStart.authorLibrary.add(author);
                    ProgrammeStart.authorLibrary.get(ProgrammeStart.authorLibrary.size()-1).tangSongShiArrayList.add(tangSongShiListCollection.get(i).getTangSongShi().get(j));
                }
            }
        }

        /*// 测试唐宋诗Collection
        for(int i=0; i<tangSongShiListCollection.size(); i++){
            for(TangSongShi tangSongShi : tangSongShiListCollection.get(i).getTangSongShi()){
                System.out.println(tangSongShi.getAuthor() + " - " + tangSongShi.getParagraphs() + " - " + tangSongShi.getTitle() + " - " + tangSongShi.getId() + " - " + tangSongShi.getTags());
            }
        }*/

        /*// 查看总数
        int size = 0;
        for(int i=0; i<tangSongShiListCollection.size(); i++){
            for(TangSongShi tangSongShi : tangSongShiListCollection.get(i).getTangSongShi()){
                size++;
            }
        }
        System.out.println(size);*/

    }


    public static SongCiList SongCiJson2Obj(String fileName){
        Gson gson = new Gson();
        BufferedReader br = null;
        SongCiList songCiList = null;

        try {
            br = new BufferedReader(new FileReader(fileName));
            songCiList = gson.fromJson(br, SongCiList.class);

            /*if(songCiList!=null){
                for(SongCi songCi : songCiList.getSongCi()){
                    songCiList.size++;
                }
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return songCiList;
    }

    public static TangSongShiList TangSongShiJson2Obj(String fileName) {
        Gson gson = new Gson();
        BufferedReader br = null;
        TangSongShiList tangSongShiList = null;

        try {
            br = new BufferedReader(new FileReader(fileName));
            tangSongShiList = gson.fromJson(br, TangSongShiList.class);

            /*if(tangSongShiList!=null){
                for(TangSongShi tangSongShi : tangSongShiList.getTangSongShi()){
                    tangSongShiList.size++;
                }
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tangSongShiList;
    }

    public static TangSongShi findShi(int listPosition, int poemInList){
        return tangSongShiListCollection.get(listPosition).getTangSongShi().get(poemInList);
    }

    public static SongCi findCi(int listPosition, int poemInList){
        return songCiListCollection.get(listPosition).getSongCi().get(poemInList);
    }
}


