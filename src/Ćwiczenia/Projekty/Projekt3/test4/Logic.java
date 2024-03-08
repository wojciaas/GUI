package Ćwiczenia.Projekty.Projekt3.test4;

public
    class Logic
    implements ConnectionInter {

    private BroadcastingPanelLogic broadcastingPanel;

    private ReceptionPanelLogic receptionPanel;

    public Logic() {
        this.broadcastingPanel = new BroadcastingPanelLogic();
        this.receptionPanel = new ReceptionPanelLogic();
    }

    @Override
    public DevicesPanelListener getBroadcastingPanelListener() {
        return this.broadcastingPanel;
    }

    @Override
    public DevicesPanelListener getReceptionPanelListener() {
        return this.receptionPanel;
    }
}
