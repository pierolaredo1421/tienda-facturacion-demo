package org.laredo.tienda.repository;

import org.laredo.tienda.model.Factura;

import java.util.List;

public interface FacturaRepository {
    void save(Factura factura);
    Factura findById(String id);
    List<Factura> findAll();
}
