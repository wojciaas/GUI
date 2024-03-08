package Ćwiczenia.cw10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public
    class Main
    extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    public Main(){
        LeftPanel leftPanel = new LeftPanel();
        this.getContentPane().add(leftPanel, BorderLayout.LINE_START);

        RightPanel rightPanel = new RightPanel();
        this.getContentPane().add(rightPanel, BorderLayout.LINE_END);

        rightPanel.addChangeColorListener(leftPanel);
        leftPanel.addChangeColorListener(rightPanel);

        this.setSize( 640, 480);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
