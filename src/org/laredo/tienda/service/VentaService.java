package org.laredo.tienda.service;

import org.laredo.tienda.factory.SistemaVentaFactory;
import org.laredo.tienda.model.Factura;
import org.laredo.tienda.model.Pago;
import org.laredo.tienda.model.Product;
import org.laredo.tienda.model.ProductComponent;
import org.laredo.tienda.repository.FacturaRepository;

import java.util.List;

public class VentaService {
    private final SistemaVentaFactory factory;
    private final FacturaRepository repository;

    public VentaService(SistemaVentaFactory factory, FacturaRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    public Factura crearFactura(List<ProductComponent> productos) {
        Factura factura = factory.crearFactura(null, productos);
        repository.save(factura); // asigna id y publica evento
        return factura;
    }

    public Factura realizarVenta(List<ProductComponent> productos) {
        Factura factura = crearFactura(productos);
        // Aquí podrías envolver factura con decorators desde el servicio si quisieras
        factura.generarFactura();
        procesarPago(factura);
        return factura;
    }

    public void procesarPago(Factura factura) {
        Pago pago = factory.crearPago();
        pago.procesarPago(factura.getTotal());
    }

    public List<Factura> listarVentas() {
        return repository.findAll();
    }

    public Factura buscarPorId(String id) {
        return repository.findById(id);
    }
}

