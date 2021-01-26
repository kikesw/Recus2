public class Main {

    public static void main(String[] args){
        Impresora impresora = new Impresora();
        for(int i=0; i < 10;i++){
            Ordenadores o = new Ordenadores(impresora);
            o.setName("Computer: "+(i+1));
            o.start();
        }
    }



}
