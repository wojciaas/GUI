package Ćwiczenia.cw2.zad02;

public
    class ConcatRev
    implements TwoStringsOper{

    @Override
    public String apply(String s1, String s2) {
        return s2.concat(s1);
    }
}
