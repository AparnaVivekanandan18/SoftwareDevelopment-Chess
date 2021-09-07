package com.tournamenttest;

import com.tournament.model.FormTournamentGroups;
import com.tournament.model.Player;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class FormTournamentGroupsTest
{
    int numOfUsersActive = 0;
    FormTournamentGroups formTournamentGroupsObj = new FormTournamentGroups();

    private Player createPlayer(String playerName)
    {
        Player p = new Player();
        p.setPlayerName(playerName);
        return p;
    }

    @Test
    public void formSubTournamentGroupsTest() throws Exception {

        ArrayList<Player> Playerlist = new ArrayList<>();
        Playerlist.add(createPlayer("Sravanni"));
        Playerlist.add(createPlayer("Aparna"));
        Playerlist.add(createPlayer("Darshil"));
        Playerlist.add(createPlayer("Pathik"));
        Playerlist.add(createPlayer("Kethan"));
        Playerlist.add(createPlayer("Rob"));
        Playerlist.add(createPlayer("hendry"));
        int i = 5;
        for (Player p : Playerlist)
        {
            numOfUsersActive = numOfUsersActive + 1;
            p.setPlayerLevel(i % 3 + 1);
            Integer temp = 10 + i;
            p.setPlayerId(temp.toString());
            i = i + 1;
        }

        ArrayList<ArrayList> tournamentList = formTournamentGroupsObj.formSubTournamentGroups(Playerlist);
        Assertions.assertEquals(1,tournamentList.size());

    }

    @After
    public void destroy()
    {
        formTournamentGroupsObj = null;
    }
}
