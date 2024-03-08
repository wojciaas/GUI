package Ćwiczenia.Projekty.Projekt3.test3;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public
    class NetworkPanel
    extends JPanel {

    private BTSLayerGraphic btsLayerGraphicStart, btsLayerGraphicEnd;

    private StationLayer bcsLayers;

    private JPanel bcsPanel, buttons;

    private JButton addButton, removeButton;

    public NetworkPanel() {
        this.setBorder(new TitledBorder("Network panel"));
        this.setLayout(new BorderLayout());

        this.btsLayerGraphicStart = new BTSLayerGraphic();
        this.btsLayerGraphicStart.setPreferredSize(new Dimension(200, this.getHeight()));
        this.add(this.btsLayerGraphicStart, BorderLayout.LINE_START);

        this.buttons = new JPanel();
        this.buttons.setLayout(new FlowLayout());

        this.addButton = new JButton("ADD");
        this.buttons.add(this.addButton);
        this.removeButton = new JButton("REMOVE");
        this.buttons.add(this.removeButton);

        this.bcsPanel = new JPanel();
        this.bcsPanel.setBorder(new TitledBorder("BCS layers"));
        this.bcsPanel.setLayout(new BorderLayout());

        this.bcsLayers = new StationLayer();

        this.bcsPanel.add(this.bcsLayers, BorderLayout.CENTER);
        this.bcsPanel.add(this.buttons, BorderLayout.PAGE_END);

        this.add(this.bcsPanel);

        this.btsLayerGraphicEnd = new BTSLayerGraphic();
        this.btsLayerGraphicEnd.setPreferredSize(new Dimension(200, this.getHeight()));
        this.add(this.btsLayerGraphicEnd, BorderLayout.LINE_END);
    }
}
