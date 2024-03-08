package Ćwiczenia.cw2.zad03;

public
abstract class Singer {
    protected String name;
    protected int singerId;
    private static int id = 0;

    public Singer(String name){
        this.name = name;
        singerId = ++id;
    }

    abstract String sing();
    public String toString(){
        return "(" + singerId + ") " + name + ": " + sing();
    }
    static Singer loudest(Singer[] singers){
        Singer theLoudest = singers[0];
        int uppersCounter = 0;
        int previous;
        for (Singer s : singers){
            previous = uppersCounter;
            uppersCounter = 0;
            for (int i = 0; i < s.sing().length(); i++) {
                if (s.sing().charAt(i) >= 'A' && s.sing().charAt(i) <= 'Z') uppersCounter++;
            }
            if (uppersCounter > previous){
                theLoudest = s;
            }
        }
        return theLoudest;
    }
}
