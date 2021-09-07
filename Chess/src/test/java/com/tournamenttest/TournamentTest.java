package com.tournamenttest;

import com.tournament.model.Player;
import com.tournament.model.Tournament;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;

public class TournamentTest {

    TournamentMock tournamentMock = new TournamentMock();
    Tournament tournament;

    @Test
    void getpossiblePairsOddTest() {
        ArrayList<Player> players = new ArrayList();
        tournamentMock.oddTournamentMock();
        players=tournamentMock.getPlayers();
        tournament = new Tournament(players);
        Assertions.assertEquals(3,tournament.getPossiblePairs(players));
    }

    @Test
    void getpossiblePairsEvenTest() {
        ArrayList<Player> players = new ArrayList();
        tournamentMock.evenTournamentMock();
        players=tournamentMock.getPlayers();
        tournament = new Tournament(players);
        Assertions.assertEquals(3,tournament.getPossiblePairs(players));
    }

    @Test
    void getPlayerSize() {
        ArrayList<Player> players = new ArrayList();
        tournamentMock.evenTournamentMock();
        players=tournamentMock.getPlayers();
        tournament = new Tournament(players);
        Assertions.assertEquals(6,tournament.getPlayerSize(players));
    }

    @Test
    void pairingTest() {
        ArrayList<Player> players = new ArrayList();
        HashMap<Player, Player> mockPairPlayers = new HashMap<Player, Player>();
        HashMap<Player, Player> pairPlayers = new HashMap<Player, Player>();
        HashMap<String, String> Pairs = new HashMap<String, String>();
        HashMap<String, String> mockPairs = new HashMap<String, String>();
        tournamentMock.evenTournamentMock();
        players = tournamentMock.getPlayers();
        tournament = new Tournament(players);
        mockPairPlayers = tournamentMock.getPairs();
        pairPlayers=tournament.pairing(players);

       for(Player mockPlayerkeys:mockPairPlayers.keySet())
        {
            mockPairs.put(mockPlayerkeys.getPlayerName(),mockPairPlayers.get(mockPlayerkeys).getPlayerName());
        }

        for(Player playerkeys:pairPlayers.keySet())
        {
            Pairs.put(playerkeys.getPlayerName(),pairPlayers.get(playerkeys).getPlayerName());
        }
        Assertions.assertEquals(Pairs,mockPairs);
    }

    @Test
    void matchCreation(){
        MatchMock[] matchmock;
        ArrayList<Player> players = new ArrayList();
        HashMap<Player, Player> mockPairPlayers = new HashMap<Player, Player>();
        tournamentMock.evenTournamentMock();
        players = tournamentMock.getPlayers();
        mockPairPlayers = tournamentMock.getPairs();
        int i=0;
        ArrayList<Player> nextRoundPlayers = new ArrayList<>();
        matchmock = new MatchMock[3];
        for(Player mockPlayerkeys:mockPairPlayers.keySet())
        {
            matchmock[i] = new MatchMock(mockPlayerkeys,mockPairPlayers.get(mockPlayerkeys));
            i++;
        }
        for(int j=0; j<mockPairPlayers.size() ;j++)
        {
            nextRoundPlayers.add(matchmock[j].getWinner());
        }
        Assertions.assertEquals(3,nextRoundPlayers.size());
    }

    @Test
    void evenSchedulingTest()
    {
        ArrayList<Player> players = new ArrayList();
        ArrayList<Player> nextRoundPlayers;
        tournamentMock.evenTournamentMock();
        players = tournamentMock.getPlayers();
        tournament = new Tournament(players);
        int numPairs=tournament.getPossiblePairs(players);
        nextRoundPlayers=tournament.evenScheduling(numPairs,players);
        Assertions.assertEquals(3,nextRoundPlayers.size());
    }

    @Test
    void oddSchedulingTest()
    {
        ArrayList<Player> players = new ArrayList();
        ArrayList<Player> nextRoundPlayers;
        tournamentMock.oddTournamentMock();
        players = tournamentMock.getPlayers();
        tournament = new Tournament(players);
        int numPairs=tournament.getPossiblePairs(players);
        nextRoundPlayers=tournament.oddScheduling(numPairs,players);
        Assertions.assertEquals(4,nextRoundPlayers.size());
    }

    @After
    public void destroy()
    {
        tournamentMock = null;
        tournament = null;
    }
}
