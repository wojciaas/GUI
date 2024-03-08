package Ćwiczenia.Projekty.Projekt3.test4;

public
    class ReceptionPanelLogic
    extends DevicesPanelLogic<VRDLogic>
    implements DevicesPanelListener<VRDLogic>{

    @Override
    public void addDevice() {
        this.synchronizedDevices.add(new VRDLogic());
    }

    @Override
    public void removeDevice() {

    }

    @Override
    public VRDLogic getAddedDevice() {
        return this.synchronizedDevices.get(this.synchronizedDevices.size() - 1);
    }
}
