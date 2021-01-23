package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserData {
    @Expose
    @SerializedName("_id")
    private String id;
    @Expose
    private String email;
    @Expose
    private String fullName;
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String userType;
    @Expose
    private String picture;

}
