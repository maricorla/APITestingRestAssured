package models;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String email;
    @Expose
    private String password;
    @Expose
    private String confirmPassword;
    @Expose
    private String userType;
    @SerializedName("acceptedPNP")
    @Expose
    private boolean privacy;
    @SerializedName("acceptedCC")
    @Expose
    private boolean cookies;


}
