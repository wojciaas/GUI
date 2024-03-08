package Ćwiczenia.Projekty.Projekt3.test4;

import javax.swing.*;

public
    class S27994Projekt03
    extends JFrame {

    private Graphic graphic;

    private Logic logic;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(S27994Projekt03::new);
    }

    public S27994Projekt03() {
        this.setTitle("GSM network");
        this.setSize(1200, 480);

        this.logic = new Logic();
        this.graphic = new Graphic();

        this.graphic.initLogic(logic);
        this.getContentPane().add(this.graphic);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
