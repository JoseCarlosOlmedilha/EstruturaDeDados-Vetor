package Vetor;

import java.lang.reflect.Array;

public class VetorGeneric<T> {

    private T[] vetor;
    private int tamanho; // o tamanho sempre vai apontar pra proxima posição vazia

    public VetorGeneric(int capacidade) {
        vetor = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public VetorGeneric(int capacidade, Class<T> tipo) {
        vetor = (T[]) Array.newInstance(tipo, capacidade);
        this.tamanho = 0;
    }

    //adiciona passando a possição e o elemento
    public boolean adiciona(int posicao, T valor) {

        /*
        Para fazer a busca a posição que eu procuro tem que ser maior que 0 e menor que o tamanho do vetor, a variavel tamanho
        sempre vai apontar para o proximo indice vazio,por isso tem que ser menor que temanho,
        na expessão monta eu penso da seguinte forma, se a posicao for maior que 0 e menor que o tamanho então ela é true
        pq tenho esse elemento no vetor, com a negação(!) ele fica false pulando a exceção
         */

        if(!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição invalida");
        }

        verificarCapacidade();

        //vai decrementando o  i até o 1 ser maior que a posição
        for (int i = tamanho; i > posicao; i--) {
            vetor[i] = vetor[i - 1];
        }

        //depois de percorrer e mudar os elemntos de lugar ele atribui o elemento a posição
        this.vetor[posicao] = valor;
        tamanho++;

        return true;
    }

    //adiciona só passando o elemento na ultima posição
    public boolean adiciona(T valor) {

        verificarCapacidade();

        /*
        Se o tamanho so atributo for menor que o length do vetor é pq tem espaço no vetor
         */
        if(this.tamanho < vetor.length) {
            vetor[this.tamanho] = valor;
            this.tamanho++;
            return true;
        }
        return false;
    }

    //busca passando a posição
    public T busca(int posicao) {
        /*
        Para fazer a busca a posição que eu procuro tem que ser maior que 0 e menor que o tamanho do vetor, a variavel tamanho
        sempre vai apontar para o proximo indice vazio,por isso tem que ser menor que temanho,
        na expessão monta eu penso da seguinte forma, se a posicao for maior que 0 e menor que o tamanho então ela é true
        pq tenho esse elemento no vetor, com a negação(!) ele fica false pulando a exceção
         */
        if(!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição invalida");
        }
        return vetor[posicao];

    }

    //Buscar elemento no vetor pelo conteudo, se tiver devolve o indece se não -1
    public int busca(T elemento) {
        for(int i = 0; i < this.tamanho; i++) {
            if(vetor[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    //remover pelo indice
    public void remover(int posicao) {
        /*
        Para fazer a busca a posição que eu procuro tem que ser maior que 0 e menor que o tamanho do vetor, a variavel tamanho
        sempre vai apontar para o proximo indice vazio,por isso tem que ser menor que temanho,
        na expessão monta eu penso da seguinte forma, se a posicao for maior que 0 e menor que o tamanho então ela é true
        pq tenho esse elemento no vetor, com a negação(!) ele fica false pulando a exceção
         */

        if(!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição invalida");
        }
        for(int i = posicao; i < this.tamanho - 1; i++) {
            this.vetor[i] = vetor[i +1];
        }
        this.tamanho--;
    }

    //mostrar tamanho do vetor
    public int tamanho() {
        return this.tamanho;
    }

    /* imprimir todo conteudo do vetor*/
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i < this.tamanho; i++) {
            sb.append(vetor[i]);

            if(i < this.tamanho - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }

    private void verificarCapacidade(){
        if(tamanho == vetor.length ){
            T[] novoVetor = (T[]) new Object[vetor.length * 2];
            for (int i = 0; i < tamanho; i++) {
                novoVetor[i] = vetor[i];
            }
            this.vetor = novoVetor;
        }
    }


}
