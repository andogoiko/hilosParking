package paakingu;

import paakingu.hilos.hiloCarro;
import paakingu.syncObj.Aparcamiento;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args) throws InterruptedException {

        Aparcamiento aparcamiento = new Aparcamiento();

        System.out.println("Inicia una nueva jornada y filas de ocches llegan a usar tu aparcamiento");

        ArrayList<Thread> clientesAparcamiento = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            clientesAparcamiento.add(new Thread(new hiloCarro(aparcamiento, "coche" + i)));
        }

        for (Thread partidazo: clientesAparcamiento) {

            partidazo.start();
        }
        for (int i = 0; i < clientesAparcamiento.size(); i++){
            clientesAparcamiento.get(i).join();
        }

    }
}
