package com.tournamenttest;

import com.tournament.model.Player;
import java.util.ArrayList;
import java.util.HashMap;

public class TournamentMock {
    private final ArrayList<Player> Players = new ArrayList<>();;
    private final HashMap<Player, Player> pairs = new HashMap<Player,Player>();

   private Player createPlayer(String playerName)
   {
       Player player = new Player();
       player.setPlayerName(playerName);
       return player;
   }
    public void evenTournamentMock()
    {
        Players.add(createPlayer("Sravani"));
        Players.add(createPlayer("Aparna"));
        Players.add(createPlayer("Darshil"));
        Players.add(createPlayer("Pathik"));
        Players.add(createPlayer("Kethan"));
        Players.add(createPlayer("Rob"));
        pairs.put(createPlayer("Sravani"),createPlayer("Aparna"));
        pairs.put(createPlayer("Darshil"),createPlayer("Pathik"));
        pairs.put(createPlayer("Kethan"),createPlayer("Rob"));
    }
    public void oddTournamentMock()
    {
        Players.add(createPlayer("Sravani"));
        Players.add(createPlayer("Aparna"));
        Players.add(createPlayer("Darshil"));
        Players.add(createPlayer("Pathik"));
        Players.add(createPlayer("Kethan"));
        Players.add(createPlayer("Rob"));
        Players.add(createPlayer("Rashmika"));
        pairs.put(createPlayer("Sravani"),createPlayer("Aparna"));
        pairs.put(createPlayer("Darshil"),createPlayer("Pathik"));
        pairs.put(createPlayer("Kethan"),createPlayer("Rob"));
    }

    public ArrayList<Player> getPlayers() {
        return Players;
    }

    public HashMap<Player,Player> getPairs()
    {
        return pairs;
    }
}
