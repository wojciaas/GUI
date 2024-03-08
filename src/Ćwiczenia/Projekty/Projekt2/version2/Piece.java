package Ćwiczenia.Projekty.Projekt2.version2;

public
    interface Piece {

    default void move(int source, int destX, int destY){
        //if(isMoveValid(source)){
            int destIndex = (destY - 1) * 8 + destX;
            Board.board.put(destIndex, Board.board.get(source));
            Board.board.get(destIndex).setX(destX);
            Board.board.get(destIndex).setY(destY);
            Board.board.remove(source);
        //} else
            System.out.println("Invalid move!");
    }

    //boolean isMoveValid(int source);

}
