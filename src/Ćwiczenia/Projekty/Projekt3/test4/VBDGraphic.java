package Ćwiczenia.Projekty.Projekt3.test4;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public
    class VBDGraphic
    extends MobileDeviceGraphic {

    private VBDListener logic;

    private JSlider frequency;

    private JLabel freqDescription, deviceNo, statusDescription;

    private JComboBox<Status> status;

    public VBDGraphic() {
        this.setBorder(new TitledBorder("VBD device"));
        this.setLayout(new GridLayout(4, 2));
        this.setMinimumSize(new Dimension(300, 170));
        this.setMaximumSize(new Dimension(300, 170));

        this.deviceNo = new JLabel("VBD number");
        this.add(this.deviceNo);

        super.deviceNo = new JTextField();
        super.deviceNo.setEditable(false);
        super.deviceNo.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(super.deviceNo);

        this.freqDescription = new JLabel("<html>Message sending frequency</html>");
        this.add(this.freqDescription);

        this.frequency = new JSlider(1, 10, 5);
        this.frequency.setMajorTickSpacing(1);
        this.frequency.setMinorTickSpacing(1);
        this.frequency.setPaintLabels(true);
        this.frequency.setPaintTicks(true);
        this.frequency.addChangeListener(
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        logic.changeFreq(frequency.getValue());
                    }
                }
        );
        this.add(this.frequency);

        this.statusDescription = new JLabel("VBD status");
        this.add(this.statusDescription);

        this.status = new JComboBox<>(Status.values());
        this.status.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        logic.changeStatusValue((Status) status.getSelectedItem());
                    }
                }
        );
        this.add(this.status);

        this.add(this.stopDevice);
        this.add(this.terminateDevice);
        this.terminateDevice.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fireStopDevice();
                    }
                }
        );
    }

    public VBDGraphic initLogic(VBDListener logic) {
        this.logic = logic;
        this.logic.encryptMessage(JOptionPane.showInputDialog(null, "Type your message", "Message", JOptionPane.QUESTION_MESSAGE));
        super.deviceNo.setText(String.valueOf(this.logic.getDeviceNo()));
        this.logic.changeFreq(this.frequency.getValue());
        this.status.setSelectedItem(Status.ACTIVE);
        this.logic.changeStatusValue((Status) this.status.getSelectedItem());
        this.validate();
        this.repaint();
        return this;
    }

    private void fireStopDevice() {
        if (this.logic != null && this.panelManager != null) {
            this.logic.stopDevice();
            this.panelManager.terminateDevice();
        }
    }

    public void initPanelManager(DevicePanelManager manager) {
        this.panelManager = manager;
    }
}
