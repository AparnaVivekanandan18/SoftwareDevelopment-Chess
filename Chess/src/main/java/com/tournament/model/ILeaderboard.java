package com.tournament.model;

import java.util.List;

public interface ILeaderboard {
    List<Player> getLeaderboard(int tournamentId);
}
