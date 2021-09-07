package com.chess.pieces;

import com.chess.chessboard.IBoard;
import com.chess.pieces.interfaces.IBishopMoves;

public class BishopMoves implements IBishopMoves {

    public IBoard board;

    public BishopMoves(IBoard board) {
        this.board = board;
    }

    @Override
    public Boolean diagonalMovement(Piece currentPiece,int destinationX, int destinationY) {
        int diffX = Math.abs(destinationX - currentPiece.getPositionX());
        int diffY = Math.abs(destinationY - currentPiece.getPositionY());

        return diffX == diffY;
    }

    @Override
    public Boolean checkIfPieceNotInBetween(Piece currentPiece,int destinationX, int destinationY) {
        int directionSignX = Integer.signum(destinationX - currentPiece.getPositionX());
        int directionSignY = Integer.signum(destinationY - currentPiece.getPositionY());

        if (directionSignX > 0 && directionSignY > 0) {
            int spaces_in_between = Math.abs(currentPiece.getPositionY() - destinationY) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(currentPiece.getPositionX() + i, currentPiece.getPositionY() + i);
                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignX > 0 && directionSignY < 0) {
            int spaces_in_between = Math.abs(destinationX - currentPiece.getPositionX()) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(currentPiece.getPositionX() + i, currentPiece.getPositionY() - i);
                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignX < 0 && directionSignY < 0) {
            int spaces_in_between = Math.abs(destinationY - currentPiece.getPositionY()) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {

                Piece p = board.getPiece(currentPiece.getPositionX() - i, currentPiece.getPositionY() - i);
                if (p != null) {
                    return false;
                }
            }
        }

        if (directionSignX > 0 && directionSignY < 0) {
            int spaces_in_between = Math.abs(currentPiece.getPositionX() - destinationX) - 1;
            for (int i = 1; i <= spaces_in_between; i++) {
                Piece p = board.getPiece(currentPiece.getPositionX() + i, currentPiece.getPositionY() - i);
                if (p != null) {
                    return false;
                }
            }
        }

        return true;
    }

}
