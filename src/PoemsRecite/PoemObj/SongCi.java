package PoemsRecite.PoemObj;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SongCi {
    public int shiOrCi = 1;
    private int listPosition;
    private int positionInList;

    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("paragraphs")
    @Expose
    private List<String> paragraphs = null;
    @SerializedName("rhythmic")
    @Expose
    private String rhythmic;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public String getRhythmic() {
        return rhythmic;
    }

    public void setRhythmic(String rhythmic) {
        this.rhythmic = rhythmic;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getListPosition() {
        return listPosition;
    }

    public void setListPosition(int listPosition) {
        this.listPosition = listPosition;
    }

    public int getPositionInList() {
        return positionInList;
    }

    public void setPositionInList(int positionInList) {
        this.positionInList = positionInList;
    }
}