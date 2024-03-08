package Ćwiczenia.Projekty.Projekt3.test4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public
    class DevicesPanelGraphic
    extends JPanel {

    protected JScrollPane scrollPane;

    protected JButton addButton;

    protected JPanel devices;

    public DevicesPanelGraphic() {
        this.setLayout(new BorderLayout());

        this.devices = new JPanel();
        this.devices.setLayout(new BoxLayout(this.devices, BoxLayout.Y_AXIS));

        this.scrollPane = new JScrollPane(this.devices);
        this.add(scrollPane, BorderLayout.CENTER);

        this.addButton = new JButton("ADD");
        this.add(this.addButton, BorderLayout.PAGE_END);
    }


}
