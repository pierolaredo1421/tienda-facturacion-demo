package org.laredo.tienda.model;

import java.util.List;

public interface Factura {
    // imprime la factura
    void generarFactura();
    List<ProductComponent> listarProductos();
    // total costo de los productos de la factura
    double getTotal();
    // cambia el costo total de los productos por uno nuevo, simulando el "descuento"
    void setTotal(double total);
    String getId();
    void setId(String id);
}
