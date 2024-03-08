package Ćwiczenia.Projekty.Projekt1.test.zapisDoPliku;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class czystyTest {
    public static void main(String[] args) {
        File plik = new File("plik.bin");
        try{
            FileOutputStream fos = new FileOutputStream("plik.bin",true);
            ArrayList<Integer> row = new ArrayList<>();
            int size = 720*720;
            boolean newLine = true;
            byte bytes = 1;
            int border = (int)Math.pow(2,8*bytes),
                counter = 0;
            for (int i = 1; i <= size; i++) {
                if (i == border){
                    fos.write('\n');
                    bytes++;
                    border = (int)Math.pow(2,8*bytes);
                    newLine = true;
                }
                if (newLine){
                    for (int j = i; j <= (Math.min(border, size)); j++) {
                        if (isPrime(j)){
                            row.add(j);
                            counter++;
                        }
                    }
                    for (int j = 0; j < 8; j++) {
                        fos.write(counter >> 8 * j);
                    }
                    for (Integer integer : row) {
                        for (int k = 0; k <= bytes - 1; k++) {
                            fos.write(integer >> 8 * k);
                        }
                    }
                    counter = 0;
                    newLine = false;
                    row.clear();
                }
            }
            fos.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        try{
            FileInputStream fis = new FileInputStream(plik);
            int res;
            byte bytes = 0;
            boolean newLine = true;
            while ((res = fis.read()) != -1){
                if (res == '\n'){
                    System.out.println();
                    res = fis.read();
                    bytes++;
                    newLine = true;
                }
                if (newLine){
                    for (int i = 1; i < 8; i++) {
                        res |= fis.read() << 8 * i;
                    }
                    newLine = false;
                } else {
                    for (int i = 1; i <= bytes; i++) {
                        res |= fis.read() << 8 * i;
                    }
                }
                System.out.print(res + " ");
            }
            fis.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public static boolean isPrime(int n){
        if(n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}