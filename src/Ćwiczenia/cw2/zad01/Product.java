package Ćwiczenia.cw2.zad01;

public abstract class Product {
    protected String name;
    protected double price;

    Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }
}