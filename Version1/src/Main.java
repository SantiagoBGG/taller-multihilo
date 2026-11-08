//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Inventario inventario = new Inventario(100);
        Thread[] hilos = new Thread[5];
        long inicio = System.currentTimeMillis();

        for (int i = 0 ; i < hilos.length; i++){
            Taquilla t = new Taquilla("Taquilla " + (i+1), inventario);
            hilos[i] = new Thread(t);
            hilos[i].start();
        }
        for (Thread h : hilos){
            h.join();
        }

        System.out.println("Vendidas: " + inventario.getVendidas());
        System.out.println("Disponibles: " + inventario.getDisponibles());
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo(ms): " + (fin - inicio));

    }
}