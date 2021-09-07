package com.chess.chessboard;

import com.chess.pieces.*;
import com.chess.pieces.abstractfactory.ConcretePieceFactory;
import com.chess.pieces.abstractfactory.AbstractPieceFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Board implements IBoard {

    public ArrayList<Piece> blackPieces;
    public ArrayList<Piece> whitePieces;
    public Piece activePiece;
    private int turn = 0;
    boolean whiteTurn = true;
    Winner winner;

    public enum Winner {
        WHITEWINNER,
        BLACKWINNER
    }

    public Board()
    {
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();

        AbstractPieceFactory.setFactory(new ConcretePieceFactory());
        AbstractPieceFactory factory = AbstractPieceFactory.instance();

        whitePieces.add(factory.createKing(0, 3, true, "WK", this));
        whitePieces.add(factory.createQueen(0, 4, true, "WQ", this));
        whitePieces.add(factory.createKnight(0, 1, true, "WK", this));
        whitePieces.add(factory.createKnight(0, 6, true, "WK", this));
        whitePieces.add(factory.createBishop(0, 2, true, "WB", this));
        whitePieces.add(factory.createBishop(0, 5, true, "WB", this));
        whitePieces.add(factory.createRook(0, 0, true, "WR", this));
        whitePieces.add(factory.createRook(0, 7, true, "WR", this));
        whitePieces.add(factory.createPawn(1, 0, true, "WP", this));
        whitePieces.add(factory.createPawn(1, 1, true, "WP", this));
        whitePieces.add(factory.createPawn(1, 2, true, "WP", this));
        whitePieces.add(factory.createPawn(1, 3, true, "WP", this));
        whitePieces.add(factory.createPawn(1, 4, true, "WP", this));
        whitePieces.add(factory.createPawn(1, 5, true, "WP", this));
        whitePieces.add(factory.createPawn(1, 6, true, "WP", this));
        whitePieces.add(factory.createPawn(1, 7, true, "WP", this));

        blackPieces.add(factory.createKing(7, 3, false, "BK", this));
        blackPieces.add(factory.createQueen(7, 4, false, "BQ", this));
        blackPieces.add(factory.createKnight(7, 1, false, "BK", this));
        blackPieces.add(factory.createKnight(7, 6, false, "BK", this));
        blackPieces.add(factory.createBishop(7, 2, false, "BB", this));
        blackPieces.add(factory.createBishop(7, 5, false, "BB", this));
        blackPieces.add(factory.createRook(7, 0, false, "BR", this));
        blackPieces.add(factory.createRook(7, 7, false, "BR", this));
        blackPieces.add(factory.createPawn(6, 0, false, "BP", this));
        blackPieces.add(factory.createPawn(6, 1, false, "BP", this));
        blackPieces.add(factory.createPawn(6, 2, false, "BP", this));
        blackPieces.add(factory.createPawn(6, 3, false, "BP", this));
        blackPieces.add(factory.createPawn(6, 4, false, "BP", this));
        blackPieces.add(factory.createPawn(6, 5, false, "BP", this));
        blackPieces.add(factory.createPawn(6, 6, false, "BP", this));
        blackPieces.add(factory.createPawn(6, 7, false, "BP", this));
    }

    public String checkNull(Piece piece)
    {
        if (piece == null)
        {
            return "";
        }
        else
        {
            return piece.getFilePath();
        }
    }

    @Override
    public Map<String, String> getPositions()
    {
        Map<String, String> currentPositions = new HashMap<>();
        currentPositions.put("{0,0}", checkNull(this.getPiece(0, 0)));
        currentPositions.put("{0,1}", checkNull(this.getPiece(0, 1)));
        currentPositions.put("{0,2}", checkNull(this.getPiece(0, 2)));
        currentPositions.put("{0,3}", checkNull(this.getPiece(0, 3)));
        currentPositions.put("{0,4}", checkNull(this.getPiece(0, 4)));
        currentPositions.put("{0,5}", checkNull(this.getPiece(0, 5)));
        currentPositions.put("{0,6}", checkNull(this.getPiece(0, 6)));
        currentPositions.put("{0,7}", checkNull(this.getPiece(0, 7)));

        currentPositions.put("{1,0}", checkNull(this.getPiece(1, 0)));
        currentPositions.put("{1,1}", checkNull(this.getPiece(1, 1)));
        currentPositions.put("{1,2}", checkNull(this.getPiece(1, 2)));
        currentPositions.put("{1,3}", checkNull(this.getPiece(1, 3)));
        currentPositions.put("{1,4}", checkNull(this.getPiece(1, 4)));
        currentPositions.put("{1,5}", checkNull(this.getPiece(1, 5)));
        currentPositions.put("{1,6}", checkNull(this.getPiece(1, 6)));
        currentPositions.put("{1,7}", checkNull(this.getPiece(1, 7)));

        currentPositions.put("{2,0}", checkNull(this.getPiece(2, 0)));
        currentPositions.put("{2,1}", checkNull(this.getPiece(2, 1)));
        currentPositions.put("{2,2}", checkNull(this.getPiece(2, 2)));
        currentPositions.put("{2,3}", checkNull(this.getPiece(2, 3)));
        currentPositions.put("{2,4}", checkNull(this.getPiece(2, 4)));
        currentPositions.put("{2,5}", checkNull(this.getPiece(2, 5)));
        currentPositions.put("{2,6}", checkNull(this.getPiece(2, 6)));
        currentPositions.put("{2,7}", checkNull(this.getPiece(2, 7)));

        currentPositions.put("{3,0}", checkNull(this.getPiece(3, 0)));
        currentPositions.put("{3,1}", checkNull(this.getPiece(3, 1)));
        currentPositions.put("{3,2}", checkNull(this.getPiece(3, 2)));
        currentPositions.put("{3,3}", checkNull(this.getPiece(3, 3)));
        currentPositions.put("{3,4}", checkNull(this.getPiece(3, 4)));
        currentPositions.put("{3,5}", checkNull(this.getPiece(3, 5)));
        currentPositions.put("{3,6}", checkNull(this.getPiece(3, 6)));
        currentPositions.put("{3,7}", checkNull(this.getPiece(3, 7)));

        currentPositions.put("{4,0}", checkNull(this.getPiece(4, 0)));
        currentPositions.put("{4,1}", checkNull(this.getPiece(4, 1)));
        currentPositions.put("{4,2}", checkNull(this.getPiece(4, 2)));
        currentPositions.put("{4,3}", checkNull(this.getPiece(4, 3)));
        currentPositions.put("{4,4}", checkNull(this.getPiece(4, 4)));
        currentPositions.put("{4,5}", checkNull(this.getPiece(4, 5)));
        currentPositions.put("{4,6}", checkNull(this.getPiece(4, 6)));
        currentPositions.put("{4,7}", checkNull(this.getPiece(4, 7)));

        currentPositions.put("{5,0}", checkNull(this.getPiece(5, 0)));
        currentPositions.put("{5,1}", checkNull(this.getPiece(5, 1)));
        currentPositions.put("{5,2}", checkNull(this.getPiece(5, 2)));
        currentPositions.put("{5,3}", checkNull(this.getPiece(5, 3)));
        currentPositions.put("{5,4}", checkNull(this.getPiece(5, 4)));
        currentPositions.put("{5,5}", checkNull(this.getPiece(5, 5)));
        currentPositions.put("{5,6}", checkNull(this.getPiece(5, 6)));
        currentPositions.put("{5,7}", checkNull(this.getPiece(5, 7)));

        currentPositions.put("{6,0}", checkNull(this.getPiece(6, 0)));
        currentPositions.put("{6,1}", checkNull(this.getPiece(6, 1)));
        currentPositions.put("{6,2}", checkNull(this.getPiece(6, 2)));
        currentPositions.put("{6,3}", checkNull(this.getPiece(6, 3)));
        currentPositions.put("{6,4}", checkNull(this.getPiece(6, 4)));
        currentPositions.put("{6,5}", checkNull(this.getPiece(6, 5)));
        currentPositions.put("{6,6}", checkNull(this.getPiece(6, 6)));
        currentPositions.put("{6,7}", checkNull(this.getPiece(6, 7)));

        currentPositions.put("{7,0}", checkNull(this.getPiece(7, 0)));
        currentPositions.put("{7,1}", checkNull(this.getPiece(7, 1)));
        currentPositions.put("{7,2}", checkNull(this.getPiece(7, 2)));
        currentPositions.put("{7,3}", checkNull(this.getPiece(7, 3)));
        currentPositions.put("{7,4}", checkNull(this.getPiece(7, 4)));
        currentPositions.put("{7,5}", checkNull(this.getPiece(7, 5)));
        currentPositions.put("{7,6}", checkNull(this.getPiece(7, 6)));
        currentPositions.put("{7,7}", checkNull(this.getPiece(7, 7)));

        return currentPositions;
    }

    @Override
    public Piece getPiece(int x, int y)
    {
        Iterator<Piece> whiteIter = whitePieces.iterator();
        Iterator<Piece> blackIter = blackPieces.iterator();

        while(whiteIter.hasNext())
        {
            Piece p = whiteIter.next();
            if(p.getPositionX()==x && p.getPositionY()==y)
            {
                return p;
            }
        }
        while(blackIter.hasNext())
        {
            Piece p = blackIter.next();
            if(p.getPositionX()==x && p.getPositionY()==y)
            {
                return p;
            }
        }
        return null;
    }

    @Override
    public Piece getActivePiece()
    {
        return activePiece;
    }

    @Override
    public void removeBlackPieceFromBoard(Piece removePiece)
    {
        blackPieces.remove(removePiece);
    }

    @Override
    public void addBlackPieceToBoard(Piece addPiece)
    {
        blackPieces.add(addPiece);
    }

    @Override
    public void removeWhitePieceFromBoard(Piece removePiece)
    {
        whitePieces.remove(removePiece);
    }

    @Override
    public void addWhitePieceToBoard(Piece addPiece)
    {
        blackPieces.add(addPiece);
    }

    @Override
    public void chessMovement(int clickedX,int clickedY)
    {
        whiteTurn = true;
        Piece clickedPiece = getPiece(clickedX,clickedY);

        if ((turn % 2) == 1) {
            whiteTurn = false;
        }

        if(activePiece==null && clickedPiece != null)
        {
            setActivePiece(clickedPiece);
        }

        else if(activePiece != null)
        {
            movePiece(clickedX,clickedY);
        }

    }

    private void setActivePiece(Piece clickedPiece)
    {
        boolean isWhiteTurn = (whiteTurn && clickedPiece.isWhite());
        boolean isBlackTurn = (!whiteTurn && clickedPiece.isBlack());

        if(isWhiteTurn||isBlackTurn)
        {
            activePiece = clickedPiece;
        }
    }

    private void movePiece(int clickedX, int clickedY)
    {
        Piece clickPiece = getPiece(clickedX,clickedY);
        boolean validPieceMovePosition = activePiece.validMove(clickedX,clickedY);
        boolean isWhiteTurn = (whiteTurn && activePiece.isWhite());
        boolean isBlackTurn = (!whiteTurn && activePiece.isBlack());

        if(validPieceMovePosition && (isWhiteTurn || isBlackTurn))
        {
            if(clickPiece != null)
            {
                if(clickPiece.isWhite())
                {
                    if(clickPiece.getClass().equals(King.class))
                    {
                        setResult(Winner.BLACKWINNER);
                    }
                    whitePieces.remove(clickPiece);
                }
                else{
                    if(clickPiece.getClass().equals(King.class))
                    {
                        setResult(Winner.WHITEWINNER);
                    }
                    blackPieces.remove(clickPiece);
                }
            }

            activePiece.setPositionX(clickedX);
            activePiece.setPositionY(clickedY);

            if(activePiece.getClass().equals(Pawn.class))
            {
                Pawn pawn = (Pawn) activePiece;
                pawn.setIsFirstMove(true);
                if(pawn.isPawnPromotion())
                {
                    if(pawn.isWhite())
                    {
                        whitePieces.remove(pawn);
                        whitePieces.add(new Queen(clickedX,clickedY,true,"WQ",this));
                    }
                    if(pawn.isBlack())
                    {
                        blackPieces.remove(pawn);
                        blackPieces.add(new Queen(clickedX,clickedY,true,"BQ",this));
                    }
                }

            }

            activePiece = null;
            turn++;
        }
    }

    @Override
    public String isKingInCheck(){
        if (inCheck()){
            return "King is in Check";
        } else {
            return "";
        }
    }

    @Override
    public String getActivePieceFilePath(){
        if(this.getActivePiece()!=null){
            return this.getActivePiece().getFilePath();
        }else {
            return "";
        }
    }

    @Override
    public boolean inCheck()
    {
        Piece kingReference = null;
        int column = 8;
        int row = 8;
        if(whiteTurn)
        {
            for(int i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    Piece isKing = getPiece(i,j);
                    if(isKing != null)
                    {
                        if(isKing.isWhite() && (isKing.getClass().equals(King.class)))
                        {
                            kingReference = isKing;
                        }
                    }

                }
            }

            for(int i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    Piece pieceReference = getPiece(i,j);
                    if(pieceReference!=null)
                    {
                        if(pieceReference.isBlack() && pieceReference.validMove(kingReference.getPositionX(), kingReference.getPositionY()))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        else
        {
            for(int i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    Piece isKing = getPiece(i,j);
                    if(isKing != null)
                    {
                        if((isKing.getClass().equals(King.class)) && isKing.isBlack())
                        {
                            kingReference = isKing;
                        }
                    }
                }
            }

            for(int i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    Piece pieceReference = getPiece(i,j);
                    if(pieceReference != null)
                    {
                        if(pieceReference.isWhite() && pieceReference.validMove(kingReference.getPositionX(), kingReference.getPositionY()))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Winner getResult()
    {
        return winner;
    }

    public void setResult(Winner w)
    {
        winner = w;
    }
}
