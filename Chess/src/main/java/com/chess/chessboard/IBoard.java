package com.chess.chessboard;

import com.chess.pieces.Piece;

import java.util.Map;

public interface IBoard {

    Piece getActivePiece();
    Piece getPiece(int x,int y);
    void chessMovement(int x,int y);
    void removeBlackPieceFromBoard(Piece removePiece);
    void addBlackPieceToBoard(Piece addPiece);
    void removeWhitePieceFromBoard(Piece removePiece);
    void addWhitePieceToBoard(Piece addPiece);
    boolean inCheck();
    Board.Winner getResult();
    Map<String, String> getPositions();
    String isKingInCheck();
    String getActivePieceFilePath();
}
