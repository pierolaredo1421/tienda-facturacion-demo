package org.laredo.tienda.pruebas;

import java.lang.reflect.Method;
import java.util.UUID;

// Simula la clase Factura
public class PruebaID {
    // Caso 1: uncomment para probar getId() pública que devuelve String
    private final String id;

    public PruebaID(String id) {
        this.id = id;
    }

    // Caso A: método público getId() que devuelve algo
    public String getId() {
        return id;
    }

    // Si quieres probar el caso de getId() que devuelve null,
    // crea una instancia con new Factura(null).
}

// Clase que no tiene getId()
class FacturaSinId {
    private final int number = 42;
    public int getNumber() { return number; }
}

class TestExtractId {
    private static String extractId(Object factura) {
        try {
            // busca GET PUBLICO "getId"
            Method m = factura.getClass().getMethod("getId");
            Object id = m.invoke(factura);
            return id != null ? id.toString() : UUID.randomUUID().toString();
        } catch (NoSuchMethodException ex) {
            // fallback: id basado en identityHashCode en hex
            return Integer.toHexString(System.identityHashCode(factura));
        } catch (Exception e) {
            // En producción deberías loggear e.getMessage()
            return UUID.randomUUID().toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Caso 1: getId() público y no nulo ===");
        PruebaID f1 = new PruebaID("FAC-2025-0001");
        System.out.println("extractId -> " + extractId(f1));

        System.out.println("\n=== Caso 2: getId() público y NULO ===");
        PruebaID f2 = new PruebaID(null);
        System.out.println("extractId -> " + extractId(f2));

        System.out.println("\n=== Caso 3: clase SIN método getId() público ===");
        FacturaSinId fs = new FacturaSinId();
        System.out.println("extractId -> " + extractId(fs));

        System.out.println("\n=== Caso 4: misma instancia, misma identityHashCode (ejemplo) ===");
        FacturaSinId fs2 = new FacturaSinId();
        System.out.println("extractId fs -> " + extractId(fs));
        System.out.println("extractId fs2 -> " + extractId(fs2));
    }
}
