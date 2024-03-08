package Ćwiczenia.cw2.zad02;

public
    class Concat
    implements TwoStringsOper{

    @Override
    public String apply(String s1, String s2) {
        return s1.concat(s2);
    }
}
