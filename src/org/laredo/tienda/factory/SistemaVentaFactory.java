package org.laredo.tienda.factory;

import org.laredo.tienda.model.Factura;
import org.laredo.tienda.model.Pago;
import org.laredo.tienda.model.Producto;

import java.util.List;

public interface SistemaVentaFactory {
    Factura crearFactura(String id, List<Producto> productos);
    Pago crearPago();
}
