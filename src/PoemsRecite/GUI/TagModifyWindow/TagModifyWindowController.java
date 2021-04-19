package PoemsRecite.GUI.TagModifyWindow;

import PoemsRecite.GUI.LoginWindow.LoginWindow;
import PoemsRecite.GUI.PoemDetailWindow.PoemDetailWindow;
import PoemsRecite.GUI.PoemDetailWindow.PoemDetailWindowController;
import PoemsRecite.ProgrammeStart;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TagModifyWindowController implements Initializable {
    public static String inputContent;

    @FXML
    private TextField input;

    @FXML
    private Text Tags;

    @FXML
    private javafx.scene.control.Button addTagButton;
    @FXML
    private javafx.scene.control.Button deleteTagButton;

    public TagModifyWindowController(){

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        Tags.setText(showTags(PoemDetailWindow.shiOrCi, PoemDetailWindow.listPosition, PoemDetailWindow.poemInList));
    }


    @FXML
    public void addTag() throws Exception{
        inputContent = input.getText();
        System.out.println(inputContent);

        if(PoemDetailWindow.shiOrCi == 0){
            ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(PoemDetailWindow.listPosition).getTangSongShi().get(PoemDetailWindow.poemInList).getTags().add(inputContent);
        }else if(PoemDetailWindow.shiOrCi == 1){
            ProgrammeStart.poemsLibrary.songCiListCollection.get(PoemDetailWindow.listPosition).getSongCi().get(PoemDetailWindow.poemInList).getTags().add(inputContent);
        }

        PoemDetailWindow poemDetailWindow = new PoemDetailWindow();
        poemDetailWindow.showWindow();
        Stage stage = (Stage) addTagButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void deleteTag() throws Exception{
        inputContent = input.getText();
        System.out.println(inputContent);

        List<String> tags = null;
        if(PoemDetailWindow.shiOrCi == 0){
            tags = ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(PoemDetailWindow.listPosition).getTangSongShi().get(PoemDetailWindow.poemInList).getTags();
        }else if(PoemDetailWindow.shiOrCi == 1){
            tags = ProgrammeStart.poemsLibrary.songCiListCollection.get(PoemDetailWindow.listPosition).getSongCi().get(PoemDetailWindow.poemInList).getTags();
        }

        for(int i=0; i<tags.size(); i++){
            if(tags.get(i).equals(inputContent)){
                tags.remove(i);
                break;
            }
        }

        PoemDetailWindow poemDetailWindow = new PoemDetailWindow();
        poemDetailWindow.showWindow();
        Stage stage = (Stage) deleteTagButton.getScene().getWindow();
        stage.close();
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
}
