package Ćwiczenia.Projekty.Projekt3.test4;

import javax.swing.*;
import java.awt.*;

public
    class MobileDeviceGraphic
    extends JPanel {

    protected JButton terminateDevice;

    protected JTextField deviceNo;

    protected JLabel stopDevice;

    protected DevicePanelManager panelManager;

    public MobileDeviceGraphic() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(180, 100));
        this.terminateDevice = new JButton("TERMINATE");
        this.stopDevice = new JLabel("<html>Stop and terminate the device</html>");
    }
}
