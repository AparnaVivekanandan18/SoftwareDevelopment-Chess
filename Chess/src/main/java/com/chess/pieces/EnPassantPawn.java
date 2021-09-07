package com.chess.pieces;
import com.chess.pieces.interfaces.IEnPassantPawn;

public class EnPassantPawn implements IEnPassantPawn
{
    private boolean enPassantAttack;
    public EnPassantPawn()
    {
        enPassantAttack = false;
    }

    public boolean checkEnPassantCapturingWhite(Piece currentPiece,int previousMovedBlackX, int previousMovedBlackY )
    {
        if (currentPiece.getPositionX() == 4)
        {
            boolean left = (currentPiece.getPositionY()-1 == previousMovedBlackY && currentPiece.getPositionX() == previousMovedBlackX);
            boolean right = (currentPiece.getPositionY()+1 == previousMovedBlackY && currentPiece.getPositionX() == previousMovedBlackX);

            if(left || right)
            {
                enPassantAttack = true;
                return enPassantAttack;
            }
        }
        return enPassantAttack;
    }

    public boolean checkEnPassantCapturingBlack(Piece currentPiece,int previousMovedWhiteX, int previousMovedWhiteY )
    {
        if (currentPiece.getPositionX() == 3)
        {
            boolean left = (currentPiece.getPositionY()+1 == previousMovedWhiteY && currentPiece.getPositionX() == previousMovedWhiteX);
            boolean right = (currentPiece.getPositionY()-1 == previousMovedWhiteY && currentPiece.getPositionX() == previousMovedWhiteX);

            if(left || right)
            {
                enPassantAttack = true;
                return enPassantAttack;
            }
        }
        return enPassantAttack;
    }
}
