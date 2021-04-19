package PoemsRecite.GUI.LoginWindow;

import PoemsRecite.GUI.MainWindow.MainWindow;
import PoemsRecite.GUI.RegisterWindow.RegisterWindow;
import PoemsRecite.ProgrammeStart;
import PoemsRecite.UserInformation.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController implements Initializable {
    public static String userName;

    public LoginWindowController() {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    //关闭本窗口并打开新窗口
    @FXML
    private javafx.scene.control.Button loginButton;
    //保存用户名
    @FXML
    public javafx.scene.control.TextField userNameTextField;

//    @FXML
//    public String getUserName() throws Exception {
//        String inputName;
//        inputName = userNameTextField.getText();
//        if(UserLibrary.ifUserExist(inputName)==true){
//            changeToMainWindow();
//        }
//        else{
//            changeToRegisterWindow();
//            User newUser = new User(inputName);
//
//        }
//    }
    @FXML
    public void loginCheck() throws Exception {
        userName = userNameTextField.getText();
        boolean userExist = ProgrammeStart.ifUserExist(userName);

        if(userExist){
            int index = ProgrammeStart.getUserNum(userName);
            ProgrammeStart.currentUser = ProgrammeStart.userLibrary.users.get(index);
            System.out.println("Welcome back!");
            changeToMainWindow();
        }else if(!userExist){
            changeToRegisterWindow();
        }
    }

    @FXML
    public void changeToMainWindow() throws Exception {
        MainWindow mainWindow = new MainWindow();
        mainWindow.showWindow();
        //关闭原来的window
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void changeToRegisterWindow() throws Exception {
        RegisterWindow registerWindow = new RegisterWindow();
        registerWindow.showWindow();
        //关闭原来的window
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private javafx.scene.control.Button quitButton;

    @FXML
    public void quitProgramme() {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }







}
