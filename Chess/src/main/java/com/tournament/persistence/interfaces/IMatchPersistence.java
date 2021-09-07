package com.tournament.persistence.interfaces;

import com.tournament.model.IMatch;
import com.tournament.model.Match;

import java.util.List;

public interface IMatchPersistence {
    void saveMatch(IMatch match);

    List<Match> getAllMatch();

    Match getMatchById(int matchId);

    void updateMatch(Match match, int matchId);

    void deleteMatch(int matchId);
}
