package com.tournament.persistence.interfaces;

import com.tournament.model.Player;

import java.util.ArrayList;
import java.util.List;

public interface IPlayerPersistence {
    public void savePlayer(Player player);
    public ArrayList<Player> loadAllPlayers();
    public void saveAllPlayers(ArrayList<Player> playerList);

    List<Player> getLeaderboard(int tournamentId);
}
