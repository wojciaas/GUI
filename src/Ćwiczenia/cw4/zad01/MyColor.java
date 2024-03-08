package Ćwiczenia.cw4.zad01;

public
    class MyColor
    extends java.awt.Color
    implements Comparable<MyColor>{

    private int sum;

    MyColor(int r, int g, int b){
        super(r, g, b);
        sum = r + g + b;
    }

    @Override
    public String toString() {
        return "MyColor(" + getRed() + ", " + getGreen() + ", " + getBlue() + ")";
    }

    public int getSum() {
        return sum;
    }

    @Override
    public int compareTo(MyColor o) {
        return this.sum - o.getSum();
    }
}