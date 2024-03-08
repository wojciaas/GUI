package Ćwiczenia.cw6.zad02;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public
    class Task0602 {
    public static void main(String[] args) {
        Map<String, List<Purchase>> shopping = new HashMap<>();
        File clients = new File("/Users/wojciechregula/Desktop/PJATK/SEM II/GUI/src/Ćwiczenia/cw6/zad02/zakupy");
        File output = new File("/Users/wojciechregula/Desktop/PJATK/SEM II/GUI/src/Ćwiczenia/cw6/zad02/summary.txt");
        try {
            FileInputStream fis = new FileInputStream(clients);
            int res;
            int price = 0;
            String name;
            String item;
            StringBuffer stringBuffer = new StringBuffer();
            while ((res = fis.read()) != -1){
                while (res != ' '){
                    stringBuffer.append((char)res);
                    res = fis.read();
                }
                name = String.valueOf(stringBuffer);
                stringBuffer.delete(0, stringBuffer.length());
                while ((res = fis.read()) != ' '){
                    stringBuffer.append((char)res);
                }
                item = String.valueOf(stringBuffer);
                stringBuffer.delete(0, stringBuffer.length());
                while ((res = fis.read()) != '\n' && res != -1){
                    price *= 10;
                    price += Character.getNumericValue(res);
                }
                if (!shopping.containsKey(name))
                    shopping.put(name, new ArrayList<>());
                shopping.get(name).add(new Purchase(item, price));
                price = 0;
            }
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter fw = new FileWriter(output);
            for (String name : shopping.keySet()){
                fw.write(name + " ");
                fw.write(shopping.get(name).size() + " ");
                fw.write((int)shopping.get(name).stream().map(Purchase::getName).distinct().count() + " ");
                fw.write((int)shopping.get(name).stream().mapToDouble(Purchase::getPrice).sum() + "\n");
            }
            fw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class Purchase{

    private String name;

    private double price;

    public Purchase(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
