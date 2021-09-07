package com.chess.pieces.interfaces;

import com.chess.pieces.Piece;

public interface IKnightKingMoves {

    boolean validMovement(Piece currentPiece, int destinationX, int destinationY, int[][] possibleMovePositions);
}
