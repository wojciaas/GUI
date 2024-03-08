package Ćwiczenia.cw9.z1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public
    class Letters
    extends Thread
    implements Iterable<Thread>{

    private ArrayList<Thread> threads;
    private boolean status;

    private int lastIndex;

    public Letters(String letters) {
        this.threads = new ArrayList<>();
        this.status = true;

        for (char ch : letters.toCharArray()){
            this.threads.add(
                    new Thread("Thread " + ch){
                        @Override
                        public void run() {
                            super.run();
                        }

                    }
            );
        }
    }

    public void start(){
        for (Thread t : this) {
            t.start();
        }
    }




    @Override
    public Iterator<Thread> iterator() {
        return this.threads.iterator();
    }

}
