package com.authenticationtest;
import com.authentication.services.Authentication;
import com.authentication.model.Users;
import com.authentication.persistence.interfaces.IAuthenticationPersistence;
import com.authentication.model.IUsers;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.*;
import java.sql.SQLException;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationTest
{
    Authentication authenticationObj;
    IUsers userObject;
    public AuthenticationTest()
    {
        authenticationObj = new Authentication();
        userObject = new Users();
    }

    @Mock
    IAuthenticationPersistence authenticatePersistenceObj;

    @Test
    public void userAuthenticationTest() throws SQLException
    {
        authenticationObj.setAuthenticatePersistenceObj(authenticatePersistenceObj);
        userObject.setUserId("aparna99");
        userObject.setPassword("67b9fb104dd2baa240b253da25dc4d39");

        when(authenticatePersistenceObj.loadUser("aparna99")).thenReturn(userObject);
        when(authenticatePersistenceObj.updateUser(any(),any(),any())).thenReturn("Login Successful");
        String userId = userObject.getUserId();
        String password = "xyz@";
        Assertions.assertEquals("Login Successful",authenticationObj.userAuthentication(userId,password));
    }

    @After
    public void destroy()
    {
        authenticationObj = null;
        userObject = null;
    }

}

