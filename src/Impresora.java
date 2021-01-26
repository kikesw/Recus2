import java.util.Random;
import java.util.concurrent.Semaphore;

public class Impresora {

    private static final Semaphore semaphore = new Semaphore(3,false);

    public static void entrada(Ordenadores ordenadores){
        try{
            semaphore.acquire();
            System.out.println("Entra el ordenador "+ordenadores.getName()+ " entra.");
            int espera = (int) (Math.random()*(2000)+3000);
            System.out.println("Esperando al proceso...");
            Thread.sleep(espera);
            SioNo(ordenadores);
            semaphore.release();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private static void SioNo(Ordenadores ordenadores) throws InterruptedException {
        Random r = new Random();
        int exito = r.nextInt(2);

        if(exito==1){
            conExito(ordenadores);
        }else{
            sinExito(ordenadores);
        }
    }

    private static void conExito(Ordenadores ordenadores) throws InterruptedException{
        System.out.println(ordenadores.getName()+": Imprimiendo documento...");
        Thread.sleep(5000);
        System.out.println(ordenadores.getName()+" Terminado y apagado");
    }


    private static void sinExito(Ordenadores ordenadores) throws InterruptedException{
        System.out.println("El proceso de "+ordenadores.getName()+" ha fallado");
        int error = (int) (100 * Math.random());
        System.out.println("Error "+error);
        SioNo(ordenadores);
    }


}
