package com.chess.piecestest;

import com.chess.chessboard.Board;
import com.chess.chessboard.IBoard;
import com.chess.pieces.Knight;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnightTest {

    IBoard board = new Board();
    @Test
    void ValidMoveTest() {
        Knight knight = new Knight(5,4,true,"path",board);
        Assertions.assertEquals(true,knight.validMove(3,3));
    }
    @Test
    void ValidMoveNegativeTest() {
        Knight knight = new Knight(5,4,true,"path",board);
        Assertions.assertNotEquals(true,knight.validMove(3,6));
    }
    @Test
    void ValidMoveExclusionsTest(){
        Knight knight = new Knight(3,0,true,"path",board);
        Assertions.assertEquals(true,knight.validMove(5,1));
    }
    @Test
    void ValidMoveExclusionsNegativeTest(){
        Knight knight = new Knight(3,0,true,"path",board);
        Assertions.assertNotEquals(true,knight.validMove(3,-1));
    }
    @After
    public void destroy()
    {
        board=null;
    }
}