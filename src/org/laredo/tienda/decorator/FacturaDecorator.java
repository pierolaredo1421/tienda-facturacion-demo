package org.laredo.tienda.decorator;

import org.laredo.tienda.model.Factura;
import org.laredo.tienda.model.Producto;

import java.util.List;

public abstract class FacturaDecorator implements Factura {
    protected final Factura factura;

    protected FacturaDecorator(Factura factura) {
        this.factura = factura;
    }

    @Override
    public void generarFactura() {
        factura.generarFactura();
    }

    @Override
    public List<Producto> listarProductos() {
        return factura.listarProductos();
    }

    @Override
    public double getTotal() {
        return factura.getTotal();
    }

    @Override
    public void setTotal(double total) {
        factura.setTotal(total);
    }

    @Override
    public String getId() {
        return factura.getId();
    }

    @Override
    public void setId(String id) {
        factura.setId(id);
    }
}
