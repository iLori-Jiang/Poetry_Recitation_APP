package PoemsRecite.GUI.SearchWindow;

import PoemsRecite.GUI.MainWindow.MainWindow;
import PoemsRecite.GUI.PoemDetailWindow.PoemDetailWindow;
import PoemsRecite.GUI.PoemSelectWindow.PoemSelectWindow;
import PoemsRecite.GUI.PoemSelectWindow.PoemSelectWindowController;
import PoemsRecite.KMPSearch.*;
import PoemsRecite.PoemObj.*;
import PoemsRecite.ProgrammeStart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchWindowController implements Initializable {

    public static int shiORci1;
    public static int shiORci2;
    public static int shiORci3;
    public static int shiORci4;
    public static int shiORci5;

    public static int listPosition1;
    public static int listPosition2;
    public static int listPosition3;
    public static int listPosition4;
    public static int listPosition5;

    public static int poemPosition1;
    public static int poemPosition2;
    public static int poemPosition3;
    public static int poemPosition4;
    public static int poemPosition5;

    private ArrayList<int[]> poemToShow;

    @FXML
    private ChoiceBox SearchClass1;

    @FXML
    private ChoiceBox SearchClass2;

    @FXML
    private ChoiceBox Relationship;

    @FXML
    public javafx.scene.control.TextField SearchText1;

    @FXML
    public javafx.scene.control.TextField SearchText2;

    @FXML
    private javafx.scene.control.Label Title1;

    @FXML
    private javafx.scene.control.Label Author1;

    @FXML
    private javafx.scene.control.Label Content1;

    @FXML
    private javafx.scene.control.Label Title2;

    @FXML
    private javafx.scene.control.Label Author2;

    @FXML
    private javafx.scene.control.Label Content2;

    @FXML
    private javafx.scene.control.Label Title3;

    @FXML
    private javafx.scene.control.Label Author3;

    @FXML
    private javafx.scene.control.Label Content3;

    @FXML
    private javafx.scene.control.Label Title4;

    @FXML
    private javafx.scene.control.Label Author4;

    @FXML
    private javafx.scene.control.Label Content4;

    @FXML
    private javafx.scene.control.Label Title5;

    @FXML
    private javafx.scene.control.Label Author5;

    @FXML
    private javafx.scene.control.Label Content5;

    public static ArrayList<int[]> searchResult;
    public static Author searchAuthor;
    public static String searchType;
    public static String searchClass1;
    public static String searchClass2;


    @FXML
    private javafx.scene.control.Button LearnNewButton;

    private String getChoice(ChoiceBox<String> choiceBox) {
        String choice = choiceBox.getValue();
        return choice;
    }

    @FXML
    private javafx.scene.control.Button SearchButton;


    public SearchWindowController() {

    }

    @Override
    public void initialize(URL args0, ResourceBundle arg1) {

        PoemDetailWindow.isSearch = true;
        PoemDetailWindow.isReview = false;

        PageNumber.setText(Integer.toString(SearchWindow.currentPage));

        if (SearchWindowController.searchResult.size() >= 5 * SearchWindow.currentPage - 4) {
            if (SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 5)[0] == 0) {
                TangSongShi tangSongShi = PoemsLibrary.findShi(SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 5)[1], SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 5)[2]);
                Title1.setText(tangSongShi.getTitle());
                Author1.setText(tangSongShi.getAuthor());
                Content1.setText((tangSongShi.getParagraphs().get(0).substring(0, tangSongShi.getParagraphs().get(0).length() - 1)) + "......");

                shiORci1 = tangSongShi.shiOrCi;
                listPosition1 = tangSongShi.getListPosition();
                poemPosition1 = tangSongShi.getPositionInList();
            } else if (SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 5)[0] == 1) {
                SongCi songCi = PoemsLibrary.findCi(SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 5)[1], SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 5)[2]);
                Title1.setText(songCi.getRhythmic());
                Author1.setText(songCi.getAuthor());
                Content1.setText((songCi.getParagraphs().get(0).substring(0, songCi.getParagraphs().get(0).length() - 1)) + "......");

                shiORci1 = songCi.shiOrCi;
                listPosition1 = songCi.getListPosition();
                poemPosition1 = songCi.getPositionInList();
            }
        } else {
            Title1.setText("");
            Author1.setText("");
            Content1.setText("");

            shiORci1 = -1;
        }

        if (SearchWindowController.searchResult.size() >= 5 * SearchWindow.currentPage - 3) {
            if (SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 4)[0] == 0) {
                TangSongShi tangSongShi = PoemsLibrary.findShi(SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 4)[1], SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 4)[2]);
                Title2.setText(tangSongShi.getTitle());
                Author2.setText(tangSongShi.getAuthor());
                Content2.setText((tangSongShi.getParagraphs().get(0).substring(0, tangSongShi.getParagraphs().get(0).length() - 1)) + "......");

                shiORci2 = tangSongShi.shiOrCi;
                listPosition2 = tangSongShi.getListPosition();
                poemPosition2 = tangSongShi.getPositionInList();
            } else if (SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 4)[0] == 1) {
                SongCi songCi = PoemsLibrary.findCi(SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 4)[1], SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 4)[2]);
                Title2.setText(songCi.getRhythmic());
                Author2.setText(songCi.getAuthor());
                Content2.setText((songCi.getParagraphs().get(0).substring(0, songCi.getParagraphs().get(0).length() - 1)) + "......");

                shiORci2 = songCi.shiOrCi;
                listPosition2 = songCi.getListPosition();
                poemPosition2 = songCi.getPositionInList();
            }
        } else {
            Title2.setText("");
            Author2.setText("");
            Content2.setText("");

            shiORci2 = -1;
        }

        if (SearchWindowController.searchResult.size() >= 5 * SearchWindow.currentPage - 2) {
            if (SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 3)[0] == 0) {
                TangSongShi tangSongShi = PoemsLibrary.findShi(SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 3)[1], SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 3)[2]);
                Title3.setText(tangSongShi.getTitle());
                Author3.setText(tangSongShi.getAuthor());
                Content3.setText((tangSongShi.getParagraphs().get(0).substring(0, tangSongShi.getParagraphs().get(0).length() - 1)) + "......");

                shiORci3 = tangSongShi.shiOrCi;
                listPosition3 = tangSongShi.getListPosition();
                poemPosition3 = tangSongShi.getPositionInList();
            } else if (SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 3)[0] == 1) {
                SongCi songCi = PoemsLibrary.findCi(SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 3)[1], SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 3)[2]);
                Title3.setText(songCi.getRhythmic());
                Author3.setText(songCi.getAuthor());
                Content3.setText((songCi.getParagraphs().get(0).substring(0, songCi.getParagraphs().get(0).length() - 1)) + "......");

                shiORci3 = songCi.shiOrCi;
                listPosition3 = songCi.getListPosition();
                poemPosition3 = songCi.getPositionInList();
            }
        } else {
            Title3.setText("");
            Author3.setText("");
            Content3.setText("");

            shiORci3 = -1;
        }

        if (SearchWindowController.searchResult.size() >= 5 * SearchWindow.currentPage - 1) {
            if (SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 2)[0] == 0) {
                TangSongShi tangSongShi = PoemsLibrary.findShi(SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 2)[1], SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 2)[2]);
                Title4.setText(tangSongShi.getTitle());
                Author4.setText(tangSongShi.getAuthor());
                Content4.setText((tangSongShi.getParagraphs().get(0).substring(0, tangSongShi.getParagraphs().get(0).length() - 1)) + "......");

                shiORci4 = tangSongShi.shiOrCi;
                listPosition4 = tangSongShi.getListPosition();
                poemPosition4 = tangSongShi.getPositionInList();
            } else if (SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 2)[0] == 1) {
                SongCi songCi = PoemsLibrary.findCi(SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 2)[1], SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 2)[2]);
                Title4.setText(songCi.getRhythmic());
                Author4.setText(songCi.getAuthor());
                Content4.setText((songCi.getParagraphs().get(0).substring(0, songCi.getParagraphs().get(0).length() - 1)) + "......");

                shiORci4 = songCi.shiOrCi;
                listPosition4 = songCi.getListPosition();
                poemPosition4 = songCi.getPositionInList();
            }
        } else {
            Title4.setText("");
            Author4.setText("");
            Content4.setText("");

            shiORci4 = -1;
        }

        if (SearchWindowController.searchResult.size() >= 5 * SearchWindow.currentPage) {
            if (SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 1)[0] == 0) {
                TangSongShi tangSongShi = PoemsLibrary.findShi(SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 1)[1], SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 1)[2]);
                Title5.setText(tangSongShi.getTitle());
                Author5.setText(tangSongShi.getAuthor());
                Content5.setText((tangSongShi.getParagraphs().get(0).substring(0, tangSongShi.getParagraphs().get(0).length() - 1)) + "......");

                shiORci5 = tangSongShi.shiOrCi;
                listPosition5 = tangSongShi.getListPosition();
                poemPosition5 = tangSongShi.getPositionInList();
            } else if (SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 1)[0] == 1) {
                SongCi songCi = PoemsLibrary.findCi(SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 1)[1], SearchWindowController.searchResult.get(5 * SearchWindow.currentPage - 1)[2]);
                Title5.setText(songCi.getRhythmic());
                Author5.setText(songCi.getAuthor());
                Content5.setText((songCi.getParagraphs().get(0).substring(0, songCi.getParagraphs().get(0).length() - 1)) + "......");

                shiORci5 = songCi.shiOrCi;
                listPosition5 = songCi.getListPosition();
                poemPosition5 = songCi.getPositionInList();
            }
        } else {
            Title5.setText("");
            Author5.setText("");
            Content5.setText("");

            shiORci5 = -1;
        }


        //设置choicebox内容
        ObservableList<String> searchList1 = FXCollections.observableArrayList("作者", "标题", "正文", "tag");
        SearchClass1.setItems(searchList1);
        SearchClass1.setValue("作者");
        SearchClass2.setItems(searchList1);
        SearchClass2.setValue("作者");

        ObservableList<String> searchList2 = FXCollections.observableArrayList("与", "或");
        Relationship.setItems(searchList2);
        Relationship.setValue("或");


        //鼠标所选变灰
        poem1.setOnMouseEntered(event -> {
            if (shiORci1 != -1) {
                poem1.setStyle("-fx-background-color:#D7D7D7");
            }
        });
        poem2.setOnMouseEntered(event -> {
            if (shiORci2 != -1) {
                poem2.setStyle("-fx-background-color:#D7D7D7");
            }
        });
        poem3.setOnMouseEntered(event -> {
            if (shiORci3 != -1) {
                poem3.setStyle("-fx-background-color:#D7D7D7");
            }
        });
        poem4.setOnMouseEntered(event -> {
            if (shiORci4 != -1) {
                poem4.setStyle("-fx-background-color:#D7D7D7");
            }
        });
        poem5.setOnMouseEntered(event -> {
            if (shiORci5 != -1) {
                poem5.setStyle("-fx-background-color:#D7D7D7");
            }
        });
        poem1.setOnMouseExited(event -> {
            poem1.setStyle("-fx-background-color:#F4F4F4");
        });
        poem2.setOnMouseExited(event -> {
            poem2.setStyle("-fx-background-color:#F4F4F4");
        });
        poem3.setOnMouseExited(event -> {
            poem3.setStyle("-fx-background-color:#F4F4F4");
        });
        poem4.setOnMouseExited(event -> {
            poem4.setStyle("-fx-background-color:#F4F4F4");
        });
        poem5.setOnMouseExited(event -> {
            poem5.setStyle("-fx-background-color:#F4F4F4");
        });

        /////////////////////////////////////////////////////////////////鼠标单击诗词动作
        poem1.setOnMouseClicked(event -> {
            if (shiORci1 != -1) {
                PoemDetailWindow.isSearch = true;
                PoemDetailWindow.isReview = false;
                PoemDetailWindow.shiOrCi = shiORci1;
                PoemDetailWindow.listPosition = listPosition1;
                PoemDetailWindow.poemInList = poemPosition1;
                PoemDetailWindow poemDetailWindow = new PoemDetailWindow();
                try {
                    poemDetailWindow.showWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //关闭原来的window
                Stage stage = (Stage) poem1.getScene().getWindow();
                stage.close();
            }
        });
        poem2.setOnMouseClicked(event -> {
            if (shiORci2 != -1) {
                PoemDetailWindow.isSearch = true;
                PoemDetailWindow.isReview = false;
                PoemDetailWindow.shiOrCi = shiORci2;
                PoemDetailWindow.listPosition = listPosition2;
                PoemDetailWindow.poemInList = poemPosition2;
                PoemDetailWindow poemDetailWindow = new PoemDetailWindow();
                try {
                    poemDetailWindow.showWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //关闭原来的window
                Stage stage = (Stage) poem2.getScene().getWindow();
                stage.close();
            }

        });
        poem3.setOnMouseClicked(event -> {
            if (shiORci3 != -1) {
                PoemDetailWindow.isSearch = true;
                PoemDetailWindow.isReview = false;
                PoemDetailWindow.shiOrCi = shiORci3;
                PoemDetailWindow.listPosition = listPosition3;
                PoemDetailWindow.poemInList = poemPosition3;
                PoemDetailWindow poemDetailWindow = new PoemDetailWindow();
                try {
                    poemDetailWindow.showWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //关闭原来的window
                Stage stage = (Stage) poem3.getScene().getWindow();
                stage.close();
            }

        });
        poem4.setOnMouseClicked(event -> {
            if (shiORci4 != -1) {
                PoemDetailWindow.isSearch = true;
                PoemDetailWindow.isReview = false;
                PoemDetailWindow.shiOrCi = shiORci4;
                PoemDetailWindow.listPosition = listPosition4;
                PoemDetailWindow.poemInList = poemPosition4;
                PoemDetailWindow poemDetailWindow = new PoemDetailWindow();
                try {
                    poemDetailWindow.showWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //关闭原来的window
                Stage stage = (Stage) poem4.getScene().getWindow();
                stage.close();
            }

        });
        poem5.setOnMouseClicked(event -> {
            if (shiORci5 != -1) {
                PoemDetailWindow.isSearch = true;
                PoemDetailWindow.isReview = false;
                PoemDetailWindow.shiOrCi = shiORci5;
                PoemDetailWindow.listPosition = listPosition5;
                PoemDetailWindow.poemInList = poemPosition5;
                PoemDetailWindow poemDetailWindow = new PoemDetailWindow();
                try {
                    poemDetailWindow.showWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //关闭原来的window
                Stage stage = (Stage) poem5.getScene().getWindow();
                stage.close();
            }

        });

        LearnNewButton.setOnMouseClicked(event -> {
            PoemDetailWindow.isReview = false;
            PoemSelectWindow poemSelectWindow = new PoemSelectWindow();
            try {
                poemSelectWindow.showWindow();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //关闭原来的window
            Stage stage = (Stage) LearnNewButton.getScene().getWindow();
            stage.close();

        });


    }

    @FXML
    public void search() throws Exception {
        SearchWindowController.searchResult = new ArrayList<int[]>();
        SearchWindowController.searchAuthor = null;
        SearchWindowController.searchType = null;
        SearchWindowController.searchClass1 = null;
        SearchWindowController.searchClass2 = null;

        String searchClass1 = getChoice(SearchClass1);
        String searchClass2 = getChoice(SearchClass2);
        String relationship = getChoice(Relationship);

        String searchText1 = SearchText1.getText();
        String searchText2 = SearchText2.getText();
        System.out.println(searchText1 + " " + relationship + " " + searchText2);

        if ((searchText2.equals("") || searchText2.equals(" ") || searchText2.equals("  ")) && (searchText1.equals("") || searchText1.equals(" ") || searchText1.equals("  "))) {
            PoemSelectWindow poemSelectWindow = new PoemSelectWindow();
            poemSelectWindow.showWindow();
            Stage stage = (Stage) SearchClass2.getScene().getWindow();
            stage.close();
            return;
        } else if (searchText2.equals("") || searchText2.equals(" ") || searchText2.equals("  ")) {    // 单项搜索
            SearchWindowController.searchType = "Single";
            if (searchClass1.equals("作者")) {
                SearchWindowController.searchClass1 = "作者";
                for (int i = 0; i < ProgrammeStart.authorLibrary.size(); i++) {
                    if (ProgrammeStart.authorLibrary.get(i).name.equals(searchText1)) {
                        SearchWindowController.searchAuthor = ProgrammeStart.authorLibrary.get(i);
                        break;
                    }
                }
                if (SearchWindowController.searchAuthor != null) {
                    for (int i = 0; i < SearchWindowController.searchAuthor.tangSongShiArrayList.size(); i++) {
                        TangSongShi tangSongShi = SearchWindowController.searchAuthor.tangSongShiArrayList.get(i);
                        int[] temp = new int[]{tangSongShi.shiOrCi, tangSongShi.getListPosition(), tangSongShi.getPositionInList()};
                        SearchWindowController.searchResult.add(temp);
                    }
                    for (int i = 0; i < SearchWindowController.searchAuthor.songCiArrayList.size(); i++) {
                        SongCi songCi = SearchWindowController.searchAuthor.songCiArrayList.get(i);
                        int[] temp = new int[]{songCi.shiOrCi, songCi.getListPosition(), songCi.getPositionInList()};
                        SearchWindowController.searchResult.add(temp);
                    }
                }


            } else if (searchClass1.equals("标题")) {
                SearchWindowController.searchClass1 = "标题";
                for (int i = 0; i < ProgrammeStart.poemsLibrary.tangSongShiListCollection.size(); i++) {
                    for (int j = 0; j < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().size(); j++) {
                        int repeatTime = KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTitle(), searchText1);
                        if (repeatTime >= 1) {
                            int[] temp = new int[]{0, i, j};
                            SearchWindowController.searchResult.add(temp);
                        }
                    }
                }
                for (int i = 0; i < ProgrammeStart.poemsLibrary.songCiListCollection.size(); i++) {
                    for (int j = 0; j < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().size(); j++) {
                        int repeatTime = KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getRhythmic(), searchText1);
                        if (repeatTime >= 1) {
                            int[] temp = new int[]{1, i, j};
                            SearchWindowController.searchResult.add(temp);
                        }
                    }
                }

            } else if (searchClass1.equals("正文")) {
                SearchWindowController.searchClass1 = "正文";
                for (int i = 0; i < ProgrammeStart.poemsLibrary.tangSongShiListCollection.size(); i++) {
                    for (int j = 0; j < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().size(); j++) {
                        int repeatTime = 0;
                        for (int k = 0; k < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getParagraphs().size(); k++) {
                            repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getParagraphs().get(k), searchText1);
                        }
                        if (repeatTime >= 1) {
                            int[] temp = new int[]{ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).shiOrCi, i, j};
                            SearchWindowController.searchResult.add(temp);
                        }
                    }
                }
                for (int i = 0; i < ProgrammeStart.poemsLibrary.songCiListCollection.size(); i++) {
                    for (int j = 0; j < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().size(); j++) {
                        int repeatTime = 0;
                        for (int k = 0; k < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getParagraphs().size(); k++) {
                            repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getParagraphs().get(k), searchText1);
                        }
                        if (repeatTime >= 1) {
                            int[] temp = new int[]{ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).shiOrCi, i, j};
                            SearchWindowController.searchResult.add(temp);
                        }
                    }
                }

            } else if (searchClass1.equals("tag")) {
                SearchWindowController.searchClass1 = "tag";
                for (int i = 0; i < ProgrammeStart.poemsLibrary.tangSongShiListCollection.size(); i++) {
                    for (int j = 0; j < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().size(); j++) {
                        int repeatTime = 0;
                        if (ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTags() != null) {
                            for (int k = 0; k < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTags().size(); k++) {
                                repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTags().get(k), searchText1);
                            }
                            if (repeatTime >= 1) {
                                int[] temp = new int[]{ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).shiOrCi, i, j};
                                SearchWindowController.searchResult.add(temp);
                            }
                        }

                    }
                }
                for (int i = 0; i < ProgrammeStart.poemsLibrary.songCiListCollection.size(); i++) {
                    for (int j = 0; j < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().size(); j++) {
                        int repeatTime = 0;
                        if (ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getTags() != null) {
                            for (int k = 0; k < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getTags().size(); k++) {
                                repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getTags().get(k), searchText1);
                            }
                            if (repeatTime >= 1) {
                                int[] temp = new int[]{ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).shiOrCi, i, j};
                                SearchWindowController.searchResult.add(temp);
                            }
                        }

                    }
                }
            }
        } else {
            SearchWindowController.searchType = "double";
            if (relationship.equals("与")) {
                if (searchClass1.equals("作者")) {
                    SearchWindowController.searchClass1 = "作者";
                    for (int i = 0; i < ProgrammeStart.authorLibrary.size(); i++) {
                        if (ProgrammeStart.authorLibrary.get(i).name.equals(searchText1)) {
                            SearchWindowController.searchAuthor = ProgrammeStart.authorLibrary.get(i);
                            break;
                        }
                    }
                    if (SearchWindowController.searchAuthor != null) {
                        for (int i = 0; i < SearchWindowController.searchAuthor.tangSongShiArrayList.size(); i++) {
                            TangSongShi tangSongShi = SearchWindowController.searchAuthor.tangSongShiArrayList.get(i);
                            int[] temp = new int[]{tangSongShi.shiOrCi, tangSongShi.getListPosition(), tangSongShi.getPositionInList()};
                            SearchWindowController.searchResult.add(temp);
                        }
                        for (int i = 0; i < SearchWindowController.searchAuthor.songCiArrayList.size(); i++) {
                            SongCi songCi = SearchWindowController.searchAuthor.songCiArrayList.get(i);
                            int[] temp = new int[]{songCi.shiOrCi, songCi.getListPosition(), songCi.getPositionInList()};
                            SearchWindowController.searchResult.add(temp);
                        }
                    }


                } else if (searchClass1.equals("标题")) {
                    SearchWindowController.searchClass1 = "标题";
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.tangSongShiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().size(); j++) {
                            int repeatTime = KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTitle(), searchText1);
                            if (repeatTime >= 1) {
                                int[] temp = new int[]{0, i, j};
                                SearchWindowController.searchResult.add(temp);
                            }
                        }
                    }
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.songCiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().size(); j++) {
                            int repeatTime = KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getRhythmic(), searchText1);
                            if (repeatTime >= 1) {
                                int[] temp = new int[]{1, i, j};
                                SearchWindowController.searchResult.add(temp);
                            }
                        }
                    }

                } else if (searchClass1.equals("正文")) {
                    SearchWindowController.searchClass1 = "正文";
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.tangSongShiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().size(); j++) {
                            int repeatTime = 0;
                            for (int k = 0; k < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getParagraphs().size(); k++) {
                                repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getParagraphs().get(k), searchText1);
                            }
                            if (repeatTime >= 1) {
                                int[] temp = new int[]{ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).shiOrCi, i, j};
                                SearchWindowController.searchResult.add(temp);
                            }
                        }
                    }
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.songCiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().size(); j++) {
                            int repeatTime = 0;
                            for (int k = 0; k < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getParagraphs().size(); k++) {
                                repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getParagraphs().get(k), searchText1);
                            }
                            if (repeatTime >= 1) {
                                int[] temp = new int[]{ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).shiOrCi, i, j};
                                SearchWindowController.searchResult.add(temp);
                            }
                        }
                    }

                } else if (searchClass1.equals("tag")) {
                    SearchWindowController.searchClass1 = "tag";
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.tangSongShiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().size(); j++) {
                            int repeatTime = 0;
                            if (ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTags() != null) {
                                for (int k = 0; k < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTags().size(); k++) {
                                    repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTags().get(k), searchText1);
                                }
                                if (repeatTime >= 1) {
                                    int[] temp = new int[]{ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).shiOrCi, i, j};
                                    SearchWindowController.searchResult.add(temp);
                                }
                            }

                        }
                    }
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.songCiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().size(); j++) {
                            int repeatTime = 0;
                            if (ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getTags() != null) {
                                for (int k = 0; k < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getTags().size(); k++) {
                                    repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getTags().get(k), searchText1);
                                }
                                if (repeatTime >= 1) {
                                    int[] temp = new int[]{ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).shiOrCi, i, j};
                                    SearchWindowController.searchResult.add(temp);
                                }
                            }

                        }
                    }
                }

                if(searchClass2.equals("作者")){
                    for(int i=0; i<SearchWindowController.searchResult.size(); i++){
                        int repeatTime = 0;
                        if(SearchWindowController.searchResult.get(i)[0] == 0){
                            TangSongShi tangSongShi = PoemsLibrary.findShi(SearchWindowController.searchResult.get(i)[1], SearchWindowController.searchResult.get(i)[2]);
                            repeatTime = KMPSearch.KMPSearchTimes(tangSongShi.getAuthor(), searchText2);
                        }else if(SearchWindowController.searchResult.get(i)[0] == 1){
                            SongCi songCi = PoemsLibrary.findCi(SearchWindowController.searchResult.get(i)[1], SearchWindowController.searchResult.get(i)[2]);
                            repeatTime = KMPSearch.KMPSearchTimes(songCi.getAuthor(), searchText2);
                        }
                        if(repeatTime == 0){
                            SearchWindowController.searchResult.remove(i);
                            i -= 1;
                        }

                    }
                }else if(searchClass2.equals("标题")){
                    for(int i=0; i<SearchWindowController.searchResult.size(); i++){
                        int repeatTime = 0;
                        if(SearchWindowController.searchResult.get(i)[0] == 0){
                            TangSongShi tangSongShi = PoemsLibrary.findShi(SearchWindowController.searchResult.get(i)[1], SearchWindowController.searchResult.get(i)[2]);
                            repeatTime = KMPSearch.KMPSearchTimes(tangSongShi.getTitle(), searchText2);
                        }else if(SearchWindowController.searchResult.get(i)[0] == 1){
                            SongCi songCi = PoemsLibrary.findCi(SearchWindowController.searchResult.get(i)[1], SearchWindowController.searchResult.get(i)[2]);
                            repeatTime = KMPSearch.KMPSearchTimes(songCi.getRhythmic(), searchText2);
                        }
                        if(repeatTime == 0){
                            SearchWindowController.searchResult.remove(i);
                            i -= 1;
                        }
                    }
                }else if(searchClass2.equals("正文")){
                    for(int i=0; i<SearchWindowController.searchResult.size(); i++){
                        int repeatTime = 0;
                        if(SearchWindowController.searchResult.get(i)[0] == 0){
                            TangSongShi tangSongShi = PoemsLibrary.findShi(SearchWindowController.searchResult.get(i)[1], SearchWindowController.searchResult.get(i)[2]);
                            for(int j=0; j<tangSongShi.getParagraphs().size(); j++){
                                repeatTime += KMPSearch.KMPSearchTimes(tangSongShi.getParagraphs().get(j), searchText2);
                            }
                        }else if(SearchWindowController.searchResult.get(i)[0] == 1){
                            SongCi songCi = PoemsLibrary.findCi(SearchWindowController.searchResult.get(i)[1], SearchWindowController.searchResult.get(i)[2]);
                            for(int j=0; j<songCi.getParagraphs().size(); j++){
                                repeatTime += KMPSearch.KMPSearchTimes(songCi.getParagraphs().get(j), searchText2);
                            }
                        }
                        if(repeatTime == 0){
                            SearchWindowController.searchResult.remove(i);
                            i -= 1;
                        }
                    }

                }else if(searchClass2.equals("tag")){
                    for(int i=0; i<SearchWindowController.searchResult.size(); i++){
                        int repeatTime = 0;
                        if(SearchWindowController.searchResult.get(i)[0] == 0){
                            TangSongShi tangSongShi = PoemsLibrary.findShi(SearchWindowController.searchResult.get(i)[1], SearchWindowController.searchResult.get(i)[2]);
                            if(tangSongShi.getTags() != null){
                                for(int j=0; j<tangSongShi.getTags().size(); j++){
                                    repeatTime += KMPSearch.KMPSearchTimes(tangSongShi.getTags().get(j), searchText2);
                                }
                            }
                        }else if(SearchWindowController.searchResult.get(i)[0] == 1){
                            SongCi songCi = PoemsLibrary.findCi(SearchWindowController.searchResult.get(i)[1], SearchWindowController.searchResult.get(i)[2]);
                            if(songCi.getTags() != null){
                                for(int j=0; j<songCi.getTags().size(); j++){
                                    repeatTime += KMPSearch.KMPSearchTimes(songCi.getTags().get(j), searchText2);
                                }
                            }
                        }
                        if(repeatTime == 0){
                            SearchWindowController.searchResult.remove(i);
                            i -= 1;
                        }
                    }

                }


            } else if (relationship.equals("或")) {
                if (searchClass1.equals("作者")) {
                    SearchWindowController.searchClass1 = "作者";
                    for (int i = 0; i < ProgrammeStart.authorLibrary.size(); i++) {
                        if (ProgrammeStart.authorLibrary.get(i).name.equals(searchText1)) {
                            SearchWindowController.searchAuthor = ProgrammeStart.authorLibrary.get(i);
                            break;
                        }
                    }
                    if (SearchWindowController.searchAuthor != null) {
                        for (int i = 0; i < SearchWindowController.searchAuthor.tangSongShiArrayList.size(); i++) {
                            TangSongShi tangSongShi = SearchWindowController.searchAuthor.tangSongShiArrayList.get(i);
                            int[] temp = new int[]{tangSongShi.shiOrCi, tangSongShi.getListPosition(), tangSongShi.getPositionInList()};
                            SearchWindowController.searchResult.add(temp);
                        }
                        for (int i = 0; i < SearchWindowController.searchAuthor.songCiArrayList.size(); i++) {
                            SongCi songCi = SearchWindowController.searchAuthor.songCiArrayList.get(i);
                            int[] temp = new int[]{songCi.shiOrCi, songCi.getListPosition(), songCi.getPositionInList()};
                            SearchWindowController.searchResult.add(temp);
                        }
                    }


                } else if (searchClass1.equals("标题")) {
                    SearchWindowController.searchClass1 = "标题";
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.tangSongShiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().size(); j++) {
                            int repeatTime = KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTitle(), searchText1);
                            if (repeatTime >= 1) {
                                int[] temp = new int[]{0, i, j};
                                SearchWindowController.searchResult.add(temp);
                            }
                        }
                    }
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.songCiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().size(); j++) {
                            int repeatTime = KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getRhythmic(), searchText1);
                            if (repeatTime >= 1) {
                                int[] temp = new int[]{1, i, j};
                                SearchWindowController.searchResult.add(temp);
                            }
                        }
                    }

                } else if (searchClass1.equals("正文")) {
                    SearchWindowController.searchClass1 = "正文";
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.tangSongShiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().size(); j++) {
                            int repeatTime = 0;
                            for (int k = 0; k < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getParagraphs().size(); k++) {
                                repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getParagraphs().get(k), searchText1);
                            }
                            if (repeatTime >= 1) {
                                int[] temp = new int[]{ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).shiOrCi, i, j};
                                SearchWindowController.searchResult.add(temp);
                            }
                        }
                    }
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.songCiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().size(); j++) {
                            int repeatTime = 0;
                            for (int k = 0; k < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getParagraphs().size(); k++) {
                                repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getParagraphs().get(k), searchText1);
                            }
                            if (repeatTime >= 1) {
                                int[] temp = new int[]{ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).shiOrCi, i, j};
                                SearchWindowController.searchResult.add(temp);
                            }
                        }
                    }

                } else if (searchClass1.equals("tag")) {
                    SearchWindowController.searchClass1 = "tag";
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.tangSongShiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().size(); j++) {
                            int repeatTime = 0;
                            if (ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTags() != null) {
                                for (int k = 0; k < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTags().size(); k++) {
                                    repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTags().get(k), searchText1);
                                }
                                if (repeatTime >= 1) {
                                    int[] temp = new int[]{ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).shiOrCi, i, j};
                                    SearchWindowController.searchResult.add(temp);
                                }
                            }

                        }
                    }
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.songCiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().size(); j++) {
                            int repeatTime = 0;
                            if (ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getTags() != null) {
                                for (int k = 0; k < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getTags().size(); k++) {
                                    repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getTags().get(k), searchText1);
                                }
                                if (repeatTime >= 1) {
                                    int[] temp = new int[]{ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).shiOrCi, i, j};
                                    SearchWindowController.searchResult.add(temp);
                                }
                            }

                        }
                    }
                }


                if (searchClass2.equals("作者")) {
                    SearchWindowController.searchClass2 = "作者";
                    for (int i = 0; i < ProgrammeStart.authorLibrary.size(); i++) {
                        if (ProgrammeStart.authorLibrary.get(i).name.equals(searchText2)) {
                            for (int j = 0; j < ProgrammeStart.authorLibrary.get(i).tangSongShiArrayList.size(); j++) {
                                TangSongShi tangSongShi = ProgrammeStart.authorLibrary.get(i).tangSongShiArrayList.get(j);
                                int[] temp = new int[]{tangSongShi.shiOrCi, tangSongShi.getListPosition(), tangSongShi.getPositionInList()};
                                SearchWindowController.searchResult.add(temp);
                            }
                            for (int j = 0; j < ProgrammeStart.authorLibrary.get(i).songCiArrayList.size(); j++) {
                                SongCi songCi = ProgrammeStart.authorLibrary.get(i).songCiArrayList.get(j);
                                int[] temp = new int[]{songCi.shiOrCi, songCi.getListPosition(), songCi.getPositionInList()};
                                SearchWindowController.searchResult.add(temp);
                            }
                            break;
                        }
                    }

                } else if (searchClass2.equals("标题")) {
                    SearchWindowController.searchClass2 = "标题";
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.tangSongShiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().size(); j++) {
                            int repeatTime = KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTitle(), searchText2);
                            if (repeatTime >= 1) {
                                int[] temp = new int[]{0, i, j};
                                SearchWindowController.searchResult.add(temp);
                            }
                        }
                    }
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.songCiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().size(); j++) {
                            int repeatTime = KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getRhythmic(), searchText2);
                            if (repeatTime >= 1) {
                                int[] temp = new int[]{1, i, j};
                                SearchWindowController.searchResult.add(temp);
                            }
                        }
                    }

                } else if (searchClass2.equals("正文")) {
                    SearchWindowController.searchClass2 = "正文";
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.tangSongShiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().size(); j++) {
                            int repeatTime = 0;
                            for (int k = 0; k < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getParagraphs().size(); k++) {
                                repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getParagraphs().get(k), searchText2);
                            }
                            if (repeatTime >= 1) {
                                int[] temp = new int[]{ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).shiOrCi, i, j};
                                SearchWindowController.searchResult.add(temp);
                            }
                        }
                    }
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.songCiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().size(); j++) {
                            int repeatTime = 0;
                            for (int k = 0; k < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getParagraphs().size(); k++) {
                                repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getParagraphs().get(k), searchText2);
                            }
                            if (repeatTime >= 1) {
                                int[] temp = new int[]{ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).shiOrCi, i, j};
                                SearchWindowController.searchResult.add(temp);
                            }
                        }
                    }

                } else if (searchClass2.equals("tag")) {
                    SearchWindowController.searchClass2 = "tag";
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.tangSongShiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().size(); j++) {
                            int repeatTime = 0;
                            if (ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTags() != null) {
                                for (int k = 0; k < ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTags().size(); k++) {
                                    repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).getTags().get(k), searchText2);
                                }
                                if (repeatTime >= 1) {
                                    int[] temp = new int[]{ProgrammeStart.poemsLibrary.tangSongShiListCollection.get(i).getTangSongShi().get(j).shiOrCi, i, j};
                                    SearchWindowController.searchResult.add(temp);
                                }
                            }

                        }
                    }
                    for (int i = 0; i < ProgrammeStart.poemsLibrary.songCiListCollection.size(); i++) {
                        for (int j = 0; j < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().size(); j++) {
                            int repeatTime = 0;
                            if (ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getTags() != null) {
                                for (int k = 0; k < ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getTags().size(); k++) {
                                    repeatTime += KMPSearch.KMPSearchTimes(ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).getTags().get(k), searchText2);
                                }
                                if (repeatTime >= 1) {
                                    int[] temp = new int[]{ProgrammeStart.poemsLibrary.songCiListCollection.get(i).getSongCi().get(j).shiOrCi, i, j};
                                    SearchWindowController.searchResult.add(temp);
                                }
                            }

                        }
                    }
                }
            }
        }

        SearchWindow searchWindow = new SearchWindow();
        SearchWindow.currentPage = 1;
        searchWindow.showWindow();
        Stage stage = (Stage) SearchButton.getScene().getWindow();
        stage.close();
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
    private javafx.scene.layout.VBox poem1;

    @FXML
    private javafx.scene.layout.VBox poem2;

    @FXML
    private javafx.scene.layout.VBox poem3;

    @FXML
    private javafx.scene.layout.VBox poem4;

    @FXML
    private javafx.scene.layout.VBox poem5;

    @FXML
    private javafx.scene.control.Button previousPageButton;

    @FXML
    private javafx.scene.control.Button nextPageButton;

    @FXML
    private javafx.scene.control.Label PageNumber;


    public void nextPage() throws Exception {

        if (shiORci5 != -1 && SearchWindowController.searchResult.size() > 5 * SearchWindow.currentPage) {
            SearchWindow.currentPage += 1;
            SearchWindow searchWindow = new SearchWindow();
            searchWindow.showWindow();
            Stage stage = (Stage) nextPageButton.getScene().getWindow();
            stage.close();
        }


    }

    public void previousPage() throws Exception {
        if (SearchWindow.currentPage != 1) {
            SearchWindow.currentPage -= 1;
            SearchWindow searchWindow = new SearchWindow();
            searchWindow.showWindow();
            Stage stage = (Stage) previousPageButton.getScene().getWindow();
            stage.close();
        }

    }


}

