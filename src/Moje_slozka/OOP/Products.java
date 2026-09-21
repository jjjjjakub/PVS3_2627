package Moje_slozka.OOP;

import fileworks.DataImport;

import java.util.ArrayList;

public class Products {
    private String name;
    private String category;
    private int amount;
    private double pricePerPeice;

    public Products(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Products(String name, String category, int amount) {
        this (name, category);
        this.amount = amount;
    }

    public Products(String name, String category, int amount, double pricePerPeice) {
        this (name, category, amount);
        this. pricePerPeice = pricePerPeice;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }

    public double getPricePerPeice() {
        return pricePerPeice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(int amount) {
        if (amount > 0) {
            this.amount = amount;
        }
        else {
            this.amount = 0;
        }
    }

    public void setPricePerPeice(int pricePerPeice) {
        if (this.pricePerPeice > 0) {
            this.pricePerPeice = pricePerPeice;
        }
        else {
            this.pricePerPeice = 0;
        }
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", pricePerPeice=" + pricePerPeice +
                '}';
    }

    public static void main(String[] args) {
        String path = "/data/products.txt";
        DataImport di = new DataImport(path);
        ArrayList<Products> products = new ArrayList<>();

        while (di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split(";");

            Products product = new Products(
                    tokens[0],
                    tokens[1],
                    Integer.parseInt(tokens[2]),
                    Double.parseDouble(tokens[3]));
            products.add(product);
        }
        System.out.println(products.lastIndexOf(products.getLast()));
        di.finishImport();
    }
}


