package Ćwiczenia.cw2.zad01;

public abstract class ShoppingCart {
    abstract void addProduct(Product product);

    abstract void removeProduct(Product product);

    abstract double getTotalPrice();
}