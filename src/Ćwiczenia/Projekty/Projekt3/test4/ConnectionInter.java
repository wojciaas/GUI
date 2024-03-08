package Ćwiczenia.Projekty.Projekt3.test4;

public
    interface ConnectionInter {

    DevicesPanelListener<VBDListener> getBroadcastingPanelListener();

    DevicesPanelListener<VRDListener> getReceptionPanelListener();
}
