package Ćwiczenia.cw5.zad02;

//public
//    class MyComp
//    implements Comparator<Integer> {
//    public static final int
//            BY_VAL=0, BY_VAL_REV=1,
//            BY_NUM_OF_DIVS=2, BY_SUM_OF_DIGS=3;
//
//    private Integer criterium;
//
//    public MyComp (Integer criterium){
//        this.criterium = criterium;
//    }
//
//    @Override
//    public int compare(Integer o1, Integer o2) {
//        return switch (this.criterium){
//            case BY_VAL -> o1 - o2;
//            case BY_VAL_REV -> o2 - o1;
//            case BY_NUM_OF_DIVS -> {
//                int res = divsNo(o1) - divsNo(o2);
//                yield res == 0 ? o1 - o2 : res;
//            }
//            case BY_SUM_OF_DIGS -> {
//                int res = sumOfDig(o1) - sumOfDig(o2);
//                yield res == 0 ? o1 - o2 : res;
//            }
//        };
//    }
//
//    private int divsNo(Integer o){
//        int divs = 0;
//        for (int i = 1; i <= o; i++) {
//            if (o % i == 0) divs++;
//        }
//        return divs;
//    }
//
//    private int sumOfDig(Integer o){
//        int sum = 0;
//        int tmp = o;
//        while (tmp != 0){
//            sum += tmp % 10;
//            tmp /= 10;
//        }
//        return sum;
//    }
//}
