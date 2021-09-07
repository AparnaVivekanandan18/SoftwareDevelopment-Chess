package com.tournament.model;

import com.chess.chessboard.IBoard;

public interface IMatch {

    int getMatchId();

    void setMatchId(int matchId);

    String getPlayer1id();

    void setPlayer1id(String player1id);

    String getPlayer2id();

    void setPlayer2id(String player2id);

    String getStartTime();

    void setStartTime(String startTime);

    String getEndTime();

    void setEndTime(String endTime);

    int getTournamentId();

    void setTournamentId(int tournamentId);

    String getMatchWinner();

    void setMatchWinner(String matchWinner);

    void createBoard();

    IBoard getBoard();
}
