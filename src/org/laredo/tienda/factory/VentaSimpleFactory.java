package org.laredo.tienda.factory;

import org.laredo.tienda.model.*;

import java.util.List;

public class VentaSimpleFactory implements SistemaVentaFactory{
    @Override
    public Factura crearFactura(String id, List<Producto> productos) {
        return new FacturaSimple(id, productos);
    }

    @Override
    public Pago crearPago() {
        return new PagoEfectivo();
    }
}
