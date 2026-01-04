package org.laredo.tienda.model;

import java.util.List;

public class FacturaSimple implements Factura{
    private List<ProductComponent> productos;
    private double total;
    private String id;

    public FacturaSimple(String id, List<ProductComponent> productos) {
        this.id = id;
        this.productos = productos;
        this.total = calcularTotal();
    }

    public Double calcularTotal() {
        return productos.stream().mapToDouble(ProductComponent::price).sum();
    }

    public List<ProductComponent> getProductos() {
        return productos;
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void generarFactura() {
        System.out.println("===FACTURA SIMPLE===");
        System.out.println("ID: " + id);
        productos.forEach(p -> System.out.println("- " + p));
        System.out.println("Total: " + total);
        System.out.println("====================");
    }

    @Override
    public List<ProductComponent> listarProductos() {
        return productos;
    }

    @Override
    public double getTotal() {
        return total;
    }

    @Override
    public void setTotal(double total) {
        this.total = total;
    }
}
