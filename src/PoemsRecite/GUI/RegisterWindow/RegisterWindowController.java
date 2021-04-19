package PoemsRecite.GUI.RegisterWindow;

import PoemsRecite.GUI.LoginWindow.LoginWindow;
import PoemsRecite.GUI.LoginWindow.LoginWindowController;
import PoemsRecite.GUI.MainWindow.MainWindow;
import PoemsRecite.ProgrammeStart;
import PoemsRecite.UserInformation.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static PoemsRecite.GUI.LoginWindow.LoginWindowController.userName;

public class RegisterWindowController implements Initializable {

    public RegisterWindowController(){

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

    }

    @FXML
    private javafx.scene.control.Button yesButton;

    @FXML
    public void changeToMainWindow() throws Exception {
        User user = new User(userName);

        ProgrammeStart.userLibrary.users.add(user);
        ProgrammeStart.currentUser = user;
        System.out.println("added");
        MainWindow mainWindow = new MainWindow();
        mainWindow.showWindow();
        Stage stage = (Stage) yesButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private javafx.scene.control.Button noButton;

    @FXML
    public void changeToLoginWindow() throws Exception {
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.showWindow();
        Stage stage = (Stage) noButton.getScene().getWindow();
        stage.close();
    }
}
