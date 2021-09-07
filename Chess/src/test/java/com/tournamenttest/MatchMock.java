package com.tournamenttest;

import com.tournament.model.Player;

public class MatchMock{

    Player player1;
    Player player2;

    public MatchMock(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    public Player getWinner() {
        return player1;
    }
}
