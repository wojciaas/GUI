package Ćwiczenia.cw8;

import java.util.Iterator;

public
    class Letters
    extends Thread
    implements Iterable<Thread>{

    private Thread[] arr;

    private int lastIndex;

    public Letters(String letters) {
        this.lastIndex = 0;
        this.arr = new Thread[letters.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Thread(String.valueOf(letters.charAt(i)));
            lastIndex++;
        }
    }

    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i < arr.length; i++) {
                arr[i].start();
            }
        }
    }

    @Override
    public Iterator<Thread> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < lastIndex;
            }

            @Override
            public Thread next() {
                return arr[index++];
            }
        };
    }

}
