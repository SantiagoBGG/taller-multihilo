public class Inventario {
    private int disponibles;
    private int vendidas = 0;

    public Inventario(int total){
        this.disponibles = total;
    }

    public boolean vender() {
        if (disponibles > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            disponibles--;
            vendidas++;
            return true;
        }
        return false;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public int getVendidas() {
        return vendidas;
    }

}
