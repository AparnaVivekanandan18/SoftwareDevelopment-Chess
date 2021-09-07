package com.chess.piecestest;

import com.chess.chessboard.Board;
import com.chess.chessboard.IBoard;
import com.chess.pieces.Pawn;
import com.chess.pieces.Piece;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PawnTest {
    IBoard board = new Board();
    private boolean HasMoved;

    @Test
    void validFirstMoveOneStepBlackPawnTest()
    {
        Pawn blackActivePawn= new Pawn(6,1,false,"", board);
        int targetX=5;
        int targetY=1;
        Assertions.assertEquals(true,blackActivePawn.validMove(targetX,targetY));
    }

    @Test
    void validFirstMoveTwoStepBlackPawnTest()
    {
        Pawn blackActivePawn = new Pawn(6,1,false,"", board);
        int targetX=4;
        int targetY=1;
        Assertions.assertEquals(true,blackActivePawn.validMove(targetX,targetY));
    }

    @Test
    void validMoveOneStepBlackPawnTest()
    {
        Piece activePiece = new Pawn(4,1,false,"", board);
        Pawn blackActivePawn=(Pawn)activePiece;
        boolean setHasMoved = true;
        blackActivePawn.setIsFirstMove(setHasMoved);
        HasMoved = blackActivePawn.getIsFirstMove();
        int targetX=3;
        int targetY=1;
        Assertions.assertEquals(true,blackActivePawn.validMove(targetX,targetY));
    }

    @Test
    void validFirstMoveOneStepWhitePawnTest()
    {
        Pawn whiteActivePawn= new Pawn(1,5,true,"", board);
        int targetX=2;
        int targetY=5;
        Assertions.assertEquals(true,whiteActivePawn.validMove(targetX,targetY));
    }

    @Test
    void validFirstMoveTwoStepWhitePawnTest()
    {
        Pawn whiteActivePawn = new Pawn(1,0,true,"", board);
        int targetX=3;
        int targetY=0;
        Assertions.assertEquals(true,whiteActivePawn.validMove(targetX,targetY));
    }

    @Test
    void validMoveOneStepWhitePawnTest()
    {
        Pawn whiteActivePawn = new Pawn(4,1,true,"", board);
        boolean setHasMoved = true;
        whiteActivePawn.setIsFirstMove(setHasMoved);
        HasMoved = whiteActivePawn.getIsFirstMove();
        int targetX=5;
        int targetY=1;
        Assertions.assertEquals(true,whiteActivePawn.validMove(targetX,targetY));
    }

    @Test
    void invalidTwoStepMoveWhitePawnTest()
    {
        Pawn whiteActivePawn= new Pawn(3,1,true,"", board);
        boolean setHasMoved = true;
        whiteActivePawn.setIsFirstMove(setHasMoved);
        HasMoved = whiteActivePawn.getIsFirstMove();
        int targetX=5;
        int targetY=1;
        Assertions.assertEquals(false,whiteActivePawn.validMove(targetX,targetY));
    }

    @Test
    void invalidTwoStepMoveBlackPawnTest()
    {
        Pawn blackActivePawn = new Pawn(5,2,false,"", board);
        boolean setHasMoved = true;
        blackActivePawn.setIsFirstMove(setHasMoved);
        HasMoved = blackActivePawn.getIsFirstMove();
        int targetX=3;
        int targetY=2;
        Assertions.assertEquals(false,blackActivePawn.validMove(targetX,targetY));
    }

    @Test
    void invalidRandomPawnMovement()
    {
        Pawn blackActivePawn = new Pawn(5,2,false,"", board);
        boolean setHasMoved = true;
        blackActivePawn.setIsFirstMove(setHasMoved);
        HasMoved = blackActivePawn.getIsFirstMove();
        int targetX=3;
        int targetY=7;
        Assertions.assertEquals(false,blackActivePawn.validMove(targetX,targetY));
    }

    @Test
    void blackPawnPromotionTest()
    {
        Pawn blackActivePawn = new Pawn(0,0,false,"", board);
        boolean setHasMoved = true;
        Assertions.assertEquals(true,blackActivePawn.isPawnPromotion());
    }

    @After
    public void destroy()
    {
        board = null;
    }
}
