package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLogged {
    @Expose
    private boolean success;
    @Expose
    private String token;
    @Expose
    private String message;
    @Expose
    private UserData data;

}
