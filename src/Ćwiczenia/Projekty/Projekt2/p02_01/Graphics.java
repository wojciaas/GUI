package Ćwiczenia.Projekty.Projekt2.p02_01;

import java.awt.*;

public
    class Graphics
    extends Frame {

    Inter inter;

    public void init(Inter inter){
        this.inter = inter;
    }

    public void myShow(){
        if(inter != null)
            for(int i=0; i<inter.getHeight(); i++){
                for(int j=0; j<inter.getWidth(); j++){
                    System.out.print(inter.getElementAt(i, j));
                }
                System.out.println();
            }
    }

    @Override
    public void paint(java.awt.Graphics g) {
        super.paint(g);

        if(inter != null)
            for(int i=0; i<inter.getHeight(); i++){
                for(int j=0; j<inter.getWidth(); j++){
                    if( (i+j)%2 == 0)
                        g.setColor(Color.DARK_GRAY);
                    else
                        g.setColor(Color.LIGHT_GRAY);
                    g.fillRect( (i+1)*40, (j+1)*40, 40, 40);

                    g.setColor(Color.MAGENTA);
                    g.drawString(""+inter.getElementAt(j, i), (i+1)*40, (j+2)*40);
                }
            }
    }
}
