package Ćwiczenia.cw5.zad01;

import java.util.Arrays;

public class GenTrans {
    private static <T, R>
    void transform(T[] in, R[] out, Transform<T, R> trans) {
        for (int i = 0; i < in.length; i++) {
            out[i] = trans.apply(in[i]);
        }
    }

    public static void main (String[] args) {
        String[]  sin = {"Alice", "Sue", "Janet", "Bea"};
        System.out.println(Arrays.toString(sin) + '\n');

        Integer[] iout = new Integer[sin.length];
        transform(sin, iout, new StrToInt());
        System.out.println(Arrays.toString(iout));

        Character[] cout = new Character[sin.length];
        transform(sin, cout, new Transform<String, Character>() {
            @Override
            public Character apply(String o) {
                return o.charAt(0);
            }
        });
        System.out.println(Arrays.toString(cout));

        String[] sout = new String[sin.length];
        transform(sin, sout, str -> str.toUpperCase());
        System.out.println(Arrays.toString(sout));
    }
}
