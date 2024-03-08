package Ćwiczenia.cw5.zad01;

public
    class StrToInt
    implements Transform<String, Integer>{
    @Override
    public Integer apply(String o) {
        return o.length();
    }
}
