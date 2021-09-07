package com.tournament.persistence.factory;

import com.tournament.persistence.interfaces.IMatchPersistence;
import com.tournament.persistence.interfaces.IPlayerPersistence;
import com.tournament.persistence.interfaces.ITournamentPersistence;

public abstract class TournamentAbstractPersistenceFactory
{

    public abstract IMatchPersistence getMatchPersistence();

    public abstract IPlayerPersistence getPlayerPersistence();

    public abstract ITournamentPersistence getTournamentPersistence();
}
