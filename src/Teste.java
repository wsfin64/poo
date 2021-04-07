import java.util.Random;

public class Teste {

    public static void main(String[] args) {

        //Random numero = new Random();

        //System.out.println(numero.nextInt((10 - 8) + 1) + 8);

        //int numero = numeroSorteado.nextInt((max - min) + 1) + min;
        try {
            Sorteio mega = new Sorteio(-6, 1, 60);

            mega.gerarNumeros();

            System.out.println(mega.resultado(" - "));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
