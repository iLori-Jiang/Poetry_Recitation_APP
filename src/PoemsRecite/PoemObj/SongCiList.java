package PoemsRecite.PoemObj;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SongCiList {

    @SerializedName("SongCi")
    @Expose
    private List<SongCi> songCi = new ArrayList<SongCi>();

    public List<SongCi> getSongCi() {
return songCi;
}

    public void setSongCi(List<SongCi> songCi) {
this.songCi = songCi;
}

}