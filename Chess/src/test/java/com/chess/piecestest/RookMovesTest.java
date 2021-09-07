package com.chess.piecestest;

import com.chess.chessboard.Board;
import com.chess.chessboard.IBoard;
import com.chess.pieces.Piece;
import com.chess.pieces.Rook;
import com.chess.pieces.RookMoves;
import com.chess.pieces.interfaces.IRookMoves;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RookMovesTest {

    IBoard board = new Board();

    @Test
    public void StraightMovementTest()
    {
        Piece whiteRook = new Rook(0,0,true,"", board);
        IRookMoves rookMove = new RookMoves(board);
        int targetX=5;
        int targetY=0;
        Assertions.assertEquals(true,rookMove.straightMovement(whiteRook,targetX,targetY));
    }

    @Test
    public void checkPieceNotInBetweenTest()
    {
        Rook whiteRook = new Rook(0,0,true,"", board);
        RookMoves rookMove = new RookMoves(board);
        int targetX=3;
        int targetY=0;
        Assertions.assertEquals(false,rookMove.checkPieceNotInBetween(whiteRook,targetX,targetY));
        Piece whitePawn = board.getPiece(1,0);
        board.removeWhitePieceFromBoard(whitePawn);
        Assertions.assertEquals(true,rookMove.checkPieceNotInBetween(whiteRook,targetX,targetY));
    }

    @After
    public void destroy()
    {
        board = null;
    }
}
