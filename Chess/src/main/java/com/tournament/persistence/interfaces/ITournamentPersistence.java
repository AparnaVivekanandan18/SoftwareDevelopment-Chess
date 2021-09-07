package com.tournament.persistence.interfaces;


import com.tournament.model.Player;

public interface ITournamentPersistence {
    public void loadPlayer(Player player, int tournamentid);
}
