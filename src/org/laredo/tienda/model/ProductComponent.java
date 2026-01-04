package org.laredo.tienda.model;

public interface ProductComponent {
    double price();

    String description();

    default void add(ProductComponent p) {
        throw new UnsupportedOperationException();
    }

    default void remove(ProductComponent p) {
        throw new UnsupportedOperationException();
    }
}
