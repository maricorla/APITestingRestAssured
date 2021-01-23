package tests;

import adapters.UsersAdapter;
import models.LoginUser;
import models.User;
import models.UserLogged;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InstallTtest extends BaseTest{


    @Test(description = "Alternative signup")
    public void alternativeSignUp() {

        User user = new User("Ma", "Fa", "nhivnn@gmail.com", "qwerty", "qwerty", "2", true, true);
        UsersAdapter userAdapter = new UsersAdapter();
        boolean isUserCreated = userAdapter.signUp(user);
        Assert.assertTrue(isUserCreated,"User is not created");

    }

    @Test
    public void successLogin(){
        LoginUser loginUser = new LoginUser("hodes35739@rvemold.com","123456","2");
        UsersAdapter usersAdapter= new UsersAdapter();
        UserLogged loggedUser= usersAdapter.loginUser(loginUser);
        String id = loggedUser.getData().getId();
        Assert.assertEquals(id,"5fb534e0d4d44353da8aab22");

    }
}
