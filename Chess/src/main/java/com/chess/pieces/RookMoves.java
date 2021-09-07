package com.chess.pieces;

import com.chess.chessboard.IBoard;
import com.chess.pieces.interfaces.IRookMoves;

public class RookMoves implements IRookMoves {

    public IBoard board;
    public RookMoves(IBoard board)
    {
        this.board = board;
    }

    @Override
    public boolean straightMovement(Piece currentPiece, int destinationX, int destinationY)
    {
        return (currentPiece.getPositionX() == destinationX) || (currentPiece.getPositionY() == destinationY);
    }

    @Override
    public boolean checkPieceNotInBetween(Piece currentPiece, int destinationX, int destinationY)
    {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();

        int directionSignX = Integer.signum(destinationX - currentX);
        int directionSignY = Integer.signum(destinationY - currentY);

        if (directionSignX > 0)
        {
            int spaceToMove = Math.abs(destinationX - currentX);
            for (int i = 1; i < spaceToMove; i++)
            {
                Piece p = board.getPiece(currentX + i, currentY);
                if (p != null)
                {
                    return false;
                }
            }
        }

        if (directionSignX < 0)
        {
            int spaceToMove = Math.abs(destinationX - currentX);
            for (int i = 1; i < spaceToMove; i++)
            {
                Piece p = board.getPiece(currentX - i, currentY);
                if (p != null)
                {
                    return false;
                }
            }
        }

        if (directionSignY > 0)
        {
            int spaceToMove = Math.abs(destinationY - currentY);
            for (int i = 1; i < spaceToMove; i++)
            {
                Piece p = board.getPiece(currentX, currentY + i);
                if (p != null)
                {
                    return false;
                }
            }
        }

        if (directionSignY < 0)
        {
            int spaceToMove = Math.abs(destinationY - currentY);
            for (int i = 1; i < spaceToMove; i++)
            {
                Piece p = board.getPiece(currentX, currentY - i);
                if (p != null)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
