package org.laredo.tienda.service;

import org.laredo.tienda.factory.SistemaVentaFactory;
import org.laredo.tienda.model.Factura;
import org.laredo.tienda.model.Pago;
import org.laredo.tienda.model.Producto;
import org.laredo.tienda.repository.FacturaRepository;

import java.util.List;

public class VentaService {
    private final SistemaVentaFactory factory;
    private final FacturaRepository repository;

    public VentaService(SistemaVentaFactory factory, FacturaRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    public Factura crearFactura(List<Producto> productos) {
        Factura factura = factory.crearFactura(null, productos);
        repository.save(factura);
        return factura;
    }

    public void procesarPago(Factura factura) {
        Pago pago = factory.crearPago();
        pago.procesarPago(factura.getTotal());
    }

    public Factura realizarVenta(List<Producto> productos) {
        Factura factura = crearFactura(productos);
        procesarPago(factura);
        return factura;
    }

    public List<Factura> listarVentas() {
        return repository.findAll();
    }

    public Factura buscarPorId(String id) {
        return repository.findById(id);
    }
}

