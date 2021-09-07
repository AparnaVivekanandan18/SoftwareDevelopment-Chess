package com.chess.pieces.interfaces;

import com.chess.chessboard.IBoard;
import com.chess.pieces.Piece;

public interface ICaptureMovePawn
{
    void initialiseValues(Piece currentPiece, int destinationX, int destinationY, IBoard boardobj);
    boolean cornerWhitePawnAttack(Piece currentPiece);
    boolean whitePawnAttack(Piece currentPiece);

    boolean cornerBlackPawnAttack(Piece currentPiece);
    boolean blackPawnAttack(Piece currentPiece);

}
