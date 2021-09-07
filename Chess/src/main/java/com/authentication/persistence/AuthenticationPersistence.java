package com.authentication.persistence;

import com.authentication.model.IUsers;
import com.authentication.persistence.interfaces.IAuthenticationPersistence;
import com.persistenceconnection.PersistenceConnection;
import com.persistenceconnection.IPersistenceConnection;
import com.authentication.model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationPersistence implements IAuthenticationPersistence
{
    IPersistenceConnection conObj = new PersistenceConnection();
    IUsers userObject = new Users();
    Connection connection = null;

    private String message;
    ResultSet resultSet;
    private PreparedStatement statement;
    private int updateUserSessionFlag;

    private String getUserIdQuery = "SELECT * from User WHERE userId=?";
    private String updateSessionLoginTimeQuery= "UPDATE User SET sessionFlag=?,LoginTime=? WHERE userId=?";
    private String updateSessionLogoutQuery= "UPDATE User SET sessionFlag=? WHERE userId=?";

    public AuthenticationPersistence()
    {
        updateUserSessionFlag = 0;
        message = null;
        resultSet = null;
        statement = null;
    }

    public IUsers loadUser(String inputUserId) throws SQLException
    {
        try
        {
            connection = conObj.establishDBConnection();
            statement = connection.prepareStatement(getUserIdQuery);
            statement.setString(1,inputUserId);
            resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                userObject.setUserId(resultSet.getString(2));
                userObject.setPassword(resultSet.getString(5));
            }
            connection.close();
        }
        catch (SQLException E)
        {
            System.out.println("Some Error !" + E);
            connection.close();
        }
        return userObject;
    }

    public String updateUser(String inputUserId,String inputPassword,String loginTime) throws SQLException
    {
        try
        {
            updateUserSessionFlag = 1;
            connection = conObj.establishDBConnection();
            statement = connection.prepareStatement(updateSessionLoginTimeQuery);
            statement.setInt(1, updateUserSessionFlag);
            statement.setString(2, loginTime);
            statement.setString(3, inputUserId);
            statement.executeUpdate();
            connection.close();
            return "Login Successful";
        }
        catch (SQLException E)
        {
            System.out.println("Some Error !" + E);
            connection.close();
            return "Update Error";
        }
    }

    public String logOut(String currentActiveUser) throws SQLException
    {
        String activeUser = currentActiveUser;
        int updateUserSessionFlag = 0;

        try {
            connection = conObj.establishDBConnection();
            statement = connection.prepareStatement(updateSessionLogoutQuery);
            statement.setInt(1, updateUserSessionFlag);
            statement.setString(2, activeUser);
            statement.executeUpdate();
            message = "LogoutSuccessful";
            connection.close();
            return message;
        }
        catch (Exception E)
        {
            System.out.println("Some Error !" + E);
            connection.close();
            return message;
        }
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> nameList = new ArrayList<>();
        try {
            connection = conObj.establishDBConnection();
            String getAllUsersQuery= "SELECT * from User";
            statement = connection.prepareStatement(getAllUsersQuery);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setUserId(rs.getString("userId"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPlayerLevel(rs.getInt("playerLevel"));
                user.setPassword(rs.getString("password"));
                user.setUserSessionFlag(rs.getInt("sessionFlag"));
                user.setActiveInTournament(rs.getInt("activeTournament"));
                user.setLoginTime(rs.getString("LoginTime"));

                nameList.add(user);
            }
            return nameList;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
