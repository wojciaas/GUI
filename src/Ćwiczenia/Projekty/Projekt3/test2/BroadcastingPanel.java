package Ćwiczenia.Projekty.Projekt3.test2;

import Ćwiczenia.Projekty.Projekt3.test3.VBD;

import javax.swing.border.TitledBorder;

public
    class BroadcastingPanel
    extends DevicesPanel{

    public BroadcastingPanel() {
        super();
        this.setBorder(new TitledBorder("Broadcasting panel"));
        this.devices.add(new VBD());
        this.devices.add(new VBD());
        this.devices.add(new VBD());
        this.devices.add(new VBD());
        this.devices.add(new VBD());
        this.devices.add(new VBD());
        this.devices.add(new VBD());

    }
}
