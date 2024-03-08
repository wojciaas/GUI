package Ćwiczenia.Projekty.Projekt3.test2;

import javax.swing.*;
import java.awt.*;

public
    class DevicesPanel
    extends JPanel{

    private JScrollPane scrollPane;

    protected JButton addButton;

    protected JPanel devices;

    public DevicesPanel() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(300, 640));

        this.devices = new JPanel();
        this.devices.setLayout(new BoxLayout(this.devices, BoxLayout.Y_AXIS));
        this.scrollPane = new JScrollPane(this.devices);
        this.add(this.scrollPane, BorderLayout.CENTER);

        this.addButton = new JButton("ADD");
        this.add(this.addButton, BorderLayout.PAGE_END);
    }
}
