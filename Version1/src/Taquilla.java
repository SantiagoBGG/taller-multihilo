public class Taquilla implements Runnable {
    private final String nombre;
    private final Inventario inventario;
    private int ventas = 0;

    public Taquilla(String nombre, Inventario inventario) {
        this.nombre = nombre;
        this.inventario = inventario;
    }

    @Override
    public void run() {
        while (inventario.vender()) {
            ventas++;
        }
        System.out.println(nombre + " vendiò " + ventas + " boletas");
    }
}
