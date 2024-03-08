package Ćwiczenia.Projekty.Projekt3.test4;

public
    interface VBDListener
    extends MobileDeviceListener {

    void changeStatusValue(Status status);

    void changeFreq(int freq);

    void encryptMessage(String message);

    void stopDevice();
}
