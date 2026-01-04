package org.laredo.tienda.observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {
    private final List<FacturaListener> listeners = new CopyOnWriteArrayList<FacturaListener>();
    public void subscribe(FacturaListener listener) {
        listeners.add(listener);
    }
    public void unsubscribe(FacturaListener listener) {
        listeners.remove(listener);
    }
    public void publish(FacturaEvent event) {
        for (FacturaListener listener : listeners) {
            try{
                listener.onEvent(event);
            } catch (Exception e) {
                System.err.println("Listener error: " + e.getMessage());
            }
        }
    }
}
