package listaDuplamenteEncadeadaCircular;

public class ListaDuplamenteEncadeadaCircular {
    private NoDuplo primeiro;
    private int tamanho;


    public ListaDuplamenteEncadeadaCircular() {
        this.primeiro = null;
        this.tamanho = 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public void adiciona(int elemento) {
        this.adiciona(this.tamanho, elemento);
    }

    public NoDuplo get(int index) {
        if (index < 0 || index >= this.tamanho) {
            return null;
        }
        NoDuplo atual = this.primeiro;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual;
    }

    public boolean adiciona(int index, int elemento) {
        if (index < 0 || index > this.tamanho) {
            return false;
        }

        NoDuplo novoNo = new NoDuplo(elemento);

        if (this.tamanho == 0) {
            this.primeiro = novoNo;
            novoNo.proximo = novoNo;
            novoNo.anterior = novoNo;
        } else if (index == 0) {
            NoDuplo ultimo = this.primeiro.anterior;
            novoNo.proximo = this.primeiro;
            this.primeiro.anterior = novoNo;
            novoNo.anterior = ultimo;
            ultimo.proximo = novoNo;
            this.primeiro = novoNo;
        } else {
            NoDuplo noAnterior = get(index - 1);
            NoDuplo proximoNo = noAnterior.proximo;

            noAnterior.proximo = novoNo;
            novoNo.anterior = noAnterior;
            novoNo.proximo = proximoNo;
            proximoNo.anterior = novoNo;
        }

        this.tamanho++;
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= this.tamanho || this.primeiro == null) {
            return false;
        }

        if (this.tamanho == 1) {
            this.primeiro = null;
        } else if (index == 0) {
            NoDuplo ultimo = this.primeiro.anterior;
            NoDuplo novoPrimeiro = this.primeiro.proximo;
            ultimo.proximo = novoPrimeiro;
            novoPrimeiro.anterior = ultimo;
            this.primeiro = novoPrimeiro;
        } else {
            NoDuplo noParaRemover = get(index);
            NoDuplo noAnterior = noParaRemover.anterior;
            NoDuplo noProximo = noParaRemover.proximo;

            noAnterior.proximo = noProximo;
            noProximo.anterior = noAnterior;
        }

        this.tamanho--;
        return true;
    }
}