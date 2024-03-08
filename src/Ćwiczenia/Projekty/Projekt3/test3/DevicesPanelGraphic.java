package Ćwiczenia.Projekty.Projekt3.test3;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public
    class DevicesPanelGraphic
    extends JPanel {

    protected JScrollPane scrollPane;

    protected JButton addButton;

    protected JPanel devices;

    protected DevicesPanelListener logic;

    public DevicesPanelGraphic() {
        this.setLayout(new BorderLayout());
        this.setBorder(new TitledBorder("Broadcasting panel"));

        this.devices = new JPanel();
        this.devices.setLayout(new BoxLayout(this.devices, BoxLayout.Y_AXIS));

        this.scrollPane = new JScrollPane(this.devices);
        this.add(scrollPane, BorderLayout.CENTER);

        this.addButton = new JButton("ADD");
        this.add(this.addButton, BorderLayout.PAGE_END);
    }

    public void initListener(DevicesPanelListener listener){
        this.logic = listener;
    }

    protected void fireAddDevice(VBD device){
        if (this.logic != null){
            this.devices.add(device);
            logic.addDevice(device);
        }
    }
}
