package org.laredo.tienda.service;

import org.laredo.tienda.factory.SistemaVentaFactory;
import org.laredo.tienda.repository.FacturaRepository;

public class VentaService {
    private final SistemaVentaFactory factory;
    private final FacturaRepository repository;

    public VentaService(SistemaVentaFactory factory, FacturaRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }


}
