package PoemsRecite.GUI.ExitWindow;

import PoemsRecite.GUI.LoginWindow.LoginWindow;
import PoemsRecite.ProgrammeStart;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ExitWindowController implements Initializable {

    public ExitWindowController(){

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

    }

    @FXML
    private javafx.scene.control.Button finishToday;
    @FXML
    private javafx.scene.control.Button notFinishToday;

    @FXML
    public void finishToday() throws Exception{

        ProgrammeStart.currentUser.setStudiedDays(ProgrammeStart.currentUser.getStudiedDays()+1);

        LoginWindow loginWindow = new LoginWindow();
        loginWindow.showWindow();
        Stage stage = (Stage) finishToday.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void notFinishToday() throws Exception{
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.showWindow();
        Stage stage = (Stage) notFinishToday.getScene().getWindow();
        stage.close();
    }
}
