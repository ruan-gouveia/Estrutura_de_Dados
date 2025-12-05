package arvoreAVL;

public class ArvoreAVL {

    private No raiz;

    public ArvoreAVL() {
        raiz = null;
    }

    public int calcularAltura(No no) {
        if (no == null) {
            return -1;
        }
        int alturaEsquerda = calcularAltura(no.getEsquerda());
        int alturaDireita = calcularAltura(no.getDireita());
        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    public int calcularFB(No no) {
        if (no == null) {
            return 0;
        }
        return calcularAltura(no.getEsquerda()) - calcularAltura(no.getDireita());
    }

    private No rotacaoDireita(No y) {
        No x = y.getEsquerda();
        No T2 = x.getDireita();

        x.setDireita(y);
        y.setEsquerda(T2);

        if (T2 != null) {
            T2.setPai(y);
        }
        x.setPai(y.getPai());
        y.setPai(x);

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.getDireita();
        No T2 = y.getEsquerda();

        y.setEsquerda(x);
        x.setDireita(T2);

        if (T2 != null) {
            T2.setPai(x);
        }
        y.setPai(x.getPai());
        x.setPai(y);

        return y;
    }

    private No balancear(No no) {
        if (no == null) {
            return null;
        }

        int fb = calcularFB(no);

        if (fb > 1) {
            if (calcularFB(no.getEsquerda()) < 0) {
                no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
            }
            return rotacaoDireita(no);
        }

        if (fb < -1) {
            if (calcularFB(no.getDireita()) > 0) {
                no.setDireita(rotacaoDireita(no.getDireita()));
            }
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No noAtual, int valor) {
        if (noAtual == null) {
            return new No(valor);
        }

        if (valor < noAtual.getValor()) {
            No novoFilho = inserirRecursivo(noAtual.getEsquerda(), valor);
            noAtual.setEsquerda(novoFilho);
            if (novoFilho != null) {
                novoFilho.setPai(noAtual);
            }
        } else if (valor > noAtual.getValor()) {
            No novoFilho = inserirRecursivo(noAtual.getDireita(), valor);
            noAtual.setDireita(novoFilho);
            if (novoFilho != null) {
                novoFilho.setPai(noAtual);
            }
        } else {
            return noAtual;
        }

        return balancear(noAtual);
    }

    public void remover(int valor) {
        raiz = removerRecursivo(this.raiz, valor);
    }

    private No removerRecursivo(No noAtual, int valor) {
        if (noAtual == null) {
            return null;
        }

        if (valor < noAtual.getValor()) {
            No filhoEsquerdo = removerRecursivo(noAtual.getEsquerda(), valor);
            noAtual.setEsquerda(filhoEsquerdo);
            if (filhoEsquerdo != null) filhoEsquerdo.setPai(noAtual);
        }
        else if (valor > noAtual.getValor()) {
            No filhoDireito = removerRecursivo(noAtual.getDireita(), valor);
            noAtual.setDireita(filhoDireito);
            if (filhoDireito != null) filhoDireito.setPai(noAtual);
        }
        else {
            if ((noAtual.getEsquerda() == null) || (noAtual.getDireita() == null)) {
                No temp = null;
                if (temp == noAtual.getEsquerda()) {
                    temp = noAtual.getDireita();
                } else {
                    temp = noAtual.getEsquerda();
                }

                if (temp == null) {
                    temp = noAtual;
                    noAtual = null;
                } else {
                    noAtual = temp;
                }
            } else {
                int menorValor = encontrarMenorValor(noAtual.getDireita());
                noAtual.setValor(menorValor);

                No novaDireita = removerRecursivo(noAtual.getDireita(), menorValor);
                noAtual.setDireita(novaDireita);
                if (novaDireita != null) novaDireita.setPai(noAtual);
            }
        }

        if (noAtual == null) {
            return null;
        }

        return balancear(noAtual);
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

    public void imprimirRaiz() {
        if (raiz != null) {
            System.out.println("Raiz atual: " + raiz.getValor());
        } else {
            System.out.println("Árvore vazia");
        }
    }
}