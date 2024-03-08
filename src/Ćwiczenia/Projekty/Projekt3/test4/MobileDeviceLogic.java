package Ćwiczenia.Projekty.Projekt3.test4;

import java.util.HashSet;

public
    class MobileDeviceLogic
    extends Thread
    implements MobileDeviceListener {

    protected volatile boolean running = true;

    private final int DEVICE_NO = generateDeviceNo();

    private static int numberGenerator = 100000000;

    public MobileDeviceLogic() {
        numberGenerator++;
    }

    @Override
    public int getDeviceNo() {
        return DEVICE_NO;
    }

    private int generateDeviceNo() {
        return numberGenerator;
    }
}
