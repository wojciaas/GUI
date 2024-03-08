package Ćwiczenia.cw1;

import java.awt.*;

public
    class cw1
    extends Frame {
    public static void main(String[] args) {
        new cw1();
    }
    public cw1(){
        super();
        this.setSize(640,480);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int circlesCount = 10,
            diameter = (this.getWidth() < getHeight() ? this.getWidth() : this.getHeight()) / circlesCount;
        for (int i = 0; i < circlesCount; i++) {
            for (int j = 0; j < circlesCount; j++) {
                g.drawOval((j*diameter),(i*diameter),diameter,diameter);
            }
        }
    }
}
