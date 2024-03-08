package Ćwiczenia.Projekty.Projekt3.test;

import javax.swing.*;
import java.awt.*;

public
    class test
    extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(test::new);
    }
    public test() {
        JPanel leftPanel = new JPanel(new BorderLayout());

        JTextArea ta1 = new JTextArea();
        JScrollPane sp = new JScrollPane(ta1);
        sp.setPreferredSize(new Dimension(120, 120));
        leftPanel.add(sp, BorderLayout.CENTER);

        JButton button = new JButton("click me");
        leftPanel.add(button, BorderLayout.PAGE_END);
        leftPanel.setBackground(Color.RED);
        this.getContentPane().add(leftPanel, BorderLayout.LINE_START);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.GREEN);
        this.getContentPane().add(rightPanel, BorderLayout.LINE_END);

        JPanel center = new JPanel();
        center.setBackground(Color.BLUE);
        this.getContentPane().add(center, BorderLayout.CENTER);

        this.setSize(640, 480);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
