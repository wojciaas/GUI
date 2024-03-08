package Ćwiczenia.Projekty.Projekt3.test3;

import javax.swing.*;
import java.awt.*;

public
    class S27994Projekt03
    extends JFrame {

    private BroadcastingPanelGraphic broadcastPanelGraphic;

    private DevicesPanelLogic broadcastPanelLogic;

    private NetworkPanel networkPanel;

    private ReceptionPanelGraphic receptionPanelGraphic;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(S27994Projekt03::new);
    }

    public S27994Projekt03() {
        this.setTitle("GSM network");
        this.setSize(1200, 480);

        this.broadcastPanelGraphic = new BroadcastingPanelGraphic();
        this.broadcastPanelLogic = new DevicesPanelLogic();
        this.broadcastPanelGraphic.initListener(this.broadcastPanelLogic);
        this.broadcastPanelGraphic.setPreferredSize(new Dimension(200, this.getHeight()));
        this.getContentPane().add(this.broadcastPanelGraphic, BorderLayout.LINE_START);

        this.networkPanel = new NetworkPanel();
        this.getContentPane().add(this.networkPanel);

        receptionPanelGraphic = new ReceptionPanelGraphic();
        this.receptionPanelGraphic.setPreferredSize(new Dimension(200, this.getHeight()));
        this.getContentPane().add(this.receptionPanelGraphic, BorderLayout.LINE_END);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
