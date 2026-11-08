import java.util.concurrent.Callable;

public class TaquillaCallable implements Callable<Integer> {
    private final String nombre;
    private final Inventario inventario;

    public TaquillaCallable(String nombre, Inventario inventario) {
        this.nombre = nombre;
        this.inventario = inventario;
    }

    @Override
    public Integer call() {
        int ventas = 0;
        while (inventario.vender()) {
            ventas++;
        }
        System.out.println(nombre + " (" + Thread.currentThread().getName()
                + ") vendió " + ventas + " boletas");
        return ventas;
    }
}