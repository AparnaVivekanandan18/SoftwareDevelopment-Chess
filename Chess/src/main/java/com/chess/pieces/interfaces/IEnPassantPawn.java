package com.chess.pieces.interfaces;

import com.chess.pieces.Piece;

public interface IEnPassantPawn
{
    boolean checkEnPassantCapturingWhite(Piece currentPiece, int previousMovedBlackX, int previousMovedBlackY );
    boolean checkEnPassantCapturingBlack(Piece currentPiece,int previousMovedWhiteX, int previousMovedWhiteY );
}
