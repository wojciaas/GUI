package Ćwiczenia.cw4.zad02;

public
    class Task0402{
    public static void main(String[] args) {
        Person[] people = {
                new Person("Ada", 17),
                new Person("Janek", 16),
                new Person("Bartek", 20),
                new Person("Mateusz", 18),
                new Person("Tomek", 24)
        };

        System.out.println("Tablica przed sortowaniem: ");
        for (Person person : people){
            System.out.println(person);
        }

        Person.sort(people);

        System.out.println("Tablica po sortowaniu: ");
        for (Person person : people){
            System.out.println(person);
        }
    }
}
