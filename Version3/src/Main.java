import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario(100);
        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futuros = new ArrayList<>();

        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 5; i++) {
            futuros.add(pool.submit(new TaquillaCallable("Taquilla " + i, inventario)));
        }

        int totalVentas = 0;
        try {
            for (int i = 0; i < futuros.size(); i++) {
                int ventas = futuros.get(i).get(); // bloquea hasta que la tarea termine
                System.out.println("Resultado Taquilla " + (i + 1) + ": " + ventas);
                totalVentas += ventas;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.err.println("Una taquilla falló: " + e.getCause());
        } finally {
            pool.shutdown();
        }

        long fin = System.currentTimeMillis();

        System.out.println("Suma de ventas (Future): " + totalVentas);
        System.out.println("Vendidas (inventario): " + inventario.getVendidas());
        System.out.println("Disponibles: " + inventario.getDisponibles());
        System.out.println(totalVentas == 100 ? "Verificación OK: suma exacta = 100"
                : "ERROR: la suma no es 100");
        System.out.println("Tiempo(ms): " + (fin - inicio));
    }
}