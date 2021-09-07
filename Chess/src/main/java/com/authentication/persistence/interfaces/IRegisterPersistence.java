package com.authentication.persistence.interfaces;
import com.authentication.model.Users;
import java.sql.SQLException;

public interface IRegisterPersistence
{
    String saveUserDetails(Users userObj) throws SQLException;
}
