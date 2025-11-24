package arvoreBinaria;

public class Arvore {

    private No raiz;

    public void Arvore() {
        raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No noAtual, int valor) {

        if (noAtual == null) {
            return new No(valor);
        }

        if (valor < noAtual.getValor()) {
            noAtual.setEsquerda(inserirRecursivo(noAtual.getEsquerda(), valor));
        } else if (valor > noAtual.getValor()) {
            noAtual.setDireita(inserirRecursivo(noAtual.getDireita(), valor));
        }

        return noAtual;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    public boolean buscarRecursivo(No noAtual, int valor) {
        if (noAtual == null) {
            return false;
        }

        if (valor == noAtual.getValor()) {
            return true;
        }

        if (valor < noAtual.getValor()) {
            return buscarRecursivo(noAtual.getEsquerda(), valor);
        } else {
            return buscarRecursivo(noAtual.getDireita(), valor);
        }
    }

    public void remover(int valor) {
        raiz = removerRecursivo(this.raiz, valor);
    }

    private No removerRecursivo(No noAtual, int valor) {
        if (noAtual == null) {
            return null;
        }

        if (valor < noAtual.getValor()) {
            noAtual.setEsquerda(removerRecursivo(noAtual.getEsquerda(), valor));
        } else if (valor > noAtual.getValor()) {
            noAtual.setDireita(removerRecursivo(noAtual.getDireita(), valor));
        } else {
            if (noAtual.getEsquerda() == null && noAtual.getDireita() == null) {
                return null;
            }

            if (noAtual.getDireita() == null) {
                return noAtual.getEsquerda();
            }
            if (noAtual.getEsquerda() == null) {
                return noAtual.getDireita();
            }

            int menorValor = encontrarMenorValor(noAtual.getDireita());
            noAtual.setValor(menorValor);
            noAtual.setDireita(removerRecursivo(noAtual.getDireita(), menorValor));
        }

        return noAtual;
    }

    private int encontrarMenorValor(No no) {
        return no.getEsquerda() == null ? no.getValor() : encontrarMenorValor(no.getEsquerda());
    }

    public void percorrerEmOrdem() {
        System.out.print("Em-Ordem: ");
        percorrerEmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void percorrerEmOrdemRecursivo(No no) {
        if (no != null) {
            percorrerEmOrdemRecursivo(no.getEsquerda());
            System.out.print(no.getValor() + " ");
            percorrerEmOrdemRecursivo(no.getDireita());
        }
    }

    public void percorrerPreOrdem() {
        System.out.print("Pré-Ordem: ");
        percorrerPreOrdemRecursivo(raiz);
        System.out.println();
    }

    private void percorrerPreOrdemRecursivo(No no) {
        if (no != null) {
            System.out.print(no.getValor() + " ");
            percorrerPreOrdemRecursivo(no.getEsquerda());
            percorrerPreOrdemRecursivo(no.getDireita());
        }
    }

    public void percorrerPosOrdem() {
        System.out.print("Pós-Ordem: ");
        percorrerPosOrdemRecursivo(raiz);
        System.out.println();
    }

    private void percorrerPosOrdemRecursivo(No no) {
        if (no != null) {
            percorrerPosOrdemRecursivo(no.getEsquerda());
            percorrerPosOrdemRecursivo(no.getDireita());
            System.out.print(no.getValor() + " ");
        }
    }
}