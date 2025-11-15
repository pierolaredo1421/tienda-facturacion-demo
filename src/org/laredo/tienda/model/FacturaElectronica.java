package org.laredo.tienda.model;

import java.util.List;

public class FacturaElectronica implements Factura{
    private FacturaSimple facturaDelegada;

    public FacturaElectronica(String id, List<Producto> productos) {
        this.facturaDelegada = new FacturaSimple(id, productos);
    }

    @Override
    public void generarFactura() {
        System.out.println("===FACTURA ELECTRONICA===");
        facturaDelegada.generarFactura();
        System.out.println("Tipo electronica (enviar XML/JSON al sistema tributario)");
        System.out.println("=========================");
    }

    @Override
    public List<Producto> listarProductos() {
        return facturaDelegada.listarProductos();
    }

    @Override
    public double getTotal() {
        return facturaDelegada.getTotal();
    }

    @Override
    public void setTotal(double total) {
        facturaDelegada.setTotal(total);
    }
}
