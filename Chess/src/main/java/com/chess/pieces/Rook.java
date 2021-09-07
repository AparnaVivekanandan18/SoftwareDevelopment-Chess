package com.chess.pieces;

import com.chess.chessboard.IBoard;
import com.chess.pieces.interfaces.IRookMoves;

public class Rook extends Piece {

    IRookMoves rookMoves;

    public Rook(int x, int y, boolean isWhite, String path, IBoard board)
    {
        super(x, y, isWhite, path, board);
        rookMoves = new RookMoves(board);
    }

    @Override
    public boolean validMove(int destinationX, int destinationY)
    {
        Piece piece = board.getPiece(destinationX, destinationY);

        boolean isDifferentColourPiece = differentColourPiece(this, piece);
        boolean isStraightMovement = rookMoves.straightMovement(this, destinationX, destinationY);
        boolean isPieceNotInBetween = rookMoves.checkPieceNotInBetween(this, destinationX, destinationY);

        if (isDifferentColourPiece && isStraightMovement && isPieceNotInBetween)
        {
            return true;
        }
        return false;
    }
}
