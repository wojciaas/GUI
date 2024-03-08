package Ćwiczenia.cw3.zad02;

public interface FunDD {
    double fun(double x);
    static double xminim(FunDD f, double a, double b) {
        double xMin = a,
                fMin = f.fun(xMin);
        for (double i = xMin + 1e-5; i <= b; i += 1e-5) {
            if (f.fun(i) < fMin){
                fMin = f.fun(i);
                xMin = i;
            }
        }
        return xMin;
    }
}
