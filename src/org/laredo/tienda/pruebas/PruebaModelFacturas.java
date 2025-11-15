package org.laredo.tienda.pruebas;

import org.laredo.tienda.model.FacturaElectronica;
import org.laredo.tienda.model.FacturaSimple;
import org.laredo.tienda.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class PruebaModelFacturas {
    public static void main(String[] args) {
        // ========================================PRODUCTOS

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(new Producto("123", "camara", 452.0));
        productos.add(new Producto("456", "lente", 45.0));
        productos.add(new Producto("789", "tripode", 78.0));

        // ========================================FACTURA SIMPLE

        FacturaSimple fs = new FacturaSimple("123", productos);
        System.out.println(fs.listarProductos());
        System.out.println(fs.getTotal());
        fs.setTotal(75);
        System.out.println(fs.getTotal());

        // ========================================FACTURA ELECTRONICA

        FacturaElectronica fe = new FacturaElectronica("123", productos);
        System.out.println(fe.listarProductos());
        System.out.println(fe.getTotal());
        fe.setTotal(458);
        System.out.println(fe.getTotal());


    }
}
