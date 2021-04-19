package PoemsRecite.GUI.PoemDetailWindow;

import PoemsRecite.ProgrammeStart;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PoemDetailWindow extends Application {
    public static boolean isReview;
    Stage stage = new Stage();
    public static int shiOrCi;
    public static int listPosition;
    public static int poemInList;
    public static boolean isSearch;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("poemDetailWindow.fxml"));
        primaryStage.setTitle("");
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
