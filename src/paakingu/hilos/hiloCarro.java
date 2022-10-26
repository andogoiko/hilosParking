package paakingu.hilos;

import paakingu.syncObj.Aparcamiento;

import java.util.Random;

import static java.lang.Thread.sleep;

public class hiloCarro implements Runnable{

    private Aparcamiento plaza;
    private String modeloCarro;

    public hiloCarro(Aparcamiento plaza, String modeloCarro){
        this.plaza = plaza;
        this.modeloCarro = modeloCarro;
    }

    @Override
    public void run(){
        Random ran = new Random();

        try {
            plaza.entrar(modeloCarro);

            int tiempoAparcado = (ran.nextInt(11 - 5) + 5) * 1000;

            sleep(tiempoAparcado);

            plaza.salir(modeloCarro, tiempoAparcado);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
