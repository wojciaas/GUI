package Ćwiczenia.Projekty.Projekt3.test4;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public
    class NetworkPanel
    extends JPanel {

    private StationLayerGraphic btsLayerGraphicStart, btsLayerGraphicEnd, bscLayersGraphic;

    private JPanel bscPanel, buttons;

    private JButton addButton, removeButton;

    public NetworkPanel() {
        this.setBorder(new TitledBorder("Network panel"));
        this.setLayout(new BorderLayout());

        this.btsLayerGraphicStart = new StationLayerGraphic();
        this.btsLayerGraphicStart.setBorder(new TitledBorder("BTS layer"));
        this.btsLayerGraphicStart.setPreferredSize(new Dimension(200, this.getHeight()));
        this.add(this.btsLayerGraphicStart, BorderLayout.LINE_START);

        this.buttons = new JPanel();
        this.buttons.setLayout(new FlowLayout());

        this.addButton = new JButton("ADD");
        this.buttons.add(this.addButton);
        this.removeButton = new JButton("REMOVE");
        this.buttons.add(this.removeButton);

        this.bscPanel = new JPanel();
        this.bscPanel.setBorder(new TitledBorder("BSC layers"));
        this.bscPanel.setLayout(new BorderLayout());

        this.bscLayersGraphic = new StationLayerGraphic();

        this.bscPanel.add(this.bscLayersGraphic, BorderLayout.CENTER);
        this.bscPanel.add(this.buttons, BorderLayout.PAGE_END);

        this.add(this.bscPanel);

        this.btsLayerGraphicEnd = new StationLayerGraphic();
        this.btsLayerGraphicEnd.setBorder(new TitledBorder("BTS layer"));
        this.btsLayerGraphicEnd.setPreferredSize(new Dimension(200, this.getHeight()));
        this.add(this.btsLayerGraphicEnd, BorderLayout.LINE_END);
    }
}
