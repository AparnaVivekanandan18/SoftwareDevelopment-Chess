package com.authenticationtest;
import com.authentication.model.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsersTest
{
    private String Email;
    private String UserId;
    private String password;
    private String  conPassword;
    private int UserSessionFlag;

    private String actualEmail;
    private String actualUserId;
    private String actualpassword;
    private String  actualconPassword;
    private int actualUserSessionFlag;

    @Test
    public void userTest()
    {
        Users userObj = new Users();
        Email = "apar@g.com";
        UserId = "apar02";
        password = "abcd";
        conPassword = "abcd";
        UserSessionFlag = 1;

        userObj.setEmail(Email);
        userObj.setUserId(UserId);
        userObj.setPassword(password);
        userObj.setConPassword(conPassword);
        userObj.setUserSessionFlag(UserSessionFlag);

        actualEmail = userObj.getEmail();
        actualUserId = userObj.getUserId();
        actualpassword = userObj.getPassword();
        actualconPassword = userObj.getConPassword();
        actualUserSessionFlag = userObj.getUserSessionFlag();

        Assertions.assertEquals(actualEmail,Email);
        Assertions.assertEquals(actualUserId,UserId);
        Assertions.assertEquals(actualpassword,password);
        Assertions.assertEquals(actualconPassword,conPassword);
        Assertions.assertEquals(actualUserSessionFlag,UserSessionFlag);

    }
}
