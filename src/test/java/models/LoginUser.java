package models;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class LoginUser {
    @Expose
    private String email;
    @Expose
    private String password;
    @Expose
    private String userType;


}

