package Ćwiczenia.Projekty.Projekt3.test4;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public
    class Graphic
    extends JPanel {

    private BroadcastingPanelGraphic broadcastingPanel;

    private ReceptionPanelGraphic receptionPanel;

    private NetworkPanel networkPanel;

    private ConnectionInter logic;

    public Graphic() {
        this.setLayout(new BorderLayout());

        this.broadcastingPanel = new BroadcastingPanelGraphic();
        this.broadcastingPanel.setBorder(new TitledBorder("Broadcasting panel"));
        this.broadcastingPanel.setPreferredSize(new Dimension(300, this.getHeight()));
        this.add(this.broadcastingPanel, BorderLayout.LINE_START);

        this.networkPanel = new NetworkPanel();
        this.networkPanel.setBorder(new TitledBorder("Network panel"));
        this.add(this.networkPanel, BorderLayout.CENTER);

        this.receptionPanel = new ReceptionPanelGraphic();
        this.receptionPanel.setBorder(new TitledBorder("Reception panel"));
        this.receptionPanel.setPreferredSize(new Dimension(300, this.getHeight()));
        this.add(this.receptionPanel, BorderLayout.LINE_END);
    }

    public void initLogic(ConnectionInter logic) {
        this.logic = logic;
        this.broadcastingPanel.initLogic(this.logic.getBroadcastingPanelListener());
        this.receptionPanel.initLogic(this.logic.getReceptionPanelListener());
    }
}
