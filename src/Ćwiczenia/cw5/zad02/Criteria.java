package Ćwiczenia.cw5.zad02;

import java.util.Comparator;
import java.util.function.IntBinaryOperator;

public
    enum Criteria
    implements Comparator<Integer> {
    BY_VAL((o1, o2) -> o1 - o2),
    BY_VAL_REV((o1, o2) -> o2 - o1),
    BY_NUM_OF_DIVS((o1, o2) -> {
        int res = divsNo(o1) - divsNo(o2);
        return res == 0 ? o1 - o2 : res;
    }),
    BY_SUM_OF_DIGS((o1, o2) -> {
        int res = sumOfDig(o1) - sumOfDig(o2);
        return res == 0 ? o1 - o2 : res;
    });

    private IntBinaryOperator operator;

    Criteria(IntBinaryOperator operator){
        this.operator = operator;
    }

    private static int divsNo(int o){
        int divs = 0;
        for (int i = 1; i <= o; i++) {
            if (o % i == 0) divs++;
        }
        return divs;
    }

    private static int sumOfDig(int o){
        int sum = 0;
        int tmp = o;
        while (tmp != 0){
            sum += tmp % 10;
            tmp /= 10;
        }
        return sum;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return operator.applyAsInt(o1,o2);
    }
}
