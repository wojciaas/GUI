package Ćwiczenia.Projekty.Projekt3.test4;

public
    class BroadcastingPanelLogic
    extends DevicesPanelLogic<VBDListener>
    implements DevicesPanelListener<VBDListener>{


    @Override
    public void addDevice() {
        this.synchronizedDevices.add(new VBDLogic());
    }

    @Override
    public void removeDevice() {

    }

    @Override
    public VBDListener getAddedDevice() {
        return this.synchronizedDevices.get(this.synchronizedDevices.size() - 1);
    }
}
