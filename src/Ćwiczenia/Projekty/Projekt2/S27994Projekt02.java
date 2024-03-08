package Ćwiczenia.Projekty.Projekt2;

import javax.xml.transform.Source;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
    class S27994Projekt02 {

    public static void main(String[] args) {
        System.setOut(
                        new PrintStream(
                        new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8
                )
        );
        Game.startGame();
    }
}

class Game{

    private static final Scanner SCANNER = new Scanner(System.in);

    private static String operation;

    private static HashMap<Integer, PieceAbs> gameboard = generateStartGameboard();

    private static final Pattern MOVE = Pattern.compile("^([a-h][1-8] [a-h][1-8])", Pattern.CASE_INSENSITIVE);

    private static PieceAbs.Color ColorTurn;

    private static boolean isCheck_Mate;

    private static boolean isDraw_WHITE, isDraw_BLACK;

    private static ArrayList<PieceAbs> capturedPieces = new ArrayList<>();

    private static HashMap<Integer, PieceAbs> generateStartGameboard(){
        HashMap<Integer, PieceAbs> board = new HashMap<>();

        board.put(1, new Rook(PieceAbs.Color.WHITE, 1, 1));
        board.put(2, new Knight(PieceAbs.Color.WHITE, 2, 1));
        board.put(3, new Bishop(PieceAbs.Color.WHITE, 3, 1));
        board.put(4, new Queen(PieceAbs.Color.WHITE, 4, 1));
        board.put(5, new King(PieceAbs.Color.WHITE, 5, 1));
        board.put(6, new Bishop(PieceAbs.Color.WHITE, 6, 1));
        board.put(7, new Knight(PieceAbs.Color.WHITE, 7, 1));
        board.put(8, new Rook(PieceAbs.Color.WHITE, 8, 1));

        for (int i = 9; i < 17; i++) {
            board.put(i, new Pawn(PieceAbs.Color.WHITE,  i - 8, 2));
        }

        for (int i = 49; i < 57; i++) {
            board.put(i, new Pawn(PieceAbs.Color.BLACK, i - 48, 7));
        }

        board.put(57, new Rook(PieceAbs.Color.BLACK, 1, 8));
        board.put(58, new Knight(PieceAbs.Color.BLACK, 2, 8));
        board.put(59, new Bishop(PieceAbs.Color.BLACK, 3, 8));
        board.put(60, new Queen(PieceAbs.Color.BLACK, 4, 8));
        board.put(61, new King(PieceAbs.Color.BLACK, 5, 8));
        board.put(62, new Bishop(PieceAbs.Color.BLACK, 6, 8));
        board.put(63, new Knight(PieceAbs.Color.BLACK, 7, 8));
        board.put(64, new Rook(PieceAbs.Color.BLACK, 8, 8));

        return board;
    }

    public static void startGame() {

        ColorTurn = PieceAbs.Color.WHITE;
        menuInstruction();

        do {
            GameBoard.printGameboard();
            System.out.print("Move or select option from instruction: ");
            operation = SCANNER.nextLine();
            operations(operation.toLowerCase());
        } while(!operation.equalsIgnoreCase("surrender") && !isDraw_BLACK && !isDraw_WHITE && !isCheck_Mate);
    }

    private static void menuInstruction(){
        System.out.println("========================CHESS GAME========================");
        System.out.println("1) Type 'draw' to offer a draw");
        System.out.println("2) Type 'save' to save the game");
        System.out.println("3) Type 'load' to load the game");
        System.out.println("4) Type 'surrender' to surrender the game");
        System.out.println("5) Type e.g. 'E7 E5' to move the piece");
        System.out.println("==========================================================");
    }

    private static void drawProposal() {
        System.out.println(ColorTurn + " player offered you a draw. Do you accept?");
        System.out.print("Type (y/n): ");
        String choose;
        do {
            choose = SCANNER.nextLine();
            switch (choose.toLowerCase()) {
                case "y" -> {
                    isDraw_WHITE= true;
                    isDraw_BLACK = true;
                    System.out.println("DRAW! GAME OVER!");
                }
                case "n" -> {
                    System.out.println(
                            (ColorTurn.equals(PieceAbs.Color.WHITE) ? PieceAbs.Color.BLACK : PieceAbs.Color.WHITE) +
                            " player declined your draw proposal. Keep playing or surrender."
                    );
                    isDraw_WHITE = false;
                    isDraw_BLACK = false;
                }
                default -> System.out.println("Invalid operation!");
            }
        } while (!choose.equalsIgnoreCase("y") && !choose.equalsIgnoreCase("n"));
    }

    public static void setColorTurn(PieceAbs.Color color){
        ColorTurn = color;
    }

    public static PieceAbs.Color getColorTurn() {
        return ColorTurn;
    }

    public static void setIsCheck_Mate(boolean isCheck_Mate) {
        Game.isCheck_Mate = isCheck_Mate;
    }

    private static void operations(String operation) {
        switch (operation){
            case "draw" -> {
                drawProposal();
                System.out.println("Do you want to play again?");
                System.out.print("Type (y/n): ");
                String choose;
                do {
                    choose = SCANNER.nextLine();
                    switch (choose.toLowerCase()) {
                        case "y" -> {
                            gameboard.clear();
                            capturedPieces.clear();
                            gameboard = generateStartGameboard();
                            ColorTurn = PieceAbs.Color.WHITE;
                            isDraw_WHITE = false;
                            isDraw_BLACK = false;
                            isCheck_Mate  = false;
                            startGame();
                        }
                        case "n" -> System.out.println("Goodbye!");
                        default -> System.out.println("Invalid operation!");
                    }
                } while (!choose.equalsIgnoreCase("y") && !choose.equalsIgnoreCase("n"));
            }
            case "save" -> {
                try {
                    FileManager.saveGame(gameboard, capturedPieces);
                } catch (TypeNotFoundException | ColorNotFoundException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "load" -> {
                try {
                    FileManager.loadGame(gameboard, capturedPieces);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "surrender" -> {
                if(ColorTurn.equals(PieceAbs.Color.WHITE)){
                    System.out.println("Black player wins by opponent's surrender!");
                } else
                    System.out.println("White player wins by opponent's surrender!!");

                System.out.println("Do you want to play again?");
                System.out.print("Type (y/n): ");
                String choose;
                do {
                    choose = SCANNER.nextLine();
                    switch (choose.toLowerCase()) {
                        case "y" -> {
                            gameboard.clear();
                            capturedPieces.clear();
                            gameboard = generateStartGameboard();
                            ColorTurn = PieceAbs.Color.WHITE;
                            isDraw_WHITE = false;
                            isDraw_BLACK = false;
                            isCheck_Mate  = false;
                            startGame();
                        }
                        case "n" -> System.out.println("Goodbye!");
                        default -> System.out.println("Invalid operation!");
                    }
                } while (!choose.equalsIgnoreCase("y") && !choose.equalsIgnoreCase("n"));
            }
            default -> {
                Matcher MATCHER = MOVE.matcher(operation);
                if(MATCHER.find()){
                        int source = (operation.charAt(1) - '1') * 8 + operation.charAt(0) - 'a' + 1;
                        if (gameboard.get(source) != null){
                            if (gameboard.get(source).getColor().equals(ColorTurn)) {
                                int sourceX = operation.charAt(0) - 'a' + 1;
                                int sourceY = operation.charAt(1) - '1' + 1;
                                int destX = operation.charAt(3) - 'a' + 1;
                                int destY = operation.charAt(4) - '1' + 1;
                                gameboard.get(source).move(sourceX, sourceY, destX, destY, gameboard, capturedPieces);
                                if (isCheck_Mate) {
                                    System.out.println("Check mate! Game over!");
                                    System.out.println("Do you want to play again?");
                                    System.out.print("Type (y/n): ");
                                    String choose;
                                    do {
                                        choose = SCANNER.nextLine();
                                        switch (choose.toLowerCase()) {
                                            case "y" -> {
                                                gameboard.clear();
                                                capturedPieces.clear();
                                                gameboard = generateStartGameboard();
                                                ColorTurn = PieceAbs.Color.WHITE;
                                                isDraw_WHITE = false;
                                                isDraw_BLACK = false;
                                                startGame();
                                            }
                                            case "n" -> System.out.println("Goodbye!");
                                            default -> System.out.println("Invalid operation!");
                                        }
                                    } while (!choose.equalsIgnoreCase("y") && !choose.equalsIgnoreCase("n"));
                                }
                            } else System.out.println("Now it's " + ColorTurn + "'s turn!");
                        } else System.out.println("Empty tale!");
                } else System.out.println("Invalid operation!");
            }
        }
    }

    protected static
    class FileManager{

        private static final File gameSave = new File("gameSave.bin");

        protected static void loadGame(HashMap<Integer, PieceAbs> gameboard, ArrayList<PieceAbs> capturedPieces) throws IOException {
            gameboard.clear();
            capturedPieces.clear();
            ColorTurn = PieceAbs.Color.WHITE;
            FileInputStream fis = new FileInputStream(gameSave);
            int res, index, posX, posY, type;
            PieceAbs.Color color = null;
            PieceAbs piece = null;
            while ((res = fis.read()) != -1){
                switch (res >> 3) {
                    case 0 -> color = PieceAbs.Color.WHITE;
                    case 1 -> color = PieceAbs.Color.BLACK;
                }
                posY = (((res & 0b111) << 1) | ((res = fis.read()) >> 7));
                posX = (res >> 3) & 0b1111;
                type = res & 0b111;
                switch (type){
                    case 0 -> piece = new Pawn(color, posX, posY);
                    case 1 -> piece = new King(color, posX, posY);
                    case 2 -> piece = new Queen(color, posX, posY);
                    case 3 -> piece = new Rook(color, posX, posY);
                    case 4 -> piece = new Bishop(color, posX, posY);
                    case 5 -> piece = new Knight(color, posX, posY);
                }
                if(posX == 0 && posY == 0){
                    capturedPieces.add(piece);
                } else {
                    index = (posY - 1) * 8 + posX;
                    gameboard.put(index, piece);
                }
            }
            fis.close();
        }

        protected static void saveGame(HashMap<Integer, PieceAbs> gameboard, ArrayList<PieceAbs> capturedPieces) throws IOException, TypeNotFoundException, ColorNotFoundException {
            FileOutputStream fos = new FileOutputStream(gameSave);
            PieceAbs piece;
            for (int i = 1; i < 65; i++) {
                if((piece = gameboard.get(i)) != null){
                    fos.write((colorToSave(piece.getColor()) << 3) | (piece.getY() >> 1));
                    fos.write((piece.getY() << 7) | (piece.getX() << 3) | typeToSave(piece.getType()));
                }
            }

            for (PieceAbs capturedPiece : capturedPieces) {
                fos.write((colorToSave(capturedPiece.getColor()) << 3) | (capturedPiece.getY() >> 1));
                fos.write((capturedPiece.getY() << 7) | (capturedPiece.getX() << 3) | typeToSave(capturedPiece.getType()));
            }
            fos.close();
        }

        private static int colorToSave(PieceAbs.Color color) throws ColorNotFoundException {
            switch (color){
                case WHITE -> {
                    return 0;
                }
                case BLACK -> {
                    return 1;
                }
            }
            throw new ColorNotFoundException();
        }

        private static int typeToSave(PieceAbs.Type type) throws TypeNotFoundException {
            switch (type){
                case PAWN -> {
                    return 0;
                }
                case KING -> {
                    return 1;
                }
                case QUEEN -> {
                    return 2;
                }
                case ROOK -> {
                    return 3;
                }
                case BISHOP -> {
                    return 4;
                }
                case KNIGHT -> {
                    return  5;
                }
            }
            throw new TypeNotFoundException();
        }
    }

    protected static
    class GameBoard{

        protected static void printGameboard(){

            System.out.println();

            for (int row = 9; row >= 0; row--) {

                if (row == 9 || row == 0)
                    System.out.print("  ");

                for (int column = 9; column >= 0; column--) {

                    if ((row == 0 || row == 9) && (column > 0 && column < 9))
                        System.out.print("\u2009\u2009\u200a" + (char)((int)'A' + 8 - column) + "\u2009\u2009\u200a");

                    else if ((column == 0 || column == 9) && (row > 0 && row < 9)) {
                        System.out.print(column == 9 ? row + " " : " " + row);
                        if ((row == 8 || row == 1) && column == 0){
                            System.out.print(" Captured pieces: ");
                            if (row == 8) {
                                capturedPieces.stream()
                                        .filter(p -> p.getColor().equals(PieceAbs.Color.WHITE))
                                        .sorted(
                                            (p1, p2) -> {
                                                try {
                                                    return FileManager.typeToSave(p1.getType()) - FileManager.typeToSave(p2.getType());
                                                } catch (TypeNotFoundException e) {
                                                    throw new RuntimeException(e);
                                                }
                                            }
                                        )
                                        .forEach(System.out::print);
                            } else {
                                capturedPieces.stream()
                                        .filter(p -> p.getColor().equals(PieceAbs.Color.BLACK))
                                        .sorted(
                                                (p1, p2) -> {
                                                    try {
                                                        return FileManager.typeToSave(p1.getType()) - FileManager.typeToSave(p2.getType());
                                                    } catch (TypeNotFoundException e) {
                                                        throw new RuntimeException(e);
                                                    }
                                                }
                                        )
                                        .forEach(System.out::print);
                            }
                        }
                    }

                    else if (row > 0 && row < 9 && column < 9) {
                        int index = row * 8 - column + 1;
                        if (gameboard.get(index) != null) {
                            if ((column + row) % 2 == 0)
                                System.out.print(gameboard.get(index).getColor() == PieceAbs.Color.WHITE ?
                                        "\033[48:5:230m\u2009\u200a\033[38:5:250m" + gameboard.get(index) + "\u2009\u200a\033[0m" :
                                        "\033[48:5:230m\u2009\u200a\033[38:5:236m" + gameboard.get(index) + "\u2009\u200a\033[0m");
                            else
                                System.out.print(gameboard.get(index).getColor() == PieceAbs.Color.WHITE ?
                                        "\033[48:5:65m\u2009\u200a\033[38:5:250m" + gameboard.get(index) + "\u2009\u200a\033[0m" :
                                        "\033[48:5:65m\u2009\u200a\033[38:5:236m" + gameboard.get(index) + "\u2009\u200a\033[0m");
                        } else
                            System.out.print((column + row) % 2 == 0 ? "\033[48:5:230m  \u2009\u200a\u200a\033[0m" :
                                                                        "\033[48:5:65m  \u2009\u200a\u200a\033[0m");

                    }
                }
                System.out.println();
            }
            System.out.println();
        }

    }
}

class TypeNotFoundException
    extends Exception{

    TypeNotFoundException(){
        super("Invalid type to save!");
    }
}

class ColorNotFoundException
    extends Exception{

    ColorNotFoundException(){
        super("Color not found!");
    }
}

interface Movable{

    default void move(int sourceX, int sourceY, int destX, int destY, HashMap<Integer, PieceAbs> board, ArrayList<PieceAbs> capturedPieces){
        int indexSource = (sourceY - 1) * 8 + sourceX;
        int indexDest = (destY - 1) * 8 + destX;

        if (kingUnderAttack(sourceX, sourceY, destX, destY, board)){
            System.out.println("Invalid move!");
            return;
        }

        if (isMoveValid(sourceX, sourceY, destX, destY, board) && (indexSource != indexDest)){

            if (
                    board.get(indexDest) != null
                    && board.get(indexSource).getType().equals(PieceAbs.Type.KING)
                    && board.get(indexDest).getType().equals(PieceAbs.Type.ROOK)
            ){
                if (Game.getColorTurn().equals(PieceAbs.Color.WHITE)){
                    if (indexSource == 5 && indexDest == 1){
                        board.get(1).setX(4);
                        board.get(1).setY(1);
                        board.put(4, board.get(1));
                        board.remove(1);
                        board.get(5).setX(3);
                        board.get(5).setY(1);
                        board.put(3, board.get(5));
                        board.remove(5);
                    } else if (indexSource == 5 && indexDest == 8) {
                        board.get(8).setX(6);
                        board.get(8).setY(1);
                        board.put(6, board.get(8));
                        board.remove(8);
                        board.get(5).setX(7);
                        board.get(5).setY(1);
                        board.put(7, board.get(5));
                        board.remove(5);
                    }
                } else {
                    if (indexSource == 61 && indexDest == 57){
                        board.get(57).setX(4);
                        board.get(57).setY(8);
                        board.put(60, board.get(57));
                        board.remove(57);
                        board.get(61).setX(3);
                        board.get(61).setY(8);
                        board.put(59, board.get(61));
                        board.remove(61);
                    } else if (indexSource == 61 && indexDest == 64) {
                        board.get(64).setX(6);
                        board.get(64).setY(8);
                        board.put(62, board.get(64));
                        board.remove(64);
                        board.get(61).setX(7);
                        board.get(61).setY(8);
                        board.put(63, board.get(61));
                        board.remove(61);
                    }
                }
                Game.setColorTurn(Game.getColorTurn().equals(PieceAbs.Color.WHITE) ? PieceAbs.Color.BLACK : PieceAbs.Color.WHITE);
                return;
            }

            if (board.get(indexSource).isFirstMove() && board.get(indexSource).getType().equals(PieceAbs.Type.PAWN)){
                board.get(indexSource).setFirstMove(false);
            } else if (board.get(indexSource).getType().equals(PieceAbs.Type.PAWN) && board.get(indexSource).isEnPassant()) {
                board.get(indexSource).setEnPassant(false);
            }

//            if (enPassant(indexSource, indexDest, board)){
//                if (Game.getColorTurn().equals(PieceAbs.Color.WHITE)){
//                    board.get(indexDest - 8).setX(0);
//                    board.get(indexDest - 8).setY(0);
//                    capturedPieces.add(board.get(indexDest - 8));
//                    board.remove(indexDest - 8);
//                    board.put(indexDest, board.get(indexSource));
//                    board.remove(indexSource);
//                } else {
//                    board.get(indexDest + 8).setX(0);
//                    board.get(indexDest + 8).setY(0);
//                    capturedPieces.add(board.get(indexDest + 8));
//                    board.remove(indexDest + 8);
//                    board.put(indexDest, board.get(indexSource));
//                    board.remove(indexSource);
//                }
//                Game.setColorTurn(Game.getColorTurn().equals(PieceAbs.Color.WHITE) ? PieceAbs.Color.BLACK : PieceAbs.Color.WHITE);
//                return;
//            }

            if (board.get(indexDest) != null && !board.get(indexDest).getType().equals(PieceAbs.Type.KING)) {
                board.get(indexDest).setX(0);
                board.get(indexDest).setY(0);
                capturedPieces.add(board.get(indexDest));

            } else if (board.get(indexDest) != null && board.get(indexDest).getType().equals(PieceAbs.Type.KING))
                System.out.println("You can't capture the King!");

            if (board.get(indexSource).getType().equals(PieceAbs.Type.PAWN) && (destY == 1 || destY == 8))
                pawnPromotion(sourceX, sourceY, destX, destY, board, capturedPieces);

        } else {
            System.out.println("Invalid move!");
            return;
        }

        board.put(indexDest, board.get(indexSource));
        board.get(indexDest).setX(destX);
        board.get(indexDest).setY(destY);
        board.remove(indexSource);
        Game.setColorTurn(Game.getColorTurn().equals(PieceAbs.Color.WHITE) ? PieceAbs.Color.BLACK : PieceAbs.Color.WHITE);
        if (isKingInCheck(wheresKing(board),board)) {
            System.out.println(Game.getColorTurn() + "'s King is in check!");

            if (isKingInCheckMate(wheresKing(board),board)) {
                Game.GameBoard.printGameboard();
                System.out.println(Game.getColorTurn() + " is in checkmate!");
                System.out.println(Game.getColorTurn().equals(PieceAbs.Color.WHITE) ? "Black wins!" : "White wins!");
                Game.setIsCheck_Mate(true);
            }
        }
    }

    default void pawnPromotion(int sourceX, int sourceY, int destX, int destY, HashMap<Integer, PieceAbs> board, ArrayList<PieceAbs> capturedPieces){
        System.out.println("Pawn promotion!");
        System.out.println("Choose a piece to promote to: ");
        System.out.println("-Queen");
        System.out.println("-Rook");
        System.out.println("-Bishop");
        System.out.println("-Knight");
        System.out.println("Type e.g. \"Queen\" to choose the Queen");
        PieceAbs piece = null;
        do {
            System.out.print("Your choice: ");
            String choice = new Scanner(System.in).nextLine();
            switch (choice.toLowerCase()){
                case "queen" ->{
                    System.out.println("Queen");
                    piece = new Queen(Game.getColorTurn(), destX, destY);
                }
                case "rook" ->{
                    System.out.println("Rook");
                    piece = new Rook(Game.getColorTurn(), destX, destY);
                }
                case "bishop" ->{
                    System.out.println("Bishop");
                    piece = new Bishop(Game.getColorTurn(), destX, destY);
                }
                case "knight" -> {
                    System.out.println("Knight");
                    piece = new Knight(Game.getColorTurn(), destX, destY);
                }
                default -> System.out.println("Invalid choice!");
            }
        } while (piece == null);
        int indexSource = (sourceY - 1) * 8 + sourceX;
        board.get(indexSource).setX(0);
        board.get(indexSource).setY(0);
        capturedPieces.add(board.get(indexSource));
        board.put(indexSource, piece);
    }

    boolean isMoveValid(int sourceX, int sourceY, int destX, int destY, HashMap<Integer, PieceAbs> board);

    default boolean kingUnderAttack(int sourceX, int sourceY, int destX, int destY, HashMap<Integer, PieceAbs> board){
        int indexSource = (sourceY - 1) * 8 + sourceX;
        int indexDest = (destY - 1) * 8 + destX;
        PieceAbs source = board.get(indexSource);
        boolean isKingUnderAttack = false;
        if (board.get(indexSource).isMoveValid(sourceX, sourceY, destX, destY, board)){
            if (board.get(indexDest) != null) {
                PieceAbs dest = board.get(indexDest);
                board.remove(indexDest);
                board.put(indexDest, source);
                board.remove(indexSource);
                isKingUnderAttack = isKingInCheck(wheresKing(board), board);
                board.remove(indexDest);
                board.put(indexDest, dest);
                board.put(indexSource, source);
            } else {
                board.put(indexDest, source);
                board.remove(indexSource);
                isKingUnderAttack = isKingInCheck(wheresKing(board), board);
                board.remove(indexDest);
                board.put(indexSource, source);
            }
        }
        return isKingUnderAttack;
    }

    default boolean isKingInCheckMate(int kingCord, HashMap<Integer, PieceAbs> board){
        int kingX = kingCord % 8 == 0 ? 8 : kingCord % 8;
        int kingY = kingCord / 8 == 8 ? 8 : kingCord / 8 + 1;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (kingX + j > 0 && kingX + j < 9 && kingY + i > 0 && kingY + i < 9)
                    if (
                            board.get(kingCord).isMoveValid(kingX, kingY, kingX + j, kingY + i, board)
                            && !kingUnderAttack(kingX, kingY, kingX + j, kingY + i, board)
                    )
                        return false;
            }
        }

        for (int i = 1; i < 65; i++) {
            //if (board.get(i).getColor().equals(Game.getColorTurn()))
        }
        return true;
    }

    default boolean isKingInCheck(int kingCord, HashMap<Integer, PieceAbs> board){
        int kingX = kingCord % 8 == 0 ? 8 : kingCord % 8;
        int kingY = kingCord / 8 == 8 ? 8 : kingCord / 8 + 1;
        for (int i = 1; i < 65; i++) {
            if (board.get(i) != null && !board.get(i).getColor().equals(Game.getColorTurn())){
                if(board.get(i).isMoveValid(i % 8 == 0 ? 8 : i % 8, i / 8 == 8 ? 8 : (i % 8 == 0 ? i / 8 : i / 8 + 1), kingX, kingY, board))
                    return true;
            }
        }
        return false;
    }

    default int wheresKing(HashMap<Integer, PieceAbs> board){

        for (int i = 1; i < 65; i++) {
            if (
                    board.get(i) != null && board.get(i).getType().equals(PieceAbs.Type.KING) &&
                    board.get(i).getColor().equals(Game.getColorTurn())
            ){
                return i;
            }
        }

        return 0;
    }

    default boolean enPassant(int indexSource, int indexDest, HashMap<Integer, PieceAbs> board){
        if (Game.getColorTurn().equals(PieceAbs.Color.WHITE)){
            return board.get(indexDest) == null && board.get(indexDest - 8) != null &&
                    board.get(indexDest - 8).getType().equals(PieceAbs.Type.PAWN) &&
                    board.get(indexDest - 8).getColor().equals(PieceAbs.Color.BLACK) &&
                    (board.get(indexSource - 1) != null || board.get(indexSource + 1) != null) &&
                    board.get(indexDest - 8).isEnPassant();
        } else{
            return board.get(indexDest) == null && board.get(indexDest + 8) != null &&
                    board.get(indexDest + 8).getType().equals(PieceAbs.Type.PAWN) &&
                    board.get(indexDest + 8).getColor().equals(PieceAbs.Color.WHITE) &&
                    (board.get(indexSource - 1) != null || board.get(indexSource + 1) != null) &&
                    board.get(indexDest + 8).isEnPassant();
        }
    }
}

interface MovableVertAndHor{

    default boolean isValidVertAndHor(int sourceX, int sourceY, int destX, int destY, HashMap<Integer, PieceAbs> board){
        int indexDest = (destY - 1) * 8 + destX;
        int indexSource = (sourceY - 1) * 8 + sourceX;
        if (sourceX == destX || sourceY == destY){
            if (sourceX == destX){
                int min = Math.min(sourceY, destY);
                int max = Math.max(sourceY, destY);
                for (int i = min + 1; i < max; i++) {
                    if (board.get((i - 1) * 8 + sourceX) != null)
                        return false;
                }
            } else {
                int min = Math.min(sourceX, destX);
                int max = Math.max(sourceX, destX);
                for (int i = min + 1; i < max; i++) {
                    if (board.get((sourceY - 1) * 8 + i) != null)
                        return false;
                }
            }
            return board.get(indexDest) == null || board.get(indexDest).getColor() != board.get(indexSource).getColor();
        }
        return false;
    }
}

interface MovableDiag{

    default boolean isValidDiag(int sourceX, int sourceY, int destX, int destY, HashMap<Integer, PieceAbs> board){
        int indexDest = (destY - 1) * 8 + destX;
        int indexSource = (sourceY - 1) * 8 + sourceX;
        if (Math.abs(sourceX - destX) == Math.abs(sourceY - destY)){
            if (sourceX < destX){
                if (sourceY < destY){
                    for (int i = indexSource + 9; i < indexDest; i += 9) {
                        if (board.get(i) != null)
                            return false;
                    }
                } else {
                    for (int i = indexSource - 7; i > indexDest; i -= 7) {
                        if (board.get(i) != null)
                            return false;
                    }
                }
            } else if (sourceX > destX) {
                if (sourceY < destY){
                    for (int i = indexSource + 7; i < indexDest; i += 7) {
                        if (board.get(i) != null)
                            return false;
                    }
                } else {
                    for (int i = indexSource - 9; i > indexDest; i -= 9) {
                        if (board.get(i) != null)
                            return false;
                    }
                }
            }
            return board.get(indexDest) == null || board.get(indexDest).getColor() != board.get(indexSource).getColor();
        }
        return false;
    }
}

interface Castle{

        default boolean isCastleValid(int sourceX, int sourceY, int destX, int destY, HashMap<Integer, PieceAbs> board){
            int indexDest = (destY - 1) * 8 + destX;
            int indexSource = (sourceY - 1) * 8 + sourceX;
            if (board.get(indexSource) != null && board.get(indexSource).getType().equals(PieceAbs.Type.KING)){
                if (board.get(indexDest) != null && board.get(indexDest).getType().equals(PieceAbs.Type.ROOK)){
                    if (sourceX < destX){
                        for (int i = indexSource + 1; i < indexDest; i++) {
                            if (board.get(i) != null)
                                return false;
                        }
                    } else {
                        for (int i = indexSource - 1; i > indexDest; i--) {
                            if (board.get(i) != null)
                                return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
}

abstract
    class PieceAbs
    implements Movable{

    enum Color{
        WHITE, BLACK
    }

    enum Type{
        KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN
    }

    private Type type;

    private Color color;

    private int x, y;

    private boolean firstMove = true;

    private boolean enPassant = true;


    PieceAbs(Color color, int x, int y){
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    public boolean isEnPassant() {
        return enPassant;
    }

    public void setEnPassant(boolean enPassant) {
        this.enPassant = enPassant;
    }
}

class Rook
    extends PieceAbs
    implements MovableVertAndHor, Castle{

    Rook(Color color, int x, int y){
        super(color, x, y);
        setType(Type.ROOK);
    }

    @Override
    public String toString() {
        return "\u265c";
    }

    @Override
    public boolean isMoveValid(int sourceX, int sourceY, int destX, int destY, HashMap<Integer, PieceAbs> board) {
        int indexSource = (sourceY - 1) * 8 + sourceX;
        int indexDest = (destY - 1) * 8 + destX;
        return isValidVertAndHor(sourceX, sourceY, destX, destY, board)
                || isCastleValid(sourceX, sourceY, destX, destY, board)
                || enPassant(indexSource, indexDest, board);
    }
}

class Knight
    extends PieceAbs{

    Knight(Color color, int x, int y){
        super(color, x, y);
        setType(Type.KNIGHT);
    }

    @Override
    public String toString() {
        return "\u265e";
    }

    @Override
    public boolean isMoveValid(int sourceX, int sourceY, int destX, int destY, HashMap<Integer, PieceAbs> board) {
        int indexDest = (destY - 1) * 8 + destX;
        int indexSource = (sourceY - 1) * 8 + sourceX;
        return (Math.abs(sourceX - destX) == 2 && Math.abs(sourceY - destY) == 1 ||
                Math.abs(sourceX - destX) == 1 && Math.abs(sourceY - destY) == 2) &&
                (board.get(indexDest) == null || board.get(indexDest).getColor() != getColor() || enPassant(indexSource, indexDest, board));
    }
}

class Bishop
    extends PieceAbs
    implements MovableDiag{

    Bishop(Color color, int x, int y){
        super(color, x, y);
        setType(Type.BISHOP);
    }

    @Override
    public String toString() {
        return "\u265d";
    }

    @Override
    public boolean isMoveValid(int sourceX, int sourceY, int destX, int destY, HashMap<Integer, PieceAbs> board) {
        int indexDest = (destY - 1) * 8 + destX;
        int indexSource = (sourceY - 1) * 8 + sourceX;
        return isValidDiag(sourceX, sourceY, destX, destY, board) || enPassant(indexSource, indexDest, board);
    }
}

class Queen
    extends PieceAbs
    implements MovableVertAndHor, MovableDiag{

    Queen(Color color, int x, int y){
        super(color, x, y);
        setType(Type.QUEEN);
    }

    @Override
    public String toString() {
        return "\u265b";
    }


    @Override
    public boolean isMoveValid(int sourceX, int sourceY, int destX, int destY, HashMap<Integer, PieceAbs> board) {
        int indexSource = (sourceY - 1) * 8 + sourceX;
        int indexDest = (destY - 1) * 8 + destX;
        return isValidVertAndHor(sourceX, sourceY, destX, destY, board) || isValidDiag(sourceX, sourceY, destX, destY, board) || enPassant(indexSource, indexDest, board);
    }
}

class King
    extends PieceAbs
    implements Castle{

    King(Color color, int x, int y){
        super(color, x, y);
        setType(Type.KING);
    }

    @Override
    public String toString() {
        return "\u265a";
    }


    @Override
    public boolean isMoveValid(int sourceX, int sourceY, int destX, int destY, HashMap<Integer, PieceAbs> board) {
        int indexDest = (destY - 1) * 8 + destX;
        int indexSource = (sourceY - 1) * 8 + sourceX;
        return ((Math.abs(sourceX - destX) <= 1 && Math.abs(sourceY - destY) <= 1
                && (board.get(indexDest) == null || board.get(indexDest).getColor() != getColor()))
                || isCastleValid(sourceX, sourceY, destX, destY, board)
                || enPassant(indexSource, indexDest, board));
    }
}

class Pawn
    extends PieceAbs{

    Pawn(Color color, int x, int y){
        super(color, x, y);
        setType(Type.PAWN);
    }

    @Override
    public String toString() {
        return "\u265f";
    }

    @Override
    public boolean isMoveValid(int sourceX, int sourceY, int destX, int destY, HashMap<Integer, PieceAbs> board) {
        int indexDest = (destY - 1) * 8 + destX;
        int indexSource = (sourceY - 1) * 8 + sourceX;
        if (isFirstMove()){
            if (
                    destY == (sourceY + 2) && sourceX == destX &&
                    board.get(indexSource).getColor().equals(Color.WHITE)
            ){
                    return board.get(indexSource + 8) == null && board.get(indexDest) == null || enPassant(indexSource, indexDest, board);
            }
            else if (
                    destY == (sourceY - 2) && sourceX == destX &&
                    board.get(indexSource).getColor().equals(Color.BLACK)
            ){
                    return board.get(indexSource - 8) == null && board.get(indexDest) == null || enPassant(indexSource, indexDest, board);
            }
            else
                return isValidMoveHelp(sourceX, sourceY, destX, destY, board, indexDest, indexSource);
        } else {
                return isValidMoveHelp(sourceX, sourceY, destX, destY, board, indexDest, indexSource);
        }
    }

    private boolean isValidMoveHelp(int sourceX, int sourceY, int destX, int destY, HashMap<Integer, PieceAbs> board, int indexDest, int indexSource) {
        if (
                destY == (sourceY + 1) && sourceX == destX &&
                board.get(indexSource).getColor().equals(Color.WHITE)
        ){
            return board.get(indexSource + 8) == null || enPassant(indexSource, indexDest, board);
        }
        else if (
                destY == (sourceY - 1) && sourceX == destX &&
                board.get(indexSource).getColor().equals(Color.BLACK)
        ){
            return board.get(indexSource - 8) == null || enPassant(indexSource, indexDest, board);

        } else if (
                sourceY < destY && Math.abs(sourceX - destX) == 1 && Math.abs(sourceY - destY) == 1 &&
                board.get(indexSource).getColor().equals(Color.WHITE)
        ){
            return (board.get(indexDest) != null && board.get(indexDest).getColor() != getColor()) || enPassant(indexSource, indexDest, board);
        } else if (
                sourceY > destY && Math.abs(sourceX - destX) == 1 && Math.abs(sourceY - destY) == 1 &&
                board.get(indexSource).getColor().equals(Color.BLACK)
        ){
            return (board.get(indexDest) != null && board.get(indexDest).getColor() != getColor()) || enPassant(indexSource, indexDest, board);
        }
        return enPassant(indexSource, indexDest, board);
    }
}