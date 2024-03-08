package Ćwiczenia.Projekty.Projekt3.test2;

import javax.swing.*;
import java.awt.*;

public
    class GraphicsLayer
    extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GraphicsLayer::new);
    }

    public GraphicsLayer() {
        this.setTitle("GSM Network");

        BroadcastingPanel broadcastingDevices = new BroadcastingPanel();
        this.getContentPane().add(broadcastingDevices, BorderLayout.LINE_START);

        NetworkPanel networkPanel = new NetworkPanel();
        this.getContentPane().add(networkPanel, BorderLayout.CENTER);

        ReceptionPanel receptionPanel = new ReceptionPanel();
        this.getContentPane().add(receptionPanel, BorderLayout.LINE_END);

        this.setSize(1300, 640);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
