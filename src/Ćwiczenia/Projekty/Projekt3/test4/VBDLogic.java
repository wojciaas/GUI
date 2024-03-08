package Ćwiczenia.Projekty.Projekt3.test4;

public
    class VBDLogic
    extends MobileDeviceLogic
    implements VBDListener {

    private Status status;

    private String message;

    private int freq;

    private int destNumber;

    public VBDLogic() {
        this.status = Status.WAITING;
        this.start();
    }

    @Override
    public void changeStatusValue(Status status) {
        if (this.status.equals(Status.ACTIVE))
            synchronized (this) {
                this.notify();
            }
        this.status = status;
    }

    @Override
    public void changeFreq(int freq) {
        this.freq = freq;
    }

    //TODO: zrobic kryprowanie wiadomosci
    @Override
    public void encryptMessage(String message) {
        StringBuilder encryptedMessage = new StringBuilder();

        //this.message = String.valueOf(encryptedMessage);
        this.message = message;
    }

    @Override
    public void stopDevice() {
        this.running = false;
    }

    @Override
    public synchronized void run() {
        while (this.running) {
            if (this.status.equals(Status.WAITING)) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(message);
            try {
                this.sleep(freq * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
