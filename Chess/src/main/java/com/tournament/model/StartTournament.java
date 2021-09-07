package com.tournament.model;
import com.tournament.persistence.factory.TournamentAbstractPersistenceFactory;
import com.tournament.persistence.factory.TournamentConcretePersistenceFactory;
import com.tournament.persistence.interfaces.IPlayerPersistence;
import java.util.ArrayList;

public class StartTournament
{
    public void initialise()
    {
        TournamentAbstractPersistenceFactory tournamentAbstractPersistenceFactoryObj = new TournamentConcretePersistenceFactory();
        IPlayerPersistence playerPersistenceObj = tournamentAbstractPersistenceFactoryObj.getPlayerPersistence();
        ArrayList<Player> playerList = playerPersistenceObj.loadAllPlayers();
        playerPersistenceObj.saveAllPlayers(playerList);
        FormTournamentGroups groupobj = new FormTournamentGroups();
        ArrayList<ArrayList> tournamentList = groupobj.formSubTournamentGroups(playerList);
        
        for(int i=0 ;i<tournamentList.size();i++)
        {
            Tournament invokeTournament = new Tournament(tournamentList.get(i));
            invokeTournament.organizingTournament(tournamentList.get(i));
        }
    }
}

