package Ćwiczenia.Projekty.Projekt2.version2;

import java.util.ArrayList;
import java.util.List;

public abstract
    class PieceAbs
    implements Piece{

    enum Color {
        WHITE, BLACK
    }

    private int X;

    private int Y;

    private final Color COLOR;

    private static Color turn = Color.WHITE;

    enum PieceType {
        KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN
    }

    public PieceAbs(Color color, int x, int y) {
        this.COLOR = color;
        this.X = x;
        this.Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public Color getColor() {
        return COLOR;
    }
}

class Rook
    extends PieceAbs {

    private static final PieceType PIECE_TYPE = PieceType.ROOK;

    public Rook(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public String toString() {
        return super.getColor().equals(Color.WHITE) ? "♖" : "♜";
    }
}

class Knight
    extends PieceAbs {

    private static final int[] POSSIBLE_MOVES = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public String toString() {
        return super.getColor().equals(Color.WHITE) ? "♘" : "♞";
    }

//    @Override
//    public boolean isMoveValid(int index) {
//        for(int coordinate : POSSIBLE_MOVES){
//            if (index + coordinate < 1 || index + coordinate > 64)
//                return false;
//        }
//    }
}

class Bishop
    extends PieceAbs {

    public Bishop(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public String toString() {
        return super.getColor().equals(Color.WHITE) ? "♗" : "♝";
    }
}

class Queen
    extends PieceAbs {

    public Queen(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public String toString() {
        return super.getColor().equals(Color.WHITE) ? "♕" : "♛";
    }
}


class King
    extends PieceAbs {

    public King(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public String toString() {
        return super.getColor().equals(Color.WHITE) ? "♔" : "♚";
    }
}

class Pawn
    extends PieceAbs
    implements VertMovable {

    private PieceType pieceType = PieceType.PAWN;

    private boolean isFirstMove = true;

    public Pawn(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public String toString() {
        return super.getColor().equals(Color.WHITE) ? "♙" : "♟";
    }
}