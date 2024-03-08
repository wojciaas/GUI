package Ćwiczenia.cw3.zad01;

public class InterF {
    public static void main(String[] args) {
        Func f = x -> Math.pow(x,2);
        Func g = x -> x + 1;
        Func cmp1 = Func.compose(f, g);
        Func cmp2 = Func.compose(g, f);
        Func cmp3 = Func.compose(Func.compose(g, cmp1), f);
        Func cmp4 = Func.compose(g, Func.compose(cmp2, f));
        System.out.println("Res1: " + cmp1.apply(3));
        System.out.println("Res2: " + cmp2.apply(3));
        System.out.println("Res3: " + cmp3.apply(3));
        System.out.println("Res4: " + cmp4.apply(3));
    }
}