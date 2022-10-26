package paakingu.syncObj;

import java.util.Random;

public class Aparcamiento {

    private int plazasOcup = 0;

    public void entrar(String modeloCarro) throws InterruptedException {

        synchronized (Aparcamiento.this){
            while (plazasOcup >= 5){
                wait();
            }

            plazasOcup++;
            System.out.println("Entra el coche de modelo: " + modeloCarro);

            notifyAll();
        }
    }

    public void salir(String modeloCarro, int tiempoAparcado){
        synchronized (Aparcamiento.this){
            plazasOcup--;

            System.out.println("El coche " + modeloCarro + " ha estado aparcado " + tiempoAparcado + " y se marcha");

            notifyAll();
        }
    }
}
