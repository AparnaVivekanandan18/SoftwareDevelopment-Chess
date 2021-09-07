package com.chess.pieces;

import com.chess.chessboard.IBoard;
import com.chess.pieces.interfaces.IKnightKingMoves;

public class Knight extends Piece {

    IKnightKingMoves iKnightMoves;
    int[][] possibleMovePositions = {{1, 2}, {2, 1}, {1, -2}, {-2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, -1}};

    public Knight(int initialX, int initialY, boolean isWhite, String path, IBoard board)
    {
        super(initialX, initialY, isWhite, path, board);
        iKnightMoves = new KnightKingMoves(board);
    }

    @Override
    public boolean validMove(int destinationX, int destinationY)
    {
        Piece piece = board.getPiece(destinationX, destinationY);

        boolean isDifferentColorPiece = differentColourPiece(this, piece);
        boolean isLShapeMovement = iKnightMoves.validMovement(this, destinationX, destinationY,possibleMovePositions);

        if(isDifferentColorPiece && isLShapeMovement)
        {
            return true;
        }
        return false;
    }
}

