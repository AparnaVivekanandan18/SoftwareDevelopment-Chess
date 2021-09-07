package com.authentication.services.interfaces;
import com.authentication.model.Users;
import java.sql.SQLException;

public interface IRegister
{
    String userRegistration(Users userobj) throws SQLException;
}
