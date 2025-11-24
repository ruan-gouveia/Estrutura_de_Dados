package listaDuplamenteEncadeadaCircular;

public class NoDuplo {
    int valor;
    NoDuplo proximo;
    NoDuplo anterior;

    public NoDuplo(int valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
}
