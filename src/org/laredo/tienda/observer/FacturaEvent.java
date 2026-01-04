package org.laredo.tienda.observer;

import org.laredo.tienda.model.Factura;

public class FacturaEvent {
    public enum Type {CREATE, UPDATE, DELETE}
    private final Type  type;
    private final String facturaId;
    private final Factura factura;

    public FacturaEvent(Type type, String facturaId, Factura factura) {
        this.type = type;
        this.facturaId = facturaId;
        this.factura = factura;
    }

    public Type getType() { return type; }
    public String getFacturaId() { return facturaId; }
    public Factura getFactura() { return factura; }
}
