package Ćwiczenia.Projekty.Projekt3.test3;

import Ćwiczenia.Projekty.Projekt3.test2.Status;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public
    class VBD
    extends JPanel{

    private JSlider smsSendFreq;

    private JButton stopButton;

    private JTextField number;

    private JComboBox<Status> status;

    private String message;

    public VBD() {
        this.message = JOptionPane.showInputDialog(null, "Type message", "Message", JOptionPane.QUESTION_MESSAGE);
        System.out.println(message);
        this.setLayout(new GridLayout(4, 2));
        this.setBorder(new TitledBorder("VBD Device"));
        this.setPreferredSize(new Dimension(150, 200));

        this.add(new JLabel("SMS frequency"));
        this.smsSendFreq = new JSlider();
        this.smsSendFreq.setPaintTicks(true);
        this.smsSendFreq.setPaintLabels(true);
        this.add(this.smsSendFreq);

        this.add(new JLabel("Device number"));
        this.number = new JTextField("123456789");
        this.number.setHorizontalAlignment(JTextField.CENTER);
        this.number.setEditable(false);
        this.add(this.number);

        this.add(new JLabel("Status"));
        this.status = new JComboBox<>(Status.values());
        this.status.setSelectedItem(Status.ACTIVE);
        this.add(this.status);

        this.add(new JLabel("<html>Stop and remove device button</html>"));
        this.stopButton = new JButton("STOP");
        this.add(this.stopButton);
    }
}
