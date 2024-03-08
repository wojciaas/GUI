package Ćwiczenia.Projekty.Projekt3.test;

import javax.swing.*;
import java.awt.*;

public
    class DevicesPanel
    extends JPanel {

    protected JScrollPane scrollPane;

    protected JButton addButton;

    protected JPanel devices;

    public DevicesPanel() {
        this.setLayout(new BorderLayout());

        devices = new JPanel();
        scrollPane = new JScrollPane();
        scrollPane.add(devices);
        this.add(scrollPane, BorderLayout.CENTER);

        addButton = new JButton("ADD");
        this.add(addButton, BorderLayout.PAGE_END);
    }
}
