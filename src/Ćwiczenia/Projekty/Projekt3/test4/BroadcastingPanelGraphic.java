package Ćwiczenia.Projekty.Projekt3.test4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public
    class BroadcastingPanelGraphic
    extends DevicesPanelGraphic {

    private DevicesPanelListener<VBDListener> logic;

    public BroadcastingPanelGraphic() {
        this.addButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fireAddDevice();
                    }
                }
        );
    }

    public void initLogic(DevicesPanelListener<VBDListener> logic){
        this.logic = logic;
    }

    private void fireAddDevice() {
        if (this.logic != null) {
            this.logic.addDevice();
            VBDGraphic device = new VBDGraphic().initLogic(this.logic.getAddedDevice());
            device.initPanelManager(new DevicePanelManager() {
                @Override
                public void terminateDevice() {
                    devices.remove(device);
                    devices.revalidate();
                    devices.repaint();
                }
            });
            this.devices.add(device);
            this.devices.revalidate();
            this.devices.repaint();
        }
    }
}
