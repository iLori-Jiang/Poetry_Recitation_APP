                                                                                                                                                                                                                                                                                                                                                                                                    package PoemsRecite;

import PoemsRecite.GUI.LoginWindow.LoginWindow;
import PoemsRecite.GUI.LoginWindow.LoginWindowController;
import PoemsRecite.PoemObj.Author;
import PoemsRecite.PoemObj.PoemsLibrary;
import PoemsRecite.UserInformation.User;
import PoemsRecite.UserInformation.UserLibrary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class ProgrammeStart {
    public static UserLibrary userLibrary;
    public static PoemsLibrary poemsLibrary;
    public static User currentUser;
    public static ArrayList<Author> authorLibrary;


    public static void main(String[] args) throws Exception {
        userLibrary = new UserLibrary();
        poemsLibrary = new PoemsLibrary();
        authorLibrary = new ArrayList<Author>();
        poemsLibrary.loadLibrary();

        int shiNumber = 0;
        int ciNumber = 0;
        int authorNumber = 0;

        for(int i=0; i<poemsLibrary.tangSongShiListCollection.size(); i++){
            shiNumber += poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().size();
        }
        for(int i=0; i<poemsLibrary.songCiListCollection.size(); i++){
            ciNumber += poemsLibrary.songCiListCollection.get(i).getSongCi().size();
        }
        authorNumber = authorLibrary.size();

        System.out.println("已读入诗：" + shiNumber + "首");
        System.out.println("已读入词：" + ciNumber + "首");
        System.out.println("已读入作者：" + authorNumber + "名");




        // test
        /*int size = 0;
        for(int i=0; i<poemsLibrary.tangSongShiListCollection.size(); i++){
            for(TangSongShi tangSongShi : poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi()){
                size++;
            }
        }
        System.out.println(size);*/


        LoginWindow.startGUI();
    }


    // 判断用户是否存在
    public static boolean ifUserExist(String userName){
        for(User user : userLibrary.users){
            if(user.getUserName().equals(userName)){
                return true;
            }
        }
        return false;
    }

    // 查找用户序号
    public static int getUserNum(String userName){
        for(int i=0; i<userLibrary.users.size(); i++){
            if(userLibrary.users.get(i).getUserName().equals(userName) ){
                return i;
            }
        }
        return -1;
    }

    // 生成随机数
    public static int generatingIntegerBounded(int a, int b){

        int min = a;
        int max = b;
        int intBounded = min + ((int) (new Random().nextFloat() * (max - min)));
        return intBounded;
    }

    // 读取tag
    public void importTag(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String textLine;
        String str = "";
        String position = "";
        while((textLine = br.readLine()) != null){
            position = textLine;
            if(Character.isDigit(position.charAt(0))){
                int[] temp = new int [3];
                for(int i=0; i<temp.length; i++){
                    temp[i] = position.charAt(i);
                }
                str = br.readLine();
                String[] tags = str.split(" ");



            }
        }

    }


}
