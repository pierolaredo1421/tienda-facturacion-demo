package org.laredo.tienda.model;

public class Product implements ProductComponent {
    private final String code;
    private final String name;
    private final double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public String description() {
        return name + " (cod: " + code + ") - S/." + price;
    }

    @Override
    public String toString() {
        return description();
    }
}
