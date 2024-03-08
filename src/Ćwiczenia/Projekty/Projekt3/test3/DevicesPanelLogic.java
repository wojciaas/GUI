package Ćwiczenia.Projekty.Projekt3.test3;

import java.util.concurrent.ConcurrentLinkedQueue;

public
    class DevicesPanelLogic
    implements DevicesPanelListener {

    protected ConcurrentLinkedQueue<VBD> queue;

    public DevicesPanelLogic() {
        this.queue = new ConcurrentLinkedQueue<>();
    }

    @Override
    public ConcurrentLinkedQueue<VBD> getVBD() {
        return this.queue;
    }

    @Override
    public void addDevice(VBD device) {
        this.queue.add(device);
    }
}
