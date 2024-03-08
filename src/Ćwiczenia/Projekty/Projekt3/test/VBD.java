package Ćwiczenia.Projekty.Projekt3.test;

import javax.swing.*;

public
    class VBD
    extends JPanel {

    enum Status{
        WAITING, ACTIVE
    }

    private JSlider smsFrequency;

    private JButton stop;

    private JTextField deviceNumber;

    private JComboBox<Status> status;

    private int deviceID;

    private static int ID = 0;

    public VBD() {
        deviceID = ID;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        smsFrequency = new JSlider();
        this.add(smsFrequency);

        stop = new JButton("STOP");
        this.add(stop);

        deviceNumber = new JTextField(deviceID);
        deviceNumber.setEditable(false);
        this.add(deviceNumber);

        status = new JComboBox<>();
        this.add(status);

        ID++;
    }
}
