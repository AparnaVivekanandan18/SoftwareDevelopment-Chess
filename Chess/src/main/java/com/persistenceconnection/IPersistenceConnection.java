package com.persistenceconnection;

import java.sql.Connection;

public interface IPersistenceConnection
{
    String connectionUrl = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_12_TEST?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String username = "CSCI5308_12_TEST_USER";
    String password = "Fv297LbSgareuWQf";

    Connection establishDBConnection();
}
