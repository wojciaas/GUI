package Ćwiczenia.Projekty.Projekt2.version1;

public abstract
    class AbsPiece
    implements Piece{

    private final Color color;

    private int x;

    private int y;

    public AbsPiece(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

//    @Override
//    public void move(int destX, int destY, Board board) {
//        if (isMovePossible(destX, destY, board)) {
//            setX(destX);
//            setY(destY);
//        }
//    }
}
