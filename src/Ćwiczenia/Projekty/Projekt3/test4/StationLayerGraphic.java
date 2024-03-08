package Ćwiczenia.Projekty.Projekt3.test4;

import javax.swing.*;

public
    class StationLayerGraphic
    extends JPanel {

    private JScrollPane scrollPane;

    protected JPanel devices;

    public StationLayerGraphic() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.devices = new JPanel();
        this.devices.setLayout(new BoxLayout(this.devices, BoxLayout.Y_AXIS));
        this.scrollPane = new JScrollPane(devices);
        this.add(this.scrollPane);
    }
}
