package Ćwiczenia.Projekty.Projekt1.test.zapisDoPliku;

import java.io.*;

public class zapis {
    public static void main(String[] args) {
        File pliczek = new File("C:\\Users\\Wojtek\\Desktop\\GUI\\src\\Ćwiczenia.Projekty.Projekt1.test\\zapisDoPliku\\Ćwiczenia.Projekty.Projekt1.test.bin");
        try{
            FileOutputStream fos = new FileOutputStream(pliczek);
            for (int i = 1, j = 0, l = 0; i <= 720 * 720; i++) {
                if (i == 0xFF || i == 0xFFFF){
                    fos.write('\n');
                    j++;
                    l = 0;
                }
                if (isPrime(i)){
                    for (int k = 0; k <= j; k++) {
                        fos.write(i >> 8 * k);
                    }
                    l++;
                }
            }
            fos.close();
        }catch(IOException e){
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fis = new FileInputStream(pliczek);
            int res, j = 0;
            while((res = fis.read()) != -1){
                if (res == '\n') {
                    System.out.println();
                    res = fis.read();
                    j++;
                }
                for (int i = 1; i <= j; i++) {
                    res |= fis.read() << 8 * i;
                }
                System.out.print(res + " ");
            }
            fis.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    private static boolean isPrime(int n){
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
