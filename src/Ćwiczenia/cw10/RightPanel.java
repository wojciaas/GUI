package Ćwiczenia.cw10;


import Ćwiczenia.cw10.exent.ChangeColorListener;
import Ćwiczenia.cw10.exent.ColorEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public
    class RightPanel
    extends JPanel
    implements ChangeColorListener {

    protected JButton button;

    public RightPanel() {
        this.setBackground(Color.RED);
        this.setPreferredSize(new Dimension( 300, 300));

        this.button = new JButton("click");
        this.add(button);

        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fireColorSet(
                                    new Color(
                                        (int)(Math.random()*255),
                                        (int)(Math.random()*255),
                                        (int)(Math.random()*255)
                                    )
                        );
                    }
                }
        );
    }

    private ArrayList<ChangeColorListener> listeners = new ArrayList<>();

    public void addChangeColorListener(ChangeColorListener listener){
        this.listeners.add(listener);
    }

    public void removeChangeColorListener(ChangeColorListener listener){
        this.listeners.remove(listener);
    }

    public void fireColorSet(Color color){
        ColorEvent evt = new ColorEvent( this, color);
        for(ChangeColorListener listener : listeners)
            listener.colorSet(evt);
    }

    @Override
    public void colorSet(ColorEvent evt) {
        this.setBackground(evt.getColor());
    }
}
