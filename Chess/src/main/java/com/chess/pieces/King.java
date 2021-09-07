package com.chess.pieces;

import com.chess.chessboard.IBoard;
import com.chess.pieces.interfaces.IKnightKingMoves;

public class King extends Piece{

    IKnightKingMoves iKingMoves;
    int[][] possibleMovePositions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

    public King(int initialX, int initialY, boolean isWhite, String path, IBoard board)
    {
        super(initialX, initialY, isWhite, path, board);
        iKingMoves = new KnightKingMoves( board);
    }

    @Override
    public boolean validMove(int destinationX, int destinationY)
    {
        Piece piece = board.getPiece(destinationX, destinationY);

        boolean isDifferentColorPiece = differentColourPiece(this, piece);
        boolean isOneStepMovement = iKingMoves.validMovement(this, destinationX, destinationY,possibleMovePositions);

        if(isDifferentColorPiece && isOneStepMovement)
        {
            return true;
        }
        return false;
    }
}
