package Ćwiczenia.cw3.zad02;

public
    class Parabola
    implements FunDD {
    private double a, b, c;
    public Parabola(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public double fun(double x) {
        return (a * Math.pow(x,2) + b * x + c);
    }
}
