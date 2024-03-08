package Ćwiczenia.cw4.zad02;

import java.util.Arrays;
public
    class Person
    implements Comparable<Person>{

    private String name;

    private int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[Imie: " + name + ", wiek: " + age + "]";
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.getAge();
    }

    public static void sort(Person[] people){
        Arrays.sort(people);
    }
}
