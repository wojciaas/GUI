package Ćwiczenia.Projekty.Projekt3.test3;

import java.util.concurrent.ConcurrentLinkedQueue;

interface DevicesPanelListener {
    ConcurrentLinkedQueue<VBD> getVBD();

    void addDevice(VBD device);
}
