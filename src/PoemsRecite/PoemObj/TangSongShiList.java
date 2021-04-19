package PoemsRecite.PoemObj;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TangSongShiList {

@SerializedName("TangSongShi")
@Expose
private List<TangSongShi> tangSongShi = new ArrayList<TangSongShi>();

public List<TangSongShi> getTangSongShi() {
return tangSongShi;
}

public void setTangSongShi(List<TangSongShi> tangSongShi) {
this.tangSongShi = tangSongShi;
}


}