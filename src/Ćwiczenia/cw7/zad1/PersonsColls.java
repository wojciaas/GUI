package Ćwiczenia.cw7.zad1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import static java.lang.System.out;

public class PersonsColls {
    public static void main (String[] args) {
        List<Person> list = Arrays.asList(
                new Person("Alice", 2000),
                new Person("Brenda", 2001),
                new Person("Cecilia", 2002)
        );

        out.println(Person.isInColl(list, "Brenda", 2001));
        out.println(Person.isInColl(list, "Debby", 2001));

        Set<Person> tSet = new TreeSet<>(list);
        out.println(Person.isInColl(tSet, "Brenda", 2001));
        out.println(Person.isInColl(tSet, "Debby", 2001));

        Set<Person> hSet = new HashSet<>(list);
        out.println(Person.isInColl(hSet, "Brenda", 2001));
        out.println(Person.isInColl(hSet, "Debby", 2001));
    }
}

