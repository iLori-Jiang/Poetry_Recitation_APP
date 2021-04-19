package PoemsRecite.GUI.PoemGradingWindow;

import PoemsRecite.GUI.CiReviewWindow.CiReviewWindow;
import PoemsRecite.GUI.PoemDetailWindow.PoemDetailWindow;
import PoemsRecite.GUI.PoemSelectWindow.PoemSelectWindow;
import PoemsRecite.GUI.SearchWindow.SearchWindow;
import PoemsRecite.GUI.ShiReviewWindow.ShiReviewWindow;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PoemGradingWindowController implements Initializable {
    public static int grade;

    @FXML
    private Button gotItButton;

    @FXML
    private Text Grade;

    public PoemGradingWindowController() {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Grade.setText(Integer.toString(grade));

        gotItButton.setOnMouseClicked(event -> {

            if (PoemDetailWindow.isReview == false && PoemDetailWindow.isSearch == false) {

                //学新诗和词
                PoemSelectWindow poemSelectWindow = new PoemSelectWindow();
                try {
                    poemSelectWindow.showWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if(PoemDetailWindow.isReview == true && PoemDetailWindow.isSearch == false) {

                //复习诗
                if (PoemDetailWindow.shiOrCi == 0) {
                    ShiReviewWindow shiReviewWindow = new ShiReviewWindow();
                    try {
                        shiReviewWindow.showWindow();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                //复习词
                else if (PoemDetailWindow.shiOrCi == 1) {
                    CiReviewWindow ciReviewWindow = new CiReviewWindow();
                    try {
                        ciReviewWindow.showWindow();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else if(PoemDetailWindow.isSearch == true){
                SearchWindow searchWindow = new SearchWindow();
                try {
                    searchWindow.showWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Stage stage = (Stage) gotItButton.getScene().getWindow();
            stage.close();
        });


    }

}
