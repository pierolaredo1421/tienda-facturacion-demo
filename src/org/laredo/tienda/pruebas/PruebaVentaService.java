//package org.laredo.tienda.pruebas;
//
//import org.laredo.tienda.factory.VentaSimpleFactory;
//import org.laredo.tienda.factory.VentaElectronicaFactory;
//import org.laredo.tienda.factory.SistemaVentaFactory;
//import org.laredo.tienda.model.Product;
//import org.laredo.tienda.model.Factura;
//import org.laredo.tienda.model.ProductComponent;
//import org.laredo.tienda.repository.FacturaRepository;
//import org.laredo.tienda.repository.impl.InMemoryFacturaRepository;
//import org.laredo.tienda.service.VentaService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PruebaVentaService {
//    public static void main(String[] args) {
//        // productos de ejemplo
//        List<ProductComponent> productos = new ArrayList<>();
//        productos.add(new Product("001", "Cámara", 452.0));
//        productos.add(new Product("002", "Lente", 45.0));
//        productos.add(new Product("003", "Trípode", 78.0));
//
//        // repositorio en memoria
//        FacturaRepository repo = new InMemoryFacturaRepository();
//
//        // Ejemplo 1: venta simple (efectivo)
//        SistemaVentaFactory simpleFactory = new VentaSimpleFactory();
//        VentaService ventaSimple = new VentaService(simpleFactory, repo);
//        Factura f1 = ventaSimple.realizarVenta(productos);
//        System.out.println("\n-- FACTURA CREADA (Venta Simple) --");
//        f1.generarFactura();
//
//        // Ejemplo 2: venta electrónica (tarjeta)
//        SistemaVentaFactory electronicaFactory = new VentaElectronicaFactory();
//        VentaService ventaElectronica = new VentaService(electronicaFactory, repo);
//        Factura f2 = ventaElectronica.realizarVenta(productos);
//        System.out.println("\n-- FACTURA CREADA (Venta Electrónica) --");
//        f2.generarFactura();
//
//        // Mostrar facturas almacenadas en el repositorio
//        System.out.println("\nFacturas almacenadas totales: " + repo.findAll().size());
//        repo.findAll().forEach(f -> {
//            System.out.println("-> Factura total: " + f.getTotal());
//        });
//    }
//}