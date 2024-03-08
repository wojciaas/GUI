package Ćwiczenia.cw7.zad1;

import java.util.Collection;
import java.util.Comparator;

public
    class Person
    implements Comparable<Person>, Comparator<Person>{

        private String name;

        private int birthYear;

        public Person(String name, int birthYear){
            this.name = name;
            this.birthYear = birthYear;
        }

        public static boolean isInColl(Collection<Person> coll, String name, int year) {
            return coll.contains(new Person(name, year));
        }

    @Override
    public int compareTo(Person o) {
        return 0;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return 0;
    }
}
