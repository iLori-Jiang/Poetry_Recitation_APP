package PoemsRecite.UserInformation;

import java.util.ArrayList;

public class UserLibrary {
    public static ArrayList<User> users;

    public UserLibrary(){
        users = new ArrayList<User>();
    }


    public void clearLibrary(){
        users.clear();
    }
}
