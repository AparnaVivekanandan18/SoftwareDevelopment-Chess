package com.authentication.model;

import java.sql.Time;

public interface IUsers
{
    String getEmail();
    void setEmail(String email);

    String getUserId();
    void setUserId(String userId);

    String getUsername();
    void setUsername(String username);

    int getPlayerLevel();
    void setPlayerLevel(int playerLevel);

    String getPassword();
    void setPassword(String password);

    String getConPassword();
    void setConPassword(String conPassword);

    int getUserSessionFlag();
    void setUserSessionFlag(int userSessionFlag);

    int getActiveInTournament();
    void setActiveInTournament(int activeInTournament);

    String getLoginTime();
    void setLoginTime(String loginTime);

}
