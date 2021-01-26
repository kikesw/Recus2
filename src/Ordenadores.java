public class Ordenadores extends Thread{

    Impresora impresora;
    public Ordenadores(Impresora impresora){
        this.impresora = impresora;
    }

    @Override
    public void run() {
     impresora.entrada(this);
    }


}
