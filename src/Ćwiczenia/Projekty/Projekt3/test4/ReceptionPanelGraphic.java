package Ćwiczenia.Projekty.Projekt3.test4;

public
    class ReceptionPanelGraphic
    extends DevicesPanelGraphic {

    private DevicesPanelListener<VRDListener> logic;

    public void initLogic(DevicesPanelListener<VRDListener> logic) {
        this.logic = logic;
    }
}
