package com.tournament.services;
import com.tournament.model.IMatch;
import com.tournament.persistence.factory.TournamentAbstractPersistenceFactory;
import com.tournament.persistence.factory.TournamentConcretePersistenceFactory;
import com.tournament.persistence.interfaces.IMatchPersistence;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MatchService implements IMatchService {

    @Override
    public void saveMatch(IMatch iMatch){
        Date currentDate = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        String startTime = timeFormat.format(currentDate);

        TournamentAbstractPersistenceFactory tournamentAbstractPersistenceFactoryObj = new TournamentConcretePersistenceFactory();
        IMatchPersistence matchPersistenceObj = tournamentAbstractPersistenceFactoryObj.getMatchPersistence();
        iMatch.setStartTime(startTime);
        matchPersistenceObj.saveMatch(iMatch);
    }

}
