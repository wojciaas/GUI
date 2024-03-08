package Ćwiczenia.Projekty.Projekt2.version2;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public
    class Board {

    private static final Scanner SCANNER = new Scanner(System.in);

    private String option;

    public static HashMap<Integer, PieceAbs> board = new HashMap<>();

    protected static final File SAVED_GAME = new File("game.bin");

    public Board(){
        instructions();
        generateBoard();
        do{
            Game.printBoard();
            option = SCANNER.nextLine();
            operations(option);
        } while (!option.equalsIgnoreCase("quit"));
    }

    private static void generateBoard() {
        board.put(1, new Rook(PieceAbs.Color.WHITE, 1, 1));
        board.put(2, new Knight(PieceAbs.Color.WHITE, 2, 1));
        board.put(3, new Bishop(PieceAbs.Color.WHITE, 3, 1));
        board.put(4, new Queen(PieceAbs.Color.WHITE, 4, 1));
        board.put(5, new King(PieceAbs.Color.WHITE, 5, 1));
        board.put(6, new Bishop(PieceAbs.Color.WHITE, 6, 1));
        board.put(7, new Knight(PieceAbs.Color.WHITE, 7, 1));
        board.put(8, new Rook(PieceAbs.Color.WHITE, 8, 1));
        for (int i = 9; i < 17; i++) {
            board.put(i, new Pawn(PieceAbs.Color.WHITE, i - 8, 2));
        }
        for (int i = 49; i < 57; i++) {
            board.put(i, new Pawn(PieceAbs.Color.BLACK, i - 16, 7));
        }
        board.put(57, new Rook(PieceAbs.Color.BLACK, 1, 8));
        board.put(58, new Knight(PieceAbs.Color.BLACK, 2, 8));
        board.put(59, new Bishop(PieceAbs.Color.BLACK, 3, 8));
        board.put(60, new Queen(PieceAbs.Color.BLACK, 4, 8));
        board.put(61, new King(PieceAbs.Color.BLACK, 5, 8));
        board.put(62, new Bishop(PieceAbs.Color.BLACK, 6, 8));
        board.put(63, new Knight(PieceAbs.Color.BLACK, 7, 8));
        board.put(64, new Rook(PieceAbs.Color.BLACK, 8, 8));
    }

    private static void instructions(){
        System.out.println("Instructions:");
        System.out.println("1. Type 'save' to save a game.");
        System.out.println("2. Type 'load' to load a saved game.");
        System.out.println("3. Type 'quit' to quit the game.");
    }

    private static void operations(String option){
        switch (option.toLowerCase()){
            case "quit" -> System.out.println("Thanks for playing.");
            default -> {
                int sourceIndex = (option.toLowerCase().charAt(1) - '1') * 8 + option.toLowerCase().charAt(0) - 'a' + 1;
                if (Board.board.get(sourceIndex) != null){
                    Board.board.get(sourceIndex).move(sourceIndex,
                            option.toLowerCase().charAt(3) - 'a' + 1,
                            option.toLowerCase().charAt(4) - '0');
                } else
                    System.out.println("There is no piece on this tale!\n");
            }
        }
    }
}
