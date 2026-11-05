package Moje_slozka.OOP.Polimorfismus.ComparingBasics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ComparingBasics {
    static void printList(ArrayList<Item> items){
        for (Item i : items) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("potato", 100, 0.33));
        items.add(new Item("White Monster", 1000000000, 1.33));
        items.add(new Item("Mango Monster", 500000, 1.33));
        items.add(new Item("Beaf steak", 10000, 11.5));

        printList(items);
        Collections.shuffle(items);
        printList(items);
        Collections.sort(items);
        printList(items);

    }
}

class Item implements Comparable<Item> {
    String name;
    int quantity;
    double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Item o) {
        return this.quantity - o.quantity;
    }
}
