package Ćwiczenia.Projekty.Projekt1;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public
    class S27994
    extends Frame {

    private int size;

    public S27994(int rozmiar){
        super();
        this.setSize(rozmiar,rozmiar);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        File binary = new File("projekt.bin");
        new S27994(72);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(getWidth()/2,getHeight()/2,1,1);
    }

    private static boolean isPrime(int n){
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    private void writeFile(File file){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            for (int i = 1; i < this.getWidth() * this.getHeight() * 100; i++) {

            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
