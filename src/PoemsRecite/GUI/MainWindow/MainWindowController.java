package PoemsRecite.GUI.MainWindow;

import PoemsRecite.GUI.CompareWindow.CompareWindow;
import PoemsRecite.GUI.ExitWindow.ExitWindow;
import PoemsRecite.GUI.PoemSelectWindow.PoemSelectWindow;
import PoemsRecite.GUI.PoemSelectWindow.PoemSelectWindowController;
import PoemsRecite.PoemObj.*;
import PoemsRecite.ProgrammeStart;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
// import sun.applet.Main;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    @FXML
    private javafx.scene.control.Label userID;
    @FXML
    private javafx.scene.control.Label studiedDays;
    @FXML
    private javafx.scene.control.Label finishedPoems;
    @FXML
    private javafx.scene.control.Label unfinishedPoems;

    public MainWindowController() {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        userID.setText(ProgrammeStart.currentUser.getUserName());
        studiedDays.setText(Integer.toString(ProgrammeStart.currentUser.getStudiedDays()));
        finishedPoems.setText(Integer.toString(ProgrammeStart.currentUser.getUnfinishedCiList().size() + ProgrammeStart.currentUser.getUnfinishedShiList().size()));

    }

    @FXML
    private javafx.scene.control.Button logOutButton;

    @FXML
    public void logOut() throws Exception {
        ExitWindow exitWindow = new ExitWindow();
        exitWindow.showWindow();
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private javafx.scene.control.Button StartReciteButton;

    @FXML
    public void changeToSelectWindow() throws Exception {
        PoemSelectWindow poemSelectWindow = new PoemSelectWindow();
        poemSelectWindow.showWindow();
        Stage stage = (Stage) StartReciteButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button exportButton;
    @FXML
    private Button compareButton;


    @FXML
    public void jumpToCompareWindow() throws Exception {
        CompareWindow compareWindow = new CompareWindow();
        compareWindow.showWindow();
        Stage stage = (Stage) compareButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void exportTXT() {
        PrintStream mytxt = null;
        PrintStream out = System.out;
        try {
            mytxt = new PrintStream(ProgrammeStart.currentUser.getUserName() + (ProgrammeStart.currentUser.getStudiedDays() + 1) + "天学习进度.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(mytxt);

        System.out.println("用户名：" + ProgrammeStart.currentUser.getUserName());
        System.out.println("学习天数: " + ProgrammeStart.currentUser.getStudiedDays());
        System.out.println("已学习诗词总数：" + (ProgrammeStart.currentUser.getUnfinishedCiList().size() + ProgrammeStart.currentUser.getUnfinishedShiList().size()));
        System.out.println("其中诗：" + ProgrammeStart.currentUser.getUnfinishedShiList().size() + "首");
        System.out.println("其中词：" + ProgrammeStart.currentUser.getUnfinishedCiList().size() + "首");
        System.out.println();
        System.out.println("具体学习古诗词如下：");
        System.out.println();
        for (ReviewTangSongShi reviewTangSongShi : ProgrammeStart.currentUser.getUnfinishedShiList()) {
            System.out.println(reviewTangSongShi.getTitle());
            System.out.println(reviewTangSongShi.getAuthor());
            for (String content : reviewTangSongShi.getParagraphs()) {
                System.out.println(content);
            }

            System.out.println();
            String studiedDays = "";
            for (int i = 0; i < reviewTangSongShi.studiedDays.size(); i++) {
                studiedDays += "第" + (reviewTangSongShi.studiedDays.get(i) + 1) + "天" + " ";
            }
            System.out.println("学习日期：" + studiedDays);

            String grading = "";
            for (int i = 0; i < reviewTangSongShi.grading.size(); i++) {
                grading += reviewTangSongShi.grading.get(i) + "分 ";
            }
            System.out.println("学习评分记录：" + grading);
            System.out.println();

        }
        for (ReviewSongCi reviewSongCi : ProgrammeStart.currentUser.getUnfinishedCiList()) {
            System.out.println(reviewSongCi.getRhythmic());
            System.out.println(reviewSongCi.getAuthor());
            for (String content : reviewSongCi.getParagraphs()) {
                System.out.println(content);
            }

            System.out.println();
            String studiedDays = "";
            for (int i = 0; i < reviewSongCi.studiedDays.size(); i++) {
                studiedDays += "第" + (reviewSongCi.studiedDays.get(i) + 1) + "天" + " ";
            }
            System.out.println("学习日期：" + studiedDays);

            String grading = "";
            for (int i = 0; i < reviewSongCi.grading.size(); i++) {
                grading += reviewSongCi.grading.get(i) + "分 ";
            }
            System.out.println("学习评分记录：" + grading);
            System.out.println();

        }

        System.setOut(out);
        System.out.println("导出成功");

    }


    @FXML
    private Button simulateButton;

    @FXML
    public void simulateStudy() throws Exception {

        for(int i = 0; i<151; i++) {
            int shiOrCi = ProgrammeStart.generatingIntegerBounded(0, 2);
            int listPosition;
            int poemPosition;
            if (shiOrCi == 0) {
                listPosition = ProgrammeStart.generatingIntegerBounded(0, ProgrammeStart.poemsLibrary.tangSongShiListCollection.size());
                poemPosition = ProgrammeStart.generatingIntegerBounded(0, ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(listPosition).getTangSongShi().size());

                TangSongShi tangSongShi = PoemsLibrary.findShi(listPosition, poemPosition);
                ReviewTangSongShi reviewTangSongShi = new ReviewTangSongShi(tangSongShi);
                ProgrammeStart.currentUser.getUnfinishedShiList().add(reviewTangSongShi);
                ProgrammeStart.currentUser.getUnfinishedShiList().get(ProgrammeStart.currentUser.getUnfinishedShiList().size()-1).grading.add(ProgrammeStart.generatingIntegerBounded(1, 6));
                ProgrammeStart.currentUser.getUnfinishedShiList().get(ProgrammeStart.currentUser.getUnfinishedShiList().size()-1).studiedDays.add(ProgrammeStart.currentUser.getStudiedDays());
            }else{
                listPosition = ProgrammeStart.generatingIntegerBounded(0, ProgrammeStart.poemsLibrary.songCiListCollection.size());
                poemPosition = ProgrammeStart.generatingIntegerBounded(0, ProgrammeStart.poemsLibrary.songCiListCollection.get(listPosition).getSongCi().size());

                SongCi songCi = PoemsLibrary.findCi(listPosition, poemPosition);
                ReviewSongCi reviewSongCi = new ReviewSongCi(songCi);
                ProgrammeStart.currentUser.getUnfinishedCiList().add(reviewSongCi);
                ProgrammeStart.currentUser.getUnfinishedCiList().get(ProgrammeStart.currentUser.getUnfinishedCiList().size()-1).grading.add(ProgrammeStart.generatingIntegerBounded(1, 6));
                ProgrammeStart.currentUser.getUnfinishedCiList().get(ProgrammeStart.currentUser.getUnfinishedCiList().size()-1).studiedDays.add(ProgrammeStart.currentUser.getStudiedDays());
            }

            ProgrammeStart.currentUser.setStudiedDays(ProgrammeStart.currentUser.getStudiedDays()+1);
        }

        //重开主菜单
        MainWindow mainWindow = new MainWindow();
        mainWindow.showWindow();
        Stage stage = (Stage) simulateButton.getScene().getWindow();
        stage.close();
    }
}
