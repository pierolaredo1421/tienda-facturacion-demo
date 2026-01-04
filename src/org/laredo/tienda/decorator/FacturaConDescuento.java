package org.laredo.tienda.decorator;

import org.laredo.tienda.model.Factura;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FacturaConDescuento extends FacturaDecorator {
    private final double porcentaje;
    public FacturaConDescuento(Factura factura, double porcentaje) {
        super(factura);
        this.porcentaje = porcentaje;
    }

    @Override
    public void generarFactura() {
        double precioOriginal = factura.getTotal();
        double nuevo = precioOriginal - (precioOriginal * porcentaje / 100);
        nuevo = BigDecimal.valueOf(nuevo).setScale(2, RoundingMode.HALF_UP).doubleValue();
        factura.setTotal(nuevo);
        System.out.println("-> Descuento aplicado: " + porcentaje + "% (S/." + (precioOriginal - nuevo) + ")");
        super.generarFactura();
    }
}
