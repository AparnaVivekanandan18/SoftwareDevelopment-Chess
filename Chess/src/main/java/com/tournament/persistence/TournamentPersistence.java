package com.tournament.persistence;

import com.tournament.model.Player;
import com.tournament.persistence.interfaces.ITournamentPersistence;
import com.persistenceconnection.*;

import java.sql.*;
import java.text.SimpleDateFormat;

public class TournamentPersistence implements ITournamentPersistence{

    IPersistenceConnection conPersistence = new PersistenceConnection();
    Connection connection = null;
    private PreparedStatement preparedStatement = null;
    Player winner;

    @Override
    public void loadPlayer(Player player, int tournamentid)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String query = "INSERT INTO Tournament(tournament,dateOfTournament,winner) VALUES (?,?,?)";

        try
        {
            connection = conPersistence.establishDBConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,tournamentid);
            preparedStatement.setString(2,player.getPlayerName());
            preparedStatement.setString(3, dateFormat.format(timestamp));
            preparedStatement.executeUpdate();
            connection.close();
        }

        catch(Exception E)
        {
            System.out.println("Something Went Wrong !" +E);
        }

        finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
