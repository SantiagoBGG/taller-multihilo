public class Inventario {
    private int disponibles;
    private int vendidas = 0;

    public Inventario(int total) {
        this.disponibles = total;
    }

    //Alternativa a
    public synchronized boolean vender() {
        if (disponibles > 0) {
            try {
                Thread.sleep(1); // simula el procesamiento de la venta
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            disponibles--;
            vendidas++;
            return true;
        }
        return false;
    }

    //Alternativa b
    /*
    public boolean vender() {
        boolean vendio = false;
        synchronized (this) {
            if (disponibles > 0) {
                disponibles--;
                vendidas++;
                vendio = true;
            }
        }
        if (vendio) {
            try {
                Thread.sleep(1); // simula el procesamiento, fuera de la sección crítica
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return vendio;
    }
    */

    public int getDisponibles() { return disponibles; }
    public int getVendidas() { return vendidas; }
}