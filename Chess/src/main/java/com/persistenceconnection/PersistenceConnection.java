package com.persistenceconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class PersistenceConnection implements IPersistenceConnection
{

    public Connection establishDBConnection()  {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(connectionUrl, username, password);
        }
        catch(Exception E)
        {
            System.out.println("Connection Error !" +E);
        }
        return connection;
    }
}