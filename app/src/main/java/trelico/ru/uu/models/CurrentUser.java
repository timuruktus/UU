package trelico.ru.uu.models;


import com.google.gson.annotations.SerializedName;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class CurrentUser extends User{


    @ColumnInfo(name = "user_token")
    @SerializedName("user-token")
    private String userToken;

    public CurrentUser(String email, String name, String role, boolean isLeader, String userToken){
        super(email, name, role, isLeader);
        this.userToken = userToken;
    }

    public CurrentUser(){
    }

    public String getUserToken(){
        return userToken;
    }

    public void setUserToken(String userToken){
        this.userToken = userToken;
    }
}
