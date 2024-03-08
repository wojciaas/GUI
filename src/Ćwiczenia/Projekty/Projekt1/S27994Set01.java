package Ćwiczenia.Projekty.Projekt1;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public
    class S27994Set01
    extends Frame {
    private final File BINARY_FILE = new File("pliczunio.bin");
    private final int SIZE;
    private static final int[][] DIRECTIONS = {
            {1, 0},
            {0, -1},
            {-1, 0},
            {0, 1}
    };
    public S27994Set01(int width, int height){
        super();
        this.setSize(width,height);
        SIZE = Math.min(width,height);
        this.setVisible(true);
        this.writeBinaryFile();
        this.addComponentListener(
                new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        super.componentResized(e);
                        repaint();
                    }
                }
        );
        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        System.exit(0);
                    }
                }
        );
    }

    public static void main(String[] args) {
        new S27994Set01(72,180);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int stepsToReach = 1,
            currSteps = 0,
            currDir = 0,
            x = getWidth() / 2,
            y = (getHeight() + insets().top) / 2;

        try {
            FileInputStream fis = new FileInputStream(BINARY_FILE);

            int result = fis.read();
            byte bytes = 0;
            boolean newLine = true,
                    nextNum = false;

            for (int i = 1; i <= (int)Math.pow(SIZE*10,2); i++) {

                if (result == '\n'){
                    result = fis.read();
                    bytes++;
                    newLine = true;
                }

                if (newLine){
                    for (int j = 1; j < 8; j++) {
                        result |= fis.read() << 8 * j;
                    }
                    newLine = false;
                    nextNum = true;
                    result = fis.read();
                } else if (nextNum) {
                    for (int j = 1; j <= bytes; j++) {
                        result |= fis.read() << 8 * j;
                    }
                    nextNum = false;
                }

                if (i == result){
                    g.fillRect(x,y,1,1);
                    result = fis.read();
                    nextNum = true;
                }

                x += DIRECTIONS[currDir%4][0];
                y += DIRECTIONS[currDir%4][1];

                currSteps++;

                if (currSteps == stepsToReach) {
                    currSteps = 0;
                    currDir++;
                    if (currDir % 2 == 0) {
                        stepsToReach++;
                    }
                }
            }
            fis.close();
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    private void writeBinaryFile(){
        try {
            FileOutputStream fos = new FileOutputStream(BINARY_FILE);

            ArrayList<Integer> row = new ArrayList<>();
            boolean newLine = true;
            byte bytes = 1;
            int counter = 0;

            for (int i = 1; i <= (int)Math.pow(SIZE*10,2); i++) {

                if (i == (int)Math.pow(2,8 * bytes)){
                    fos.write('\n');
                    bytes++;
                    newLine = true;
                }

                if (newLine){
                    for (int j = i; j <= Math.min((int)Math.pow(SIZE*10,2),(int)Math.pow(2,8 * bytes)); j++) {
                        if (isPrime(j)){
                            row.add(j);
                            counter++;
                        }
                    }
                    for (int j = 0; j < 8; j++) {
                        fos.write(counter >> 8 * j);
                    }
                    for (Integer number : row){
                        for (int j = 0; j <= bytes - 1; j++) {
                            fos.write(number >> 8 * j);
                        }
                    }
                    counter = 0;
                    newLine = false;
                    row.clear();
                }
            }
            fos.close();
        } catch(IOException e){
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