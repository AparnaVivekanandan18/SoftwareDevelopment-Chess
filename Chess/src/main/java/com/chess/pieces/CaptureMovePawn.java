package com.chess.pieces;
import com.chess.chessboard.IBoard;
import com.chess.pieces.interfaces.ICaptureMovePawn;

public class CaptureMovePawn implements ICaptureMovePawn
{
    private int attackdiagonalXLeft;
    private int attackdiagonalYLeft;
    private int attackdiagonalXRight;
    private int attackdiagonalYRight;
    private int targetX;
    private int targetY;
    private boolean attackLeft;
    private boolean attackRight;
    private IBoard boardobj;

    public CaptureMovePawn()
    {
        attackdiagonalXLeft = 0;
        attackdiagonalYLeft = 0;
        attackdiagonalXRight = 0;
        attackdiagonalYRight = 0;
        targetX = 0;
        targetY = 0;
        attackLeft = false;
        attackRight = false;
    }
    public void initialiseValues(Piece currentPiece,int destinationX,int destinationY,IBoard boardobj)
    {
        targetX = destinationX;
        targetY = destinationY;
        this.boardobj=boardobj;
    }

    private boolean checkAttack(int attackX, int attackY)
    {
        boolean attack = false;
        Piece attackPieceIsPresent = boardobj.getPiece(attackX, attackY);
        if (attackPieceIsPresent != null && attackX == targetX && attackY == targetY)
        {
            attack = true;
            return attack;
        }
        return attack;
    }

    public boolean cornerWhitePawnAttack(Piece currentPiece)
    {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();
        boolean pawnCanAttack = false;

        if(currentX < 7)
        {
            if (currentY == 0) {
                attackdiagonalXLeft = currentX + 1; //Valid position to be attacked
                attackdiagonalYLeft = currentY + 1;
                attackRight = checkAttack(attackdiagonalXLeft,attackdiagonalYLeft);
                return attackRight;
            }

            if (currentY == 7) {
                attackdiagonalXRight = currentX + 1; //Valid position to be attacked
                attackdiagonalYRight = currentY - 1;
                attackLeft = checkAttack(attackdiagonalXRight,attackdiagonalYRight);
                return attackLeft;
            }
        }
        return pawnCanAttack;
    }

    public boolean whitePawnAttack(Piece currentPiece)
    {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();
        boolean pawnCanAttack = false;

        if(currentX < 7)
        {
            if (currentY > 0 && currentY < 7)
            {
                attackdiagonalXRight = currentX + 1;
                attackdiagonalYRight = currentY - 1;
                attackLeft = checkAttack(attackdiagonalXRight,attackdiagonalYRight);

                attackdiagonalXLeft = currentX + 1;
                attackdiagonalYLeft = currentY + 1;
                attackRight = checkAttack(attackdiagonalXLeft,attackdiagonalYLeft);

                if ( attackLeft || attackRight)
                {
                    pawnCanAttack = true;
                    return pawnCanAttack;
                }
            }
        }
        return pawnCanAttack;
    }

    public boolean cornerBlackPawnAttack(Piece currentPiece)
    {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();
        boolean pawnCanAttack = false;

        if(currentX >0 ) // Yet, Pawn hasn't moved to the opposite extreme
        {
            if (currentY == 0) {
                attackdiagonalXRight = currentX - 1;
                attackdiagonalYRight = currentY + 1;
                attackLeft = checkAttack(attackdiagonalXRight,attackdiagonalYRight);
                return attackLeft;
            }

            if (currentY == 7) {
                attackdiagonalXLeft = currentX - 1;
                attackdiagonalYLeft = currentY - 1;
                attackRight = checkAttack(attackdiagonalXLeft,attackdiagonalYLeft);
                return attackRight;
            }
        }
        return pawnCanAttack;
    }

    public boolean blackPawnAttack(Piece currentPiece)
    {
        int currentX = currentPiece.getPositionX();
        int currentY = currentPiece.getPositionY();

        boolean pawnCanAttack = false;

        if(currentX > 0) // Yet, Pawn hasn't moved to the opposite extreme
        {
            if (currentY > 0 && currentY < 7)
            {
                attackdiagonalXLeft = currentX - 1;
                attackdiagonalYLeft = currentY - 1;
                attackLeft = checkAttack(attackdiagonalXLeft,attackdiagonalYLeft);

                attackdiagonalXRight = currentX - 1;
                attackdiagonalYRight = currentY + 1;
                attackRight = checkAttack(attackdiagonalXRight,attackdiagonalYRight);

                if ( attackLeft || attackRight)
                {
                    pawnCanAttack = true;
                    return pawnCanAttack;
                }
            }
        }
        return pawnCanAttack;
    }
}
