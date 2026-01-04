package org.laredo.tienda.model;

import java.util.ArrayList;
import java.util.List;

public class ProductGroup implements ProductComponent {
    private final String nombre;
    private final List<ProductComponent> children = new ArrayList<>();

    public ProductGroup(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public double price() {
        return children.stream().mapToDouble(ProductComponent::price).sum();
    }

    @Override
    public String description() {
        return nombre + "(paquete) - S/." + price();
    }

    @Override
    public void add(ProductComponent p) {
        children.add(p);
    }

    @Override
    public void remove(ProductComponent p) {
        children.remove(p);
    }

    public List<ProductComponent> getChildren() {
        return new ArrayList<>(children);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(description()).append("\n");
        for (ProductComponent c : children) {
            sb.append("  - ").append(c.description()).append("\n");
        }
        return sb.toString();
    }
}
