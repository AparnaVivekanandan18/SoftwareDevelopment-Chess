package com.authentication.services.interfaces;
import com.authentication.model.Users;
import java.sql.SQLException;
import java.util.List;

public interface IAuthentication
{
    String userAuthentication(String inputUserName, String inputPassword) throws SQLException;
    String userLogOut(String userId) throws SQLException;
    List<Users> getAllUsers() throws SQLException;
}
