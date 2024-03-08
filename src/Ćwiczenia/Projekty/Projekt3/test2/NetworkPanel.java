package Ćwiczenia.Projekty.Projekt3.test2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public
    class NetworkPanel
    extends JPanel {

    private Station btsStart, btsEnd, bcsStart;

    private JScrollPane bcsScrollPane;

    private JPanel middleContainer, bcsContainer, buttonsContainer;

    private JButton addButton, removeButton;

    public NetworkPanel() {
        this.setBorder(new TitledBorder("Network Panel"));
        this.setPreferredSize(new Dimension(700, 640));
        this.setLayout(new BorderLayout());

        this.btsStart = new Station();
        this.add(this.btsStart, BorderLayout.LINE_START);

        this.middleContainer = new JPanel();
        this.middleContainer.setLayout(new BorderLayout());
        this.bcsContainer = new JPanel();
        this.bcsContainer.setLayout(new FlowLayout());
        this.bcsStart = new Station();
        this.bcsContainer.add(this.bcsStart);
        this.bcsScrollPane = new JScrollPane(this.bcsContainer);
        this.middleContainer.add(this.bcsScrollPane, BorderLayout.CENTER);

        this.buttonsContainer = new JPanel();
        this.buttonsContainer.setLayout(new GridLayout(1, 2));
        this.addButton = new JButton("ADD");
        this.buttonsContainer.add(this.addButton);
        this.removeButton = new JButton("REMOVE");
        this.buttonsContainer.add(this.removeButton);
        this.middleContainer.add(this.buttonsContainer, BorderLayout.PAGE_END);

        this.add(this.middleContainer, BorderLayout.CENTER);

        this.btsEnd = new Station();
        this.add(this.btsEnd, BorderLayout.LINE_END);
    }
}
