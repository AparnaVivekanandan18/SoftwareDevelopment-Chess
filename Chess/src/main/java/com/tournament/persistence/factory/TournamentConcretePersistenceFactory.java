package com.tournament.persistence.factory;

import com.tournament.persistence.MatchPersistence;
import com.tournament.persistence.PlayerPersistence;
import com.tournament.persistence.TournamentPersistence;
import com.tournament.persistence.interfaces.IMatchPersistence;
import com.tournament.persistence.interfaces.IPlayerPersistence;
import com.tournament.persistence.interfaces.ITournamentPersistence;

public class TournamentConcretePersistenceFactory extends TournamentAbstractPersistenceFactory {

    @Override
    public IMatchPersistence getMatchPersistence()
    {
        return new MatchPersistence();
    }

    @Override
    public IPlayerPersistence getPlayerPersistence()
    {
        return new PlayerPersistence();
    }

    @Override
    public ITournamentPersistence getTournamentPersistence()
    {
        return new TournamentPersistence();
    }
}
