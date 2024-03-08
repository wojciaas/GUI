package Ćwiczenia.cw5.zad02;

import java.util.Arrays;

public
    class Compars {
    public static void main(String[] args) {
        Integer[] a = {1,5,33,12,98,15};
        printTable("Original    ", a);

        Arrays.sort(a,Criteria.BY_VAL);
        printTable("ByVal       ", a);

        Arrays.sort(a,Criteria.BY_VAL_REV);
        printTable("ByValRev    ", a);

        Arrays.sort(a,Criteria.BY_NUM_OF_DIVS);
        printTable("ByNumOfDivs ", a);

        Arrays.sort(a,Criteria.BY_SUM_OF_DIGS);
        printTable("BySumOfDigs ", a);
    }

    static void printTable(String mess, Integer[] a) {
        System.out.print(mess + "[ ");
        for (int d : a) System.out.print(d + " ");
        System.out.print("]\n");
    }
}