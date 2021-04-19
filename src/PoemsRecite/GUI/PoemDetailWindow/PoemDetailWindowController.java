package PoemsRecite.GUI.PoemDetailWindow;

import PoemsRecite.GUI.CiReviewWindow.CiReviewWindow;
import PoemsRecite.GUI.PoemGradingWindow.PoemGradingWindow;
import PoemsRecite.GUI.PoemGradingWindow.PoemGradingWindowController;
import PoemsRecite.GUI.PoemSelectWindow.PoemSelectWindow;
import PoemsRecite.GUI.SearchWindow.SearchWindow;
import PoemsRecite.GUI.ShiReviewWindow.ShiReviewWindow;
import PoemsRecite.GUI.TagModifyWindow.TagModifyWindow;
import PoemsRecite.PoemObj.ReviewSongCi;
import PoemsRecite.PoemObj.ReviewTangSongShi;
import PoemsRecite.ProgrammeStart;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PoemDetailWindowController implements Initializable {

    public PoemDetailWindowController() {

    }

    @FXML
    private javafx.scene.control.Button BackButton;

    @FXML
    private javafx.scene.control.Label author;

    @FXML
    private javafx.scene.control.Label title;

    @FXML
    private javafx.scene.control.Label content;

    @FXML
    private javafx.scene.control.Label star5;

    @FXML
    private javafx.scene.control.Label star4;

    @FXML
    private javafx.scene.control.Label star3;

    @FXML
    private javafx.scene.control.Label star2;

    @FXML
    private javafx.scene.control.Label star1;

    @FXML
    private Text Tag;

    @FXML
    private Button modifyTagButton;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        if(PoemDetailWindow.shiOrCi == 0){
            if(ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(PoemDetailWindow.listPosition).getTangSongShi().get(PoemDetailWindow.poemInList).getTags() == null){
                List<String> tags = new ArrayList<String>();
                ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(PoemDetailWindow.listPosition).getTangSongShi().get(PoemDetailWindow.poemInList).setTags(tags);
            }
        }else if(PoemDetailWindow.shiOrCi == 1){
            if(ProgrammeStart.poemsLibrary.songCiListCollection.get(PoemDetailWindow.listPosition).getSongCi().get(PoemDetailWindow.poemInList).getTags() == null){
                List<String> tags = new ArrayList<String>();
                ProgrammeStart.poemsLibrary.songCiListCollection.get(PoemDetailWindow.listPosition).getSongCi().get(PoemDetailWindow.poemInList).setTags(tags);
            }
        }

        if(PoemDetailWindow.shiOrCi == 0){
            title.setText(ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(PoemDetailWindow.listPosition).getTangSongShi().get(PoemDetailWindow.poemInList).getTitle());
            author.setText(ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(PoemDetailWindow.listPosition).getTangSongShi().get(PoemDetailWindow.poemInList).getAuthor());
            content.setText(showContent(PoemDetailWindow.shiOrCi, PoemDetailWindow.listPosition, PoemDetailWindow.poemInList));
            Tag.setText(showTags(PoemDetailWindow.shiOrCi, PoemDetailWindow.listPosition, PoemDetailWindow.poemInList));
        }else if(PoemDetailWindow.shiOrCi == 1){
            title.setText(ProgrammeStart.poemsLibrary.songCiListCollection.get(PoemDetailWindow.listPosition).getSongCi().get(PoemDetailWindow.poemInList).getRhythmic());
            author.setText(ProgrammeStart.poemsLibrary.songCiListCollection.get(PoemDetailWindow.listPosition).getSongCi().get(PoemDetailWindow.poemInList).getAuthor());
            content.setText(showContent(PoemDetailWindow.shiOrCi, PoemDetailWindow.listPosition, PoemDetailWindow.poemInList));
            Tag.setText(showTags(PoemDetailWindow.shiOrCi, PoemDetailWindow.listPosition, PoemDetailWindow.poemInList));
        }

        //鼠标放在星星上
        star5.setOnMouseEntered(event -> {
            star5.setTextFill(Color.web("#09e1dd"));
            star4.setTextFill(Color.web("#09e1dd"));
            star3.setTextFill(Color.web("#09e1dd"));
            star2.setTextFill(Color.web("#09e1dd"));
            star1.setTextFill(Color.web("#09e1dd"));
        });
        star4.setOnMouseEntered(event -> {
            star4.setTextFill(Color.web("#09e1dd"));
            star3.setTextFill(Color.web("#09e1dd"));
            star2.setTextFill(Color.web("#09e1dd"));
            star1.setTextFill(Color.web("#09e1dd"));
        });
        star3.setOnMouseEntered(event -> {
            star3.setTextFill(Color.web("#09e1dd"));
            star2.setTextFill(Color.web("#09e1dd"));
            star1.setTextFill(Color.web("#09e1dd"));
        });
        star2.setOnMouseEntered(event -> {
            star2.setTextFill(Color.web("#09e1dd"));
            star1.setTextFill(Color.web("#09e1dd"));
        });
        star1.setOnMouseEntered(event -> {
            star1.setTextFill(Color.web("#09e1dd"));
        });

        star5.setOnMouseExited(event -> {
            star5.setTextFill(Color.web("#d4d4d4"));
            star4.setTextFill(Color.web("#d4d4d4"));
            star3.setTextFill(Color.web("#d4d4d4"));
            star2.setTextFill(Color.web("#d4d4d4"));
            star1.setTextFill(Color.web("#d4d4d4"));
        });
        star4.setOnMouseExited(event -> {
            star4.setTextFill(Color.web("#d4d4d4"));
            star3.setTextFill(Color.web("#d4d4d4"));
            star2.setTextFill(Color.web("#d4d4d4"));
            star1.setTextFill(Color.web("#d4d4d4"));
        });
        star3.setOnMouseExited(event -> {
            star3.setTextFill(Color.web("#d4d4d4"));
            star2.setTextFill(Color.web("#d4d4d4"));
            star1.setTextFill(Color.web("#d4d4d4"));
        });
        star2.setOnMouseExited(event -> {
            star2.setTextFill(Color.web("#d4d4d4"));
            star1.setTextFill(Color.web("#d4d4d4"));
        });
        star1.setOnMouseExited(event -> {
            star1.setTextFill(Color.web("#d4d4d4"));
        });


        //单击星星
        star1.setOnMouseClicked(event -> {
            if(!ProgrammeStart.currentUser.ifExist(PoemDetailWindow.shiOrCi, PoemDetailWindow.listPosition, PoemDetailWindow.poemInList)){
                if(PoemDetailWindow.shiOrCi == 0){
                    ReviewTangSongShi reviewTangSongShi = new ReviewTangSongShi(ProgrammeStart.poemsLibrary.findShi(PoemDetailWindow.listPosition, PoemDetailWindow.poemInList));
                    ProgrammeStart.currentUser.getUnfinishedShiList().add(reviewTangSongShi);
                }else if(PoemDetailWindow.shiOrCi == 1){
                    ReviewSongCi reviewSongCi = new ReviewSongCi(ProgrammeStart.poemsLibrary.findCi(PoemDetailWindow.listPosition, PoemDetailWindow.poemInList));
                    ProgrammeStart.currentUser.getUnfinishedCiList().add(reviewSongCi);
                }
            }
            int[] temp = ProgrammeStart.currentUser.findReviewPoemIndex(PoemDetailWindow.shiOrCi, PoemDetailWindow.listPosition, PoemDetailWindow.poemInList);
            if(temp[0] == 0){
                ProgrammeStart.currentUser.getUnfinishedShiList().get(temp[1]).grading.add(1);
                ProgrammeStart.currentUser.getUnfinishedShiList().get(temp[1]).studiedDays.add(ProgrammeStart.currentUser.getStudiedDays());
            }else if(temp[0] == 1){
                ProgrammeStart.currentUser.getUnfinishedCiList().get(temp[1]).grading.add(1);
                ProgrammeStart.currentUser.getUnfinishedCiList().get(temp[1]).studiedDays.add(ProgrammeStart.currentUser.getStudiedDays());
            }
            PoemGradingWindowController.grade = 1;
            PoemGradingWindow poemGradingWindow = new PoemGradingWindow();
            try {
                poemGradingWindow.showWindow();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) star1.getScene().getWindow();
            stage.close();
        });

        star2.setOnMouseClicked(event -> {
            if(!ProgrammeStart.currentUser.ifExist(PoemDetailWindow.shiOrCi, PoemDetailWindow.listPosition, PoemDetailWindow.poemInList)){
                if(PoemDetailWindow.shiOrCi == 0){
                    ReviewTangSongShi reviewTangSongShi = new ReviewTangSongShi(ProgrammeStart.poemsLibrary.findShi(PoemDetailWindow.listPosition, PoemDetailWindow.poemInList));
                    ProgrammeStart.currentUser.getUnfinishedShiList().add(reviewTangSongShi);
                }else if(PoemDetailWindow.shiOrCi == 1){
                    ReviewSongCi reviewSongCi = new ReviewSongCi(ProgrammeStart.poemsLibrary.findCi(PoemDetailWindow.listPosition, PoemDetailWindow.poemInList));
                    ProgrammeStart.currentUser.getUnfinishedCiList().add(reviewSongCi);
                }
            }
            int[] temp = ProgrammeStart.currentUser.findReviewPoemIndex(PoemDetailWindow.shiOrCi, PoemDetailWindow.listPosition, PoemDetailWindow.poemInList);
            if(temp[0] == 0){
                ProgrammeStart.currentUser.getUnfinishedShiList().get(temp[1]).grading.add(2);
                ProgrammeStart.currentUser.getUnfinishedShiList().get(temp[1]).studiedDays.add(ProgrammeStart.currentUser.getStudiedDays());
            }else if(temp[0] == 1){
                ProgrammeStart.currentUser.getUnfinishedCiList().get(temp[1]).grading.add(2);
                ProgrammeStart.currentUser.getUnfinishedCiList().get(temp[1]).studiedDays.add(ProgrammeStart.currentUser.getStudiedDays());
            }
            PoemGradingWindowController.grade = 2;
            PoemGradingWindow poemGradingWindow = new PoemGradingWindow();
            try {
                poemGradingWindow.showWindow();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) star2.getScene().getWindow();
            stage.close();
        });

        star3.setOnMouseClicked(event -> {
            if(!ProgrammeStart.currentUser.ifExist(PoemDetailWindow.shiOrCi, PoemDetailWindow.listPosition, PoemDetailWindow.poemInList)){
                if(PoemDetailWindow.shiOrCi == 0){
                    ReviewTangSongShi reviewTangSongShi = new ReviewTangSongShi(ProgrammeStart.poemsLibrary.findShi(PoemDetailWindow.listPosition, PoemDetailWindow.poemInList));
                    ProgrammeStart.currentUser.getUnfinishedShiList().add(reviewTangSongShi);
                }else if(PoemDetailWindow.shiOrCi == 1){
                    ReviewSongCi reviewSongCi = new ReviewSongCi(ProgrammeStart.poemsLibrary.findCi(PoemDetailWindow.listPosition, PoemDetailWindow.poemInList));
                    ProgrammeStart.currentUser.getUnfinishedCiList().add(reviewSongCi);
                }
            }
            int[] temp = ProgrammeStart.currentUser.findReviewPoemIndex(PoemDetailWindow.shiOrCi, PoemDetailWindow.listPosition, PoemDetailWindow.poemInList);
            if(temp[0] == 0){
                ProgrammeStart.currentUser.getUnfinishedShiList().get(temp[1]).grading.add(3);
                ProgrammeStart.currentUser.getUnfinishedShiList().get(temp[1]).studiedDays.add(ProgrammeStart.currentUser.getStudiedDays());
            }else if(temp[0] == 1){
                ProgrammeStart.currentUser.getUnfinishedCiList().get(temp[1]).grading.add(3);
                ProgrammeStart.currentUser.getUnfinishedCiList().get(temp[1]).studiedDays.add(ProgrammeStart.currentUser.getStudiedDays());
            }
            PoemGradingWindowController.grade = 3;
            PoemGradingWindow poemGradingWindow = new PoemGradingWindow();
            try {
                poemGradingWindow.showWindow();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) star3.getScene().getWindow();
            stage.close();
        });
        star4.setOnMouseClicked(event -> {
            if(!ProgrammeStart.currentUser.ifExist(PoemDetailWindow.shiOrCi, PoemDetailWindow.listPosition, PoemDetailWindow.poemInList)){
                if(PoemDetailWindow.shiOrCi == 0){
                    ReviewTangSongShi reviewTangSongShi = new ReviewTangSongShi(ProgrammeStart.poemsLibrary.findShi(PoemDetailWindow.listPosition, PoemDetailWindow.poemInList));
                    ProgrammeStart.currentUser.getUnfinishedShiList().add(reviewTangSongShi);
                }else if(PoemDetailWindow.shiOrCi == 1){
                    ReviewSongCi reviewSongCi = new ReviewSongCi(ProgrammeStart.poemsLibrary.findCi(PoemDetailWindow.listPosition, PoemDetailWindow.poemInList));
                    ProgrammeStart.currentUser.getUnfinishedCiList().add(reviewSongCi);
                }
            }
            int[] temp = ProgrammeStart.currentUser.findReviewPoemIndex(PoemDetailWindow.shiOrCi, PoemDetailWindow.listPosition, PoemDetailWindow.poemInList);
            if(temp[0] == 0){
                ProgrammeStart.currentUser.getUnfinishedShiList().get(temp[1]).grading.add(4);
                ProgrammeStart.currentUser.getUnfinishedShiList().get(temp[1]).studiedDays.add(ProgrammeStart.currentUser.getStudiedDays());
            }else if(temp[0] == 1){
                ProgrammeStart.currentUser.getUnfinishedCiList().get(temp[1]).grading.add(4);
                ProgrammeStart.currentUser.getUnfinishedCiList().get(temp[1]).studiedDays.add(ProgrammeStart.currentUser.getStudiedDays());
            }

            PoemGradingWindowController.grade = 4;
            PoemGradingWindow poemGradingWindow = new PoemGradingWindow();
            try {
                poemGradingWindow.showWindow();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) star4.getScene().getWindow();
            stage.close();
        });
        star5.setOnMouseClicked(event -> {
            if(!ProgrammeStart.currentUser.ifExist(PoemDetailWindow.shiOrCi, PoemDetailWindow.listPosition, PoemDetailWindow.poemInList)){
                if(PoemDetailWindow.shiOrCi == 0){
                    ReviewTangSongShi reviewTangSongShi = new ReviewTangSongShi(ProgrammeStart.poemsLibrary.findShi(PoemDetailWindow.listPosition, PoemDetailWindow.poemInList));
                    ProgrammeStart.currentUser.getUnfinishedShiList().add(reviewTangSongShi);
                }else if(PoemDetailWindow.shiOrCi == 1){
                    ReviewSongCi reviewSongCi = new ReviewSongCi(ProgrammeStart.poemsLibrary.findCi(PoemDetailWindow.listPosition, PoemDetailWindow.poemInList));
                    ProgrammeStart.currentUser.getUnfinishedCiList().add(reviewSongCi);
                }
            }
            int[] temp = ProgrammeStart.currentUser.findReviewPoemIndex(PoemDetailWindow.shiOrCi, PoemDetailWindow.listPosition, PoemDetailWindow.poemInList);
            if(temp[0] == 0){
                ProgrammeStart.currentUser.getUnfinishedShiList().get(temp[1]).grading.add(5);
                ProgrammeStart.currentUser.getUnfinishedShiList().get(temp[1]).studiedDays.add(ProgrammeStart.currentUser.getStudiedDays());
            }else if(temp[0] == 1){
                ProgrammeStart.currentUser.getUnfinishedCiList().get(temp[1]).grading.add(5);
                ProgrammeStart.currentUser.getUnfinishedCiList().get(temp[1]).studiedDays.add(ProgrammeStart.currentUser.getStudiedDays());
            }

            PoemGradingWindowController.grade = 5;
            PoemGradingWindow poemGradingWindow = new PoemGradingWindow();
            try {
                poemGradingWindow.showWindow();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) star5.getScene().getWindow();
            stage.close();
        });
    }

    public String showContent(int shiOrCi, int listPosition, int poemInPosition){
        String content = "";
        List<String> contents = null;
        if(shiOrCi == 0){
            contents = ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(listPosition).getTangSongShi().get(poemInPosition).getParagraphs();
        }else{
            contents = ProgrammeStart.poemsLibrary.songCiListCollection.get(listPosition).getSongCi().get(poemInPosition).getParagraphs();
        }
        for(int i=0; i<contents.size(); i++){
            content += contents.get(i) + "\r\n";
        }

        return content;
    }

    public String showTags(int shiOrCi, int listPosition, int poemInPosition){
        String tag = "";
        List<String> tags = null;
        if(shiOrCi == 0){
            tags = ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(listPosition).getTangSongShi().get(poemInPosition).getTags();
        }else{
            tags = ProgrammeStart.poemsLibrary.songCiListCollection.get(listPosition).getSongCi().get(poemInPosition).getTags();
        }

        if(tags != null) {
            for (int i = 0; i < tags.size(); i++) {
                tag += tags.get(i) + "  ";
            }
        }

        if(tag.equals("") || tag.equals(" ") || tag.equals("  ") || tag.equals("   ")){
            tag = "暂无tag";
        }

        return tag;
    }


    public void jumpToModifyTagWindow() throws Exception{
        TagModifyWindow tagModifyWindow = new TagModifyWindow();
        tagModifyWindow.showWindow();
        //关闭原来的window
        Stage stage = (Stage) modifyTagButton.getScene().getWindow();
        stage.close();
    }

    public void backToPoemSelectWindow() throws Exception {
        if(!PoemDetailWindow.isReview  && PoemDetailWindow.isSearch == false) {
            PoemSelectWindow poemSelectWindow = new PoemSelectWindow();
            poemSelectWindow.showWindow();
        }else if(PoemDetailWindow.isReview && !PoemDetailWindow.isSearch){
            if(PoemDetailWindow.shiOrCi == 0){
                ShiReviewWindow shiReviewWindow = new ShiReviewWindow();
                shiReviewWindow.showWindow();
            }else if(PoemDetailWindow.shiOrCi == 1){
                CiReviewWindow ciReviewWindow = new CiReviewWindow();
                ciReviewWindow.showWindow();
            }
        }else if(PoemDetailWindow.isSearch){
            SearchWindow searchWindow = new SearchWindow();
            searchWindow.showWindow();
        }
        //关闭原来的window
        Stage stage = (Stage) BackButton.getScene().getWindow();
        stage.close();
    }
}