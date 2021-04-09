// Alunos: Wellington da Silva e Rebeka Moreira

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class Sorteio {

    private int n;
    private int[] numeros;
    private int min;
    private int max;

    public Sorteio(int n, int min, int max) throws Exception{

        if (n <= 0 || n > 100){
            throw new Exception("O valor de n deve estar entre 1 e 99");
        }else if (min < 0){
            throw new Exception("O valor mínimo precisa ser maior que 0");
        }else if (max < min){
            throw new Exception("O valor maximo precisa ser maior que o valor minimo");
        }else {
            this.n = n;
            this.min = min;
            this.max = max;
            this.numeros = new int[n];
        }

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

    public void proximoNumero() throws Exception{

        // Verificando se todos os números do sorteio já foram gerados
        if (terminou()){
            throw new Exception("Não é possível gerar mais números, pois o sorteio já terminou");
        }

        Random numero = new Random();
        int numeroSorteado = numero.nextInt((max - min) + 1) + min;

        int cont = 0;

        while (true){
            if (numeros[cont] == 0){
                boolean existe = false;

                for (int i = 0; i < numeros.length; i++){
                    if (numeros[i] == numeroSorteado){
                        existe = true;
                        numeroSorteado = numero.nextInt((max - min) + 1) + min;
                    }
                    else {
                        existe = false;
                    }
                }

                if (!existe){
                    numeros[cont] = numeroSorteado;
                }

            }
            else {
                cont += 1;
                if (cont == numeros.length){
                    break;
                }
            }
        }

    }

    public void gerarNumeros(){

        Random numero = new Random();

        while (!terminou()) {

            for (int i = 0; i < numeros.length; i++){
                int numeroSorteado = numero.nextInt((max - min) + 1) + min;

                for (int j = 0; j < numeros.length; j++){
                    if(numeroSorteado == numeros[j] && j != i){
                        numeroSorteado = numero.nextInt((max - min) + 1) + min;
                    }else {
                        numeros[i] = numeroSorteado;
                    }
                }

            }

        }
    }

    public String resultado(String formato) throws Exception{

        if (formato == null){
            throw new Exception("O valor do padrão não pode ser null");
        }

        ordenarNumeros();

        String res = "";

        for (int n : numeros){
            if (res == ""){
                res = res + " " + n;
            }
            else {
                res = res + " " + formato + " " + n;
            }
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
