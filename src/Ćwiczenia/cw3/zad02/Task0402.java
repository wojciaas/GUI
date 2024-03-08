package Ćwiczenia.cw3.zad02;

public
    class Task0402 {
    public static void main(String[] args) {

        FunDD p1 = new Parabola(1, -1, (double) -5/4);
        FunDD p2 = new FunDD() {
            @Override
            public double fun(double x) {
                return Math.sqrt(Math.pow(x - 0.75, 2) + 1);
            }
        };
        FunDD p3 = (x) -> Math.pow(x,2) * (x - 2);

        System.out.println(FunDD.xminim(p1,0,1));
        System.out.println(FunDD.xminim(p2,0,2));
        System.out.println(FunDD.xminim(p3,0,2));
    }
}