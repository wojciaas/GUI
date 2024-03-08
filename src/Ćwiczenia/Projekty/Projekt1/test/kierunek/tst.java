package Ćwiczenia.Projekty.Projekt1.test.kierunek;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class tst
    extends Frame {
    private final int SIZE;
    private final File PLIK = new File("plik.bin");
    private static final int[][] DIRECTIONS = {
            {1, 0},
            {0, -1},
            {-1, 0},
            {0, 1}
    };

    public tst(int width, int height){
        super();
        this.setSize(width,height);
        SIZE = Math.min(width, height);
        this.setVisible(true);
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
        new tst(72,180);
    }

    public void paint(Graphics g) {
        super.paint(g);

        int currDir = 0;
        int stepsToReach = 1;
        int currSteps = 0;
        int x = getWidth() / 2;
        int y = (getHeight() + insets().top) / 2;

        try {
            FileInputStream fis = new FileInputStream(PLIK);
            int res = fis.read();
            byte bytes = 0;
            boolean newLine = true, nextNum = false;
            for (int i = 1; i <= (int)Math.pow(SIZE*10,2) + bytes; i++) {

                if (res == '\n'){
                    res = fis.read();
                    bytes++;
                    newLine = true;
                }

                if (newLine){
                    for (int j = 1; j < 8; j++) {
                        res |= fis.read() << 8 * j;
                    }
                    newLine = false;
                    nextNum = true;
                    res = fis.read();
                } else if(nextNum) {
                    for (int j = 1; j <= bytes; j++) {
                        res |= fis.read() << 8 * j;
                    }
                    nextNum = false;
                }

                if (i == res){
                    g.fillRect(x,y,1,1);
                    res = fis.read();
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
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
