package com.chess.piecestest;

import com.chess.chessboard.Board;
import com.chess.pieces.interfaces.IEnPassantPawn;
import com.chess.pieces.EnPassantPawn;
import com.chess.pieces.Pawn;
import com.chess.pieces.Piece;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnPassantPawnTest
{
    Board board = new Board();
    IEnPassantPawn enPassantPawnObj = new EnPassantPawn();

    private int previousMovedBlackX;
    private int previousMovedBlackY;

    @Test
    void checkEnPassantCapturingWhiteTest()
    {
        Piece blackPiece = board.getPiece(6,3);
        board.removeBlackPieceFromBoard(blackPiece);
        board.addBlackPieceToBoard(new Pawn(4,3,false,"",board));
        Piece whitePiece = board.getPiece(1,2);
        board.removeWhitePieceFromBoard(whitePiece);
        board.addWhitePieceToBoard(new Pawn(4,2,true,"",board));
        Piece currentPiecePosition = board.getPiece(4,2);
        previousMovedBlackX = 4;
        previousMovedBlackY = 3;
        Assertions.assertEquals(true,enPassantPawnObj.checkEnPassantCapturingWhite(currentPiecePosition,previousMovedBlackX,previousMovedBlackY));
    }

    @Test
    void checkEnPassantCapturingBlackTest()
    {
        Piece blackPiece = board.getPiece(6,5);
        board.removeBlackPieceFromBoard(blackPiece);
        board.addBlackPieceToBoard(new Pawn(3,5,false,"",board));
        Piece whitePiece = board.getPiece(1,4);
        board.removeWhitePieceFromBoard(whitePiece);
        board.addWhitePieceToBoard(new Pawn(3,4,true,"",board));
        Piece currentPiecePosition = board.getPiece(3,5);
        previousMovedBlackX = 3;
        previousMovedBlackY = 4;
        Assertions.assertEquals(true,enPassantPawnObj.checkEnPassantCapturingBlack(currentPiecePosition,previousMovedBlackX,previousMovedBlackY));
    }

    @After
    public void destroy()
    {
        enPassantPawnObj = null;
    }
}
