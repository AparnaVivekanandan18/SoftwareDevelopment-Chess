package com.chess.chessboardtest;

import com.chess.chessboard.Board;
import com.chess.chessboard.IBoard;
import com.chess.pieces.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void getPieceTest()
    {
        IBoard board = new Board();
        Piece piece = board.getPiece(0,3);
        Assertions.assertTrue(piece instanceof King);
        Assertions.assertEquals(0,piece.getPositionX());
        Assertions.assertEquals(3,piece.getPositionY());
    }

    @Test
    public void setActivePieceTest()
    {
        IBoard board = new Board();
        Piece whiteQueen = board.getPiece(0,4);
        board.chessMovement(0,4);
        Assertions.assertEquals(whiteQueen,board.getActivePiece());
    }

    @Test
    public void movePieceTest()
    {
        IBoard board = new Board();
        board.chessMovement(1,0);
        board.chessMovement(2,0);
        Assertions.assertEquals(null,board.getActivePiece());
        Piece blackRook = board.getPiece(7,0);
        board.chessMovement(7,0);
        board.chessMovement(5,0);
        Assertions.assertEquals(blackRook,board.getActivePiece());
    }

    @Test
    public void movePieceKnightTest()
    {
        IBoard board = new Board();
        board.chessMovement(0,1);
        board.chessMovement(2,2);
        Assertions.assertEquals(null,board.getActivePiece());
    }

    @Test
    public void inCheckTest()
    {
        IBoard board = new Board();
        board.chessMovement(0,1);
        board.chessMovement(2,2);
        board.chessMovement(6,2);
        board.chessMovement(5,2);
        board.chessMovement(1,4);
        board.chessMovement(3,4);
        Assertions.assertEquals(false,board.inCheck());
    }

    @Test
    public void inCheckTest1()
    {
        IBoard board = new Board();
        Piece blackPawn = board.getPiece(6,3);
        board.removeBlackPieceFromBoard(blackPawn);
        Piece whiteRook = new Rook(6,3,true,"",board);
        board.addWhitePieceToBoard(whiteRook);
        board.chessMovement(0,1);
        board.chessMovement(2,2);
        board.chessMovement(6,1);
        Assertions.assertEquals(true,board.inCheck());
    }

    @Test
    public void pawnPromotionTest()
    {
        IBoard board = new Board();
        Piece blackPawn = board.getPiece(6,6);
        board.removeBlackPieceFromBoard(blackPawn);
        Piece blackKnight = board.getPiece(7,6);
        board.removeBlackPieceFromBoard(blackKnight);
        Piece whitePawn = new Pawn(6,6,true,"",board);
        board.addWhitePieceToBoard(whitePawn);
        board.chessMovement(6,6);
        board.chessMovement(7,6);
        Piece isQueen = board.getPiece(7,6);
        boolean checkIsQueen = isQueen.getClass().equals(Queen.class);
        Assertions.assertEquals(true,checkIsQueen);
    }
}
