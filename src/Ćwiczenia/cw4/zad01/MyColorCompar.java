package Ćwiczenia.cw4.zad01;

import java.util.Comparator;

public
    class MyColorCompar
    implements Comparator<MyColor> {

    ColComponent color;
    MyColorCompar(ColComponent color){
        this.color = color;
    }

    @Override
    public int compare(MyColor o1, MyColor o2) {
        return switch (this.color){
            case RED -> o1.getRed() - o2.getRed();
            case GREEN -> o1.getGreen() - o2.getGreen();
            case BLUE -> o1.getBlue() - o2.getBlue();
            case NONE -> o1.getSum() - o2.getSum();
        };
    }
}
