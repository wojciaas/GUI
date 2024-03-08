package Ćwiczenia.Projekty.Projekt2.testy;

import Ćwiczenia.Projekty.Projekt2.version2.Board;
import Ćwiczenia.Projekty.Projekt2.version2.Game;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public
    class testy {
    public static void main(String[] args) {
        System.setOut(
                        new PrintStream(
                        new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8
                        )
        );
        File save = new File("/Users/wojciechregula/Desktop/PJATK/SEM II/GUI/src/Ćwiczenia/Projekty/Projekt2/chessTest.bin");
        try {
            FileInputStream fis = new FileInputStream(save);
            int res, index = 0;
            while ((res = fis.read()) != -1){
                System.out.print(index + ". ");
                if ((res >> 3) == 0)
                    System.out.print("B ");
                else
                    System.out.print("C ");

                System.out.print("Pos Y: " + (((res & 0b111) << 1) | (res = fis.read()) >> 7) + " ");
                System.out.print("Pos X: " + ((res >> 3) & 0b1111) + " ");
                System.out.print("T: " + (res & 0b111));
                index++;
                System.out.println();
            }
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
