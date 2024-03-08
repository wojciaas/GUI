package Ćwiczenia.Projekty.Projekt2.version1;

public
    class Knight
    extends AbsPiece {

    Knight(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public String toString() {
        return super.getColor().equals(Color.WHITE) ? "♘" : "♞";
    }
}
