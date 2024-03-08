package Ćwiczenia.Projekty.Projekt2.p02_01;

public
    class Logic
    implements Inter{

    char[][] board;

    public Logic() {
        this.board = new char[8][8];

        for(int i=0; i<5; i++)
            this.board[(int)(Math.random()*8)][(int)(Math.random()*8)] = 'p';


    }

    @Override
    public int getHeight() {
        return this.board.length;
    }

    @Override
    public int getWidth() {
        return this.board[0].length;
    }

    @Override
    public char getElementAt(int i, int j) {
        return this.board[i][j];
    }
}
