package org.laredo.tienda.model;

public class PagoEfectivo implements Pago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago en efectivo procesado: S/." + monto);
    }
}
