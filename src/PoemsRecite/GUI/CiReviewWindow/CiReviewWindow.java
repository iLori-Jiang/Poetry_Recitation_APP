package PoemsRecite.GUI.CiReviewWindow;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CiReviewWindow extends Application {
    Stage stage = new Stage();
    public static int currentPage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ciReviewWindow.fxml"));
        primaryStage.setTitle("复习旧词");
        primaryStage.setScene(new Scene(root, 500, 800));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    public void showWindow() throws Exception {
        start(stage);
    }


}
