import java.util.Random;

public class Sorteio {

    private int n;
    private int[] numeros;
    private int min;
    private int max;

    public Sorteio(int n, int min, int max){
        this.n = n;
        this.min = min;
        this.max = max;
        this.numeros = new int[n];
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }


    public boolean terminou() {

        int cont = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == 0) {
                cont++;
            }
        }

        if (cont > 0) {
            return false;
        } else {
            return true;
        }

    }

    public int proximoNumero(){

        Random numero = new Random();
        int numeroSorteado = numero.nextInt((max - min) + 1) + min;

        return numeroSorteado;

    }

    public void gerarNumeros(){

        while (!terminou()) {

            for (int i = 0; i < numeros.length; i++){
                int numeroSorteado = proximoNumero();

                for (int j = 0; j < numeros.length; j++){
                    if(numeroSorteado == numeros[j] && j != i){
                        numeroSorteado = proximoNumero();
                    }else {
                        numeros[i] = numeroSorteado;
                    }
                }

            }

        }
    }

    public String resultado(){
        ordenarNumeros();

        String res = "";

        for (int n : numeros){
            res = res + " " + n;
        }
        return res;
    }

    public void ordenarNumeros(){

        for (int i = 0; i < numeros.length; i++){
            for (int j = i + 1; j < numeros.length; j++){
                if (numeros[i] > numeros[j]){
                    int numeroAuxiliar = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = numeroAuxiliar;
                }
            }
        }
    }

}
