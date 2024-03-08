package Ćwiczenia.cw2.zad02;

public
    class Separ
    implements TwoStringsOper{
    private String sep;

    public Separ(String sep){
        this.sep = sep;
    }
    @Override
    public String apply(String s1, String s2) {
        return s1.concat(sep).concat(s2);
    }
}
