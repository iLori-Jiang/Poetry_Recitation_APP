package PoemsRecite.GUI.CompareWindow;

import PoemsRecite.GUI.ExitWindow.ExitWindow;
import PoemsRecite.GUI.MainWindow.MainWindow;
import PoemsRecite.GUI.PoemSelectWindow.PoemSelectWindow;
import PoemsRecite.PoemObj.ReviewTangSongShi;
import PoemsRecite.ProgrammeStart;
import PoemsRecite.UserInformation.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CompareWindowController implements Initializable {

    @FXML
    private Label User1, User2, User3, User4, User5;
    @FXML
    private Label Content1, Content2, Content3, Content4, Content5, Num1, Num2, Num3;


    public CompareWindowController() {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        sortUsersByStudiedPoems();

        User1.setText(ProgrammeStart.currentUser.getUserName());
        Content1.setText("已学习 " + (ProgrammeStart.currentUser.getUnfinishedShiList().size() + ProgrammeStart.currentUser.getUnfinishedCiList().size()) +" 首诗词");
        if (ProgrammeStart.userLibrary.users.size() > 0) {
            User2.setText(ProgrammeStart.userLibrary.users.get(0).getUserName());
            Content2.setText("已学习 " + (ProgrammeStart.userLibrary.users.get(0).getUnfinishedShiList().size() + ProgrammeStart.userLibrary.users.get(0).getUnfinishedCiList().size()) +" 首诗词");
        }else{
            User2.setText("");
            Content2.setText("");
            Num1.setText("");
        }
        if (ProgrammeStart.userLibrary.users.size() > 1){
            User3.setText(ProgrammeStart.userLibrary.users.get(1).getUserName());
            Content3.setText("已学习 " + (ProgrammeStart.userLibrary.users.get(1).getUnfinishedShiList().size() + ProgrammeStart.userLibrary.users.get(1).getUnfinishedCiList().size()) +" 首诗词");
        }else{
            User3.setText("");
            Content3.setText("");
            Num2.setText("");
        }
        if (ProgrammeStart.userLibrary.users.size() > 2) {
            User4.setText(ProgrammeStart.userLibrary.users.get(2).getUserName());
            Content4.setText("已学习 " + (ProgrammeStart.userLibrary.users.get(2).getUnfinishedShiList().size() + ProgrammeStart.userLibrary.users.get(2).getUnfinishedCiList().size()) +" 首诗词");
        }else{
            User4.setText("");
            Content4.setText("");
            Num3.setText("");
        }
        if (ProgrammeStart.userLibrary.users.size() > 3) {
            User5.setText(ProgrammeStart.userLibrary.users.get(3).getUserName());
            Content5.setText("已学习 " + (ProgrammeStart.userLibrary.users.get(3).getUnfinishedShiList().size() + ProgrammeStart.userLibrary.users.get(3).getUnfinishedCiList().size()) +" 首诗词");
        }else{
            User5.setText("");
            Content5.setText("");
        }

    }

    @FXML
    public javafx.scene.control.Button HomeButton;

    @FXML
    public void backToHome() throws Exception {
        MainWindow mainWindow = new MainWindow();
        mainWindow.showWindow();
        Stage stage = (Stage) HomeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public static void sortUsersByStudiedPoems() {
        for (int i = 0; i < ProgrammeStart.userLibrary.users.size(); i++) {
            User user;
            for (int j = i + 1; j < ProgrammeStart.userLibrary.users.size(); j++) {
                if (ProgrammeStart.userLibrary.users.get(i).getUnfinishedCiList().size() + ProgrammeStart.userLibrary.users.get(i).getUnfinishedShiList().size() < ProgrammeStart.userLibrary.users.get(j).getUnfinishedCiList().size() + ProgrammeStart.userLibrary.users.get(j).getUnfinishedShiList().size()) {
                    user = ProgrammeStart.userLibrary.users.get(j);
                    ProgrammeStart.userLibrary.users.set(j, ProgrammeStart.userLibrary.users.get(i));
                    ProgrammeStart.userLibrary.users.set(i, user);
                }
            }
        }
    }


}
