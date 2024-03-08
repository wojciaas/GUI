package Ćwiczenia.Projekty.Projekt3.test3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public
    class BroadcastingPanelGraphic
    extends DevicesPanelGraphic {

    public BroadcastingPanelGraphic() {
        this.addButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fireAddDevice(new VBD());
                        devices.revalidate();
                        devices.repaint();
                    }
                }
        );
    }
}
