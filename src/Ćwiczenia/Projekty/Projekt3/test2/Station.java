package Ćwiczenia.Projekty.Projekt3.test2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public
    class Station
    extends JPanel {

    private JLabel stationNumber;

    private JLabel smsProcessed;

    private JLabel smsPending;

    public Station() {
        this.setBorder(new TitledBorder("Device"));
        this.setLayout(new GridLayout(3, 2));
        this.setPreferredSize(new Dimension(150, 530));

        this.add(new JLabel("<html>Station number</html>"));
        this.stationNumber = new JLabel("0");
        this.stationNumber.setHorizontalAlignment(JLabel.CENTER);
        this.add(this.stationNumber);

        this.add(new JLabel("<html>Number of sms processed</html>"));
        this.smsProcessed = new JLabel("0");
        this.smsProcessed.setHorizontalAlignment(JLabel.CENTER);
        this.add(this.smsProcessed);

        this.add(new JLabel("<html>Number of pending sms</html>"));
        this.smsPending = new JLabel("0");
        this.smsPending.setHorizontalAlignment(JLabel.CENTER);
        this.add(this.smsPending);
    }
}
