package com.chess.piecestest;
import static org.junit.Assert.*;
import com.chess.chessboard.Board;
import com.chess.chessboard.IBoard;
import com.chess.pieces.Bishop;
import com.chess.pieces.interfaces.IBishop;
import org.junit.After;
import org.junit.Test;

public class BishopTest {

    IBoard board = new Board();

    @Test
    public void sameAllyTest() {
        IBishop bishop = new Bishop(0, 1, true, "WB", board);
        assertFalse(bishop.validMove(0, 2));
    }

    @Test
    public void diagonalMovementTest() {
        IBishop bishop = new Bishop(0, 0, true, "WB", board);
        assertFalse(bishop.validMove(1, 1));
    }

    @Test
    public void simpleTest() {
        IBishop bishop = new Bishop(1, 1, true, "WB", board);
        assertTrue(bishop.validMove(3, 3));
    }

    @Test
    public void invalidMoveTest() {
        IBishop bishop = new Bishop(1, 1, true, "WB", board);
        assertFalse(bishop.validMove(2, 3));
    }

    @Test
    public void straightTest() {
        IBishop bishop = new Bishop(1, 1, true, "WB", board);
        assertFalse(bishop.validMove(2, 1));
    }

    @After
    public void destroy() {
        board = null;
    }
}
