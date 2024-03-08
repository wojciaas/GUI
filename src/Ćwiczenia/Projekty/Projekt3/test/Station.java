package Ćwiczenia.Projekty.Projekt3.test;

import javax.swing.*;

public
    class Station
    extends JPanel {

    protected JLabel idNumber;

    protected JLabel smsProcessed;

    protected JLabel pendingSms;

    private int idNum;

    protected int smsProcessedNum;

    protected int pendingSmsNum;


    public Station(int id) {
        this.idNum = id;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        idNumber = new JLabel(this.getClass().getSimpleName() + " number: " + idNum);
        this.add(idNumber);

        smsProcessedNum = 0;
        smsProcessed = new JLabel("Number of sms processed: " + smsProcessedNum);
        this.add(smsProcessed);

        pendingSmsNum = 0;
        pendingSms = new JLabel("Number of sms waiting to be sent: " + pendingSmsNum);
        this.add(pendingSms);
    }
}
