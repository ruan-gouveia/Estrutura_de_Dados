package listaEncadeada;

public class ListaEncadeada {
    private No primeiro;
    private int tamanho;

    public ListaEncadeada() {

        this.primeiro = null;
        this.tamanho = 0;

    }

    public void adiciona(int valor) {

        if (primeiro == null) {
            primeiro = new No(valor);
        } else {
            No atual = primeiro;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = new No(valor);
        }
        tamanho++;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public No get(int index){
        if (index < 0 || index >= this.tamanho) {
            return null;
        }
        No atual = this.primeiro;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual;
    }

    public void add(int index, int elemento){

        if( index < 0 || index > this.tamanho) {
            return;
        }

        No novoNo = new No(elemento);

        if (index == 0) {
            novoNo.proximo = this.primeiro;
            this.primeiro = novoNo;
        } else {
            No anterior = get(index - 1);
            novoNo.proximo = anterior.proximo;
            anterior.proximo = novoNo;
        }
        this.tamanho++;
    }

    public int remove(int index) {
        if(index < 0 || index >= this.tamanho) {
            throw new IndexOutOfBoundsException("Índice invalido.");
        }
        int valorRemovido;

        if (index == 0) {
            valorRemovido = this.primeiro.valor;
            this.primeiro = this.primeiro.proximo;
        } else {
            No anterior = get(index - 1);
            No noParaRemover = anterior.proximo;
            valorRemovido = noParaRemover.valor;
            anterior.proximo = noParaRemover.proximo;
        }
        this.tamanho--;
        return valorRemovido;
    }
}