package org.laredo.tienda.pruebas;

import org.laredo.tienda.decorator.FacturaConDescuento;
import org.laredo.tienda.decorator.FacturaConRegalo;
import org.laredo.tienda.factory.VentaSimpleFactory;
import org.laredo.tienda.model.Factura;
import org.laredo.tienda.model.Product;
import org.laredo.tienda.model.ProductComponent;
import org.laredo.tienda.model.ProductGroup;
import org.laredo.tienda.observer.EventBus;
import org.laredo.tienda.observer.FacturaEvent;
import org.laredo.tienda.observer.FacturaListener;
import org.laredo.tienda.repository.FacturaRepository;
import org.laredo.tienda.repository.impl.InMemoryFacturaRepository;
import org.laredo.tienda.service.VentaService;

import java.util.ArrayList;
import java.util.List;

public class PortafolioDemoMain {
    public static void main(String[] args) {
        EventBus bus = new EventBus();

        // listeners (Observer) - ejemplo: email y contabilidad
        bus.subscribe(new FacturaListener() {
            @Override
            public void onEvent(FacturaEvent event) {
                if (event.getType() == FacturaEvent.Type.CREATE) {
                    System.out.println("[EmailNotifier] Nueva factura creada: " + event.getFacturaId());
                }
            }
        });

        bus.subscribe(event -> {
            if (event.getType() == FacturaEvent.Type.CREATE) {
                System.out.println("[Accounting] Actualizar libro contable para factura " + event.getFacturaId());
            }
        });

        // repositorio con EventBus
        FacturaRepository repo = new InMemoryFacturaRepository(bus);
        VentaService ventaService = new VentaService(new VentaSimpleFactory(), repo);

        // productos simples
        Product p1 = new Product("001", "Cámara", 452.0);
        Product p2 = new Product("002", "Lente", 45.0);
        Product p3 = new Product("003", "Trípode", 78.0);

        // paquete (Composite)
        ProductGroup paquete = new ProductGroup("Kit Foto");
        paquete.add(p1);
        paquete.add(p2);

        List<ProductComponent> carrito = new ArrayList<>();
        carrito.add(paquete);
        carrito.add(p3);

        // realizar venta
        Factura factura = ventaService.crearFactura(carrito);

        // aplicar decorator opcionalmente (ejemplo): descuento y regalo
        Factura factConDesc = new FacturaConDescuento(factura, 10.0); // 10% dto
        Factura factConReg = new FacturaConRegalo(factConDesc, "Tarjeta de memoria 16GB");

        // imprimir y procesar
        factConReg.generarFactura();
        System.out.println("Procesando pago de S/." + factConReg.getTotal() + " (simulado)");

        // listar facturas almacenadas
        System.out.println("\nFacturas en repo:");
        repo.findAll().forEach(f -> System.out.println("-> " + f.getId() + " total S/." + f.getTotal()));
    }
}
