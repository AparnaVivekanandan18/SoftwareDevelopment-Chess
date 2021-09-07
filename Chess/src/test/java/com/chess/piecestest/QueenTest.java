package com.chess.piecestest;

import com.chess.chessboard.Board;
import com.chess.chessboard.IBoard;
import com.chess.pieces.Bishop;
import com.chess.pieces.BishopMoves;
import com.chess.pieces.Piece;
import com.chess.pieces.interfaces.IBishopMoves;
import com.chess.pieces.interfaces.IQueen;
import com.chess.pieces.Queen;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueenTest {

    IBoard board = new Board();

    @Test
    public void sameAllyTest() {
        IQueen queen = new Queen(1, 1, true, "BQ", board);
        assertFalse(queen.validMove(1, 2));
    }

    @Test
    public void checkNullMovementTest() {
        IQueen queen = new Queen(1, 1, true, "BQ", board);
        assertNull(board.getPiece(2, 2));
        assertTrue(queen.validMove(2, 2));
    }

    @Test
    public void straightMovementTest() {
        IQueen queen = new Queen(0, 4, true, "BQ", board);
        assertFalse(queen.validMove(1, 4));
    }

    @Test
    public void horizontalMovementTest() {
        IQueen queen = new Queen(0, 4, true, "BQ", board);
        assertFalse(queen.validMove(0, 5));
    }

    @Test
    public void diagonalMovementTest() {
        IQueen queen = new Queen(5, 5, true, "BQ", board);
        assertTrue(queen.validMove(6, 6));
    }

    @Test
    public void diagonalNorthEastMovementTest() {
        IQueen queen = new Queen(3, 2, true, "BQ", board);
        assertTrue(queen.validMove(2, 3));
    }

    @Test
    public void diagonalNorthWestMovementTest() {
        IBishopMoves bishopMoves = new BishopMoves(board);
        Piece bishop = new Bishop(3,2, true, "WB", board);
        assertEquals(true, bishopMoves.diagonalMovement(bishop, 2, 1));
    }

    @Test
    public void diagonalSouthEastMovementTest() {
        IBishopMoves bishopMoves = new BishopMoves(board);
        Piece bishop = new Bishop(3,2, true, "WB", board);
        assertEquals(true, bishopMoves.diagonalMovement(bishop, 4, 1));
    }

    @Test
    public void diagonalSouthWestMovementTest() {
        IBishopMoves bishopMoves = new BishopMoves(board);
        Piece bishop = new Bishop(3,2, true, "WB", board);
        assertEquals(true, bishopMoves.diagonalMovement(bishop, 4, 3));
    }

    @Test
    public void IsPieceInBetweenTest() {
        IQueen queen = new Queen(0, 4, true, "BQ", board);
        assertFalse(queen.validMove(2, 2));
    }

    @After
    public void destroy() {
        board = null;
    }

}
