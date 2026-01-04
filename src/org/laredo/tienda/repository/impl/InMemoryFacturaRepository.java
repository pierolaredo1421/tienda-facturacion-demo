package org.laredo.tienda.repository.impl;

import org.laredo.tienda.model.Factura;
import org.laredo.tienda.observer.EventBus;
import org.laredo.tienda.observer.FacturaEvent;
import org.laredo.tienda.repository.FacturaRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryFacturaRepository implements FacturaRepository {
    // se usa LinkedHashMap para que se ordene por orden de ingreso
    private final Map<String, Factura> storage = new LinkedHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(1);
    private final EventBus eventBus;

    public InMemoryFacturaRepository(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void save(Factura factura) {
        String id = idSecuencial();
        factura.setId(id);
        storage.put(id, factura);
        if (eventBus != null) {
            eventBus.publish(new FacturaEvent(FacturaEvent.Type.CREATE, id, factura));
        }
    }

    @Override
    public Factura findById(String id) {
        return storage.get(id);
    }

    @Override
    public List<Factura> findAll() {
        return new ArrayList<>(storage.values());
    }

    private  String idSecuencial() {
        int parteSecuencial = counter.getAndIncrement();
        return String.format("%06d", parteSecuencial);
    }
}
