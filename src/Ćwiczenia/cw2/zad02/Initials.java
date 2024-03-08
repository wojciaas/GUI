package Ćwiczenia.cw2.zad02;

public
    class Initials
    implements TwoStringsOper{
    @Override
    public String apply(String s1, String s2) {
        return new StringBuffer().append(s1.charAt(0)).append(s2.charAt(0)).toString();
    }
}
