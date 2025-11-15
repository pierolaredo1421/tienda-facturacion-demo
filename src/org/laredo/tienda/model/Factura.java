package org.laredo.tienda.model;

import java.util.List;

public interface Factura {
    // imprime la factura
    void generarFactura();
    List<Producto> listarProductos();
    // total costo de los productos de la factura
    double getTotal();
    // cambia el costo total de los productos por uno nuevo, simulando el "descuento"
    void setTotal(double total);
}
