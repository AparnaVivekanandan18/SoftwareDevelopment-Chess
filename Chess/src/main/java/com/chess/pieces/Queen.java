package com.chess.pieces;

import com.chess.chessboard.IBoard;
import com.chess.pieces.interfaces.IBishopMoves;
import com.chess.pieces.interfaces.IQueen;
import com.chess.pieces.interfaces.IRookMoves;
import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece implements IQueen {

    IBishopMoves bishopMoves;
    IRookMoves rookMoves;

    public Queen(int initialX, int initialY, boolean isWhite, String filepath, IBoard board) {
        super(initialX, initialY, isWhite, filepath, board);
        bishopMoves = new BishopMoves(board);
        rookMoves = new RookMoves(board);
    }

    @Override
    public boolean validMove(int finalCordX, int finalCordY) {

        List<Boolean> validationConditionList = new ArrayList<>();
        Piece piece = board.getPiece(finalCordX, finalCordY);

        validationConditionList.add(differentColourPiece(this, piece));
        validationConditionList.add(rookMoves.straightMovement(this, finalCordX, finalCordY) || bishopMoves.diagonalMovement(this, finalCordX, finalCordY));
        validationConditionList.add(rookMoves.checkPieceNotInBetween(this, finalCordX, finalCordY) || bishopMoves.checkIfPieceNotInBetween(this, finalCordX, finalCordY));

        for (Boolean isConditionSatisfied : validationConditionList) {
            if (!isConditionSatisfied) {
                return false;
            }
        }
        return true;
    }
}
