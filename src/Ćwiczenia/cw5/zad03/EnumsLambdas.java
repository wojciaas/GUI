package Ćwiczenia.cw5.zad03;

import java.util.Arrays;
import java.util.Comparator;

enum Sex{F, M}

enum Size{XS, S, M, L, XL}

enum Country{
    PL("Polska"),
    NL("Nederland"),
    DE("Deutschland");
    private String fullCountryName;
    Country(String countryName){
        this.fullCountryName = countryName;
    }

    public String getFullCountryName() {
        return fullCountryName;
    }

    @Override
    public String toString() {
        return fullCountryName;
    }
}

class Person{

    private String name;

    private Sex sex;

    private Size size;

    private Country country;

    Person(String name, Sex sex, Size size, Country country){
        this.name = name;
        this.sex = sex;
        this.size = size;
        this.country = country;
    }

    @Override
    public String toString() {
        return this.name + "(" +
                this.sex + ", " +
                this.size + ", " +
                this.country + ")";
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public Size getSize() {
        return size;
    }

    public Country getCountry() {
        return country;
    }
}

public
    class EnumsLambdas {

    // printArray static function
    private static <T> void printArray(String title, T[] array){
        System.out.println("\t*** " + title + " ***\t");
        for (T item : array)
            System.out.println(item);
    }

    public static void main(String[] args) {
        Person[] persons = {
                new Person("Max",  Sex.M, Size.XL, Country.NL),
                new Person("Jan",  Sex.M, Size.S,  Country.PL),
                new Person("Eva",  Sex.F, Size.XS, Country.NL),
                new Person("Lina", Sex.F, Size.L,  Country.DE),
                new Person("Mila", Sex.F, Size.S,  Country.DE),
                new Person("Ola",  Sex.F, Size.M,  Country.PL),
        };

        Comparator<Person> sexThenSize = Comparator.comparing(
                (Person p) -> (p.getSex())).thenComparing((Person p) -> (p.getSize())
        );
        Arrays.sort(persons, sexThenSize);
        printArray("Persons by sex and then size", persons);

        Arrays.sort(persons, Comparator.comparing(
                (Person p) -> (p.getSize())).thenComparing(((Person p) -> p.getName()))
        );
        printArray("Persons by size and then name", persons);

        Country[] countries = Country.values();
        Arrays.sort(countries, Comparator.comparing(
                (Country c) -> (c.getFullCountryName()))
        );
        printArray("Countries by name", countries);
    }
}