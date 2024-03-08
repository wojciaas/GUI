package Ćwiczenia.Projekty.Projekt3.test3;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public
    class VRD
    extends JPanel {

    private JButton stopButton;

    private JLabel smsReceived;

    private JCheckBox resetSmsReceivedNum;

    public VRD() {
        //this.setLayout(new GridLayout(3, 2));
        this.setBorder(new TitledBorder("VBD Device"));
        this.setPreferredSize(new Dimension(250, 200));

        this.add(new JLabel("<html>Number of sms received</html>"));
        smsReceived = new JLabel("0");
        this.add(smsReceived);

        this.add(new JLabel("<html>Reset number of sms received every 10 sec</html>"));
        resetSmsReceivedNum = new JCheckBox();
        this.add(resetSmsReceivedNum);

        this.add(new JLabel("<html>Stop and remove device button</html>"));
        stopButton = new JButton("STOP");
        this.add(stopButton);
    }
}
