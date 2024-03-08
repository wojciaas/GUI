package Ćwiczenia.cw6.zad01;

import java.util.Iterator;

public
    class Roll
    implements Iterable<Integer>{

    private Integer[] rolls;

    private int lastIndex;

    private int sum;

    public Roll(){
        rolls = new Integer[1];
        lastIndex = 0;
        sum = 0;
        while (sum != 11){
            rolls[lastIndex++] = (int)(Math.random() * 6) + 1;
            if (rolls.length > 2)
                sum = rolls[lastIndex - 3] + rolls[lastIndex - 2] + rolls[lastIndex - 1];
            if (sum != 11)
                this.resize_table();
        }
    }

    private void resize_table(){
        Integer[] tmp = new Integer[rolls.length + 1];
        for (int i = 0; i < rolls.length; i++) {
            tmp[i] = rolls[i];
        }
        rolls = tmp;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < rolls.length;
            }

            @Override
            public Integer next() {
                return rolls[index++];
            }
        };
    }
}