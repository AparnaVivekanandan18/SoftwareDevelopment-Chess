package com.chess.piecestest;

import com.chess.chessboard.Board;
import com.chess.chessboard.IBoard;
import com.chess.pieces.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnightMovesTest {
    int[][] possibleKnightMovePositions = {{1, 2}, {2, 1}, {1, -2}, {-2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, -1}};
    int[][] possibleKingMovePositions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};
    IBoard board = new Board();

    @Test
    public void knightValidMovementTest() {
        Knight knight = new Knight(5, 4, true, "", board);
        KnightKingMoves knightMoves = new KnightKingMoves(board);
        int destinationX=3;
        int destinationY=3;
        Assertions.assertEquals(true, knightMoves.validMovement(knight, destinationX, destinationY,possibleKnightMovePositions));
    }
    @Test
    public void knightValidMovementNegativeTest() {
        Knight knight = new Knight(5, 4, true, "", board);
        KnightKingMoves knightMoves = new KnightKingMoves( board);
        int destinationX=3;
        int destinationY=4;
        Assertions.assertEquals(false, knightMoves.validMovement(knight, destinationX, destinationY,possibleKnightMovePositions));
    }
    @Test
    void knightValidMovementExclusionsTest(){
        Knight knight = new Knight(3,0,true,"path",board);
        KnightKingMoves knightMoves = new KnightKingMoves( board);
        Assertions.assertEquals(true,knightMoves.validMovement(knight,5,1,possibleKnightMovePositions));
    }
    @Test
    void knightValidMovementExclusionsNegativeTest(){
        Knight knight = new Knight(3,0,true,"path",board);
        KnightKingMoves knightMoves = new KnightKingMoves(board);
        Assertions.assertNotEquals(true,knightMoves.validMovement(knight,3,-1,possibleKnightMovePositions));
    }
    @Test
    public void kingValidMovementTest() {
        King king = new King(5, 4, true, "", board);
        KnightKingMoves kingMoves = new KnightKingMoves( board);
        Assertions.assertEquals(true, kingMoves.validMovement(king, 4, 3,possibleKingMovePositions));
    }
    @Test
    public void kingValidMovementNegativeTest() {
        King king = new King(5, 4, true, "", board);
        KnightKingMoves kingMoves = new KnightKingMoves( board);
        Assertions.assertEquals(false, kingMoves.validMovement(king, 3, 6,possibleKingMovePositions));
    }
    @Test
    void kingValidMovementExclusionsTest(){
        King king = new King(3,0,true,"path",board);
        KnightKingMoves kingMoves = new KnightKingMoves( board);
        Assertions.assertEquals(true,kingMoves.validMovement(king,3,1,possibleKingMovePositions));
    }
    @Test
    void kingValidMovementExclusionsNegativeTest(){
        King king = new King(3,0,true,"path",board);
        KnightKingMoves kingMoves = new KnightKingMoves(board);
        Assertions.assertNotEquals(true,kingMoves.validMovement(king,3,-1,possibleKingMovePositions));
    }

}
