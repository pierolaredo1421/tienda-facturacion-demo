package org.laredo.tienda.model;

public class PagoTargeta implements Pago{
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con tarjeta procesado: S/." + monto + " (simulado)");
    }
}
