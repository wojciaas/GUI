package Ćwiczenia.Projekty.Projekt3.test;

import javax.swing.*;
import java.awt.*;

public
    class NetworkPanel
    extends JPanel {

    private JPanel bcsManager;

    private BTS b1;

    private BTS b2;

    private BCS bcs1;

    private JPanel buttons;

    private JButton addButton;

    private JButton removeButton;

    public NetworkPanel() {
        this.setLayout(new BorderLayout());

        b1 = new BTS();
        this.add(b1, BorderLayout.LINE_START);

        bcsManager = new JPanel();
        bcs1 = new BCS();
        bcsManager.add(bcs1);
        this.add(bcsManager, BorderLayout.CENTER);

        buttons = new JPanel();
        addButton = new JButton("ADD BCS");
        buttons.add(addButton);
        removeButton = new JButton("REMOVE BCS");
        buttons.add(removeButton);
        this.add(buttons, BorderLayout.PAGE_END);

        b2 = new BTS();
        this.add(b2, BorderLayout.LINE_END);
    }
}
