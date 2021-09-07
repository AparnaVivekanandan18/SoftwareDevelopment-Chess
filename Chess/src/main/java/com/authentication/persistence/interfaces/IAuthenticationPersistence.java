package com.authentication.persistence.interfaces;
import com.authentication.model.IUsers;
import com.authentication.model.Users;
import java.sql.SQLException;
import java.util.List;

public interface IAuthenticationPersistence
{
     IUsers loadUser(String inputUserId) throws SQLException;
     String updateUser(String inputUserId,String inputPassword,String loginTime) throws SQLException;
     String logOut(String currentActiveUser) throws SQLException;
     List<Users> getAllUsers() throws SQLException;
}
