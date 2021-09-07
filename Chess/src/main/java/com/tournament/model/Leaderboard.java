package com.tournament.model;

import com.tournament.persistence.PlayerPersistence;
import com.tournament.persistence.interfaces.IPlayerPersistence;
import java.util.List;

public class Leaderboard implements ILeaderboard {

    @Override
    public List<Player> getLeaderboard(int tournamentId) {

        List<Player> playerList = null;
        try {
            IPlayerPersistence playerPersistence = new PlayerPersistence();
            playerList = playerPersistence.getLeaderboard(tournamentId);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return playerList;
    }

}
