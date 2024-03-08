package Ćwiczenia.Projekty.Projekt2.version1;

public
    class Rook
    extends AbsPiece {

    Rook(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public String toString() {
        return super.getColor().equals(Color.WHITE) ? "♖" : "♜";
    }
}
