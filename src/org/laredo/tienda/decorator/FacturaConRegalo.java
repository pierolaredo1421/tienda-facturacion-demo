package org.laredo.tienda.decorator;

import org.laredo.tienda.model.Factura;

public class FacturaConRegalo extends FacturaDecorator{
    private final String regalo;
    protected FacturaConRegalo(Factura factura, String regalo) {
        super(factura);
        this.regalo = regalo;
    }

    @Override
    public void generarFactura() {
        super.generarFactura();
        System.out.println("-> Regalo incluido: " + regalo);
    }
}
