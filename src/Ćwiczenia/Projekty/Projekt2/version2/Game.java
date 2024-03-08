package Ćwiczenia.Projekty.Projekt2.version2;

import java.io.File;
import java.util.*;

public
    class Game {

    public static void printBoard() {
        System.out.println();
        for (int row = 0; row < 10; row++) {
            int index;

            if (row == 0 || row == 9)
                System.out.print("\s\s\u200a");

            for (int column = 0; column < 10; column++) {

                if ((row == 0 || row == 9) && (column > 0 && column < 9))
                    System.out.print((char)('A' + column - 1) + "\u200a\u2009");

                else if ((column == 0 || column == 9) && (row > 0 && row < 9))
                    System.out.print(column == 0 ? (9 - row) + " " : " " + (9 - row));

                else if(column > 0 && column < 9) {
                    index = 65 - ((row - 1) * 8 + 9 - column);
                    System.out.print(Board.board.get(index) != null ?
                            Board.board.get(index) : (((row % 2 != 0 && column % 2 == 0) || (row % 2 == 0 && column % 2 != 0))
                            ? "\u200a\u25a0\u2009" : "\u200a\u25a1\u2009"));
                }
            }

            System.out.println();
        }
        System.out.println();
    }
}