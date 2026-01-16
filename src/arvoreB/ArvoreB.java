package arvoreB;

public class ArvoreB {

    private No raiz;
    private final int T = 2;

    public ArvoreB() {
        raiz = null;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No no, int valor) {
        if (no == null) {
            return false;
        }

        int i = 0;
        while (i < no.getNumChaves() && valor > no.getChave(i)) {
            i++;
        }

        if (i < no.getNumChaves() && valor == no.getChave(i)) {
            return true;
        }

        if (no.isFolha()) {
            return false;
        }

        return buscarRecursivo(no.getFilho(i), valor);
    }

    public void inserir(int valor) {
        if (raiz == null) {
            raiz = new No(true);
            raiz.setChave(0, valor);
            raiz.setNumChaves(1);
        } else {
            if (raiz.getNumChaves() == 3) {
                No novaRaiz = new No(false);
                novaRaiz.setFilho(0, raiz);


                dividirFilho(novaRaiz, 0, raiz);

                int i = 0;
                if (novaRaiz.getChave(0) < valor) {
                    i++;
                }
                inserirNaoCheio(novaRaiz.getFilho(i), valor);

                raiz = novaRaiz;
            } else {
                inserirNaoCheio(raiz, valor);
            }
        }
    }

    private void dividirFilho(No x, int i, No y) {
        No z = new No(y.isFolha());
        z.setNumChaves(T - 1);
        for (int j = 0; j < T - 1; j++) {
            z.setChave(j, y.getChave(j + T));
        }

        if (!y.isFolha()) {
            for (int j = 0; j < T; j++) {
                z.setFilho(j, y.getFilho(j + T));
            }
        }

        y.setNumChaves(T - 1);

        for (int j = x.getNumChaves(); j >= i + 1; j--) {
            x.setFilho(j + 1, x.getFilho(j));
        }
        x.setFilho(i + 1, z);

        for (int j = x.getNumChaves() - 1; j >= i; j--) {
            x.setChave(j + 1, x.getChave(j));
        }

        x.setChave(i, y.getChave(T - 1));
        x.setNumChaves(x.getNumChaves() + 1);
    }

    private void inserirNaoCheio(No x, int valor) {
        int i = x.getNumChaves() - 1;

        if (x.isFolha()) {
            while (i >= 0 && valor < x.getChave(i)) {
                x.setChave(i + 1, x.getChave(i));
                i--;
            }
            x.setChave(i + 1, valor);
            x.setNumChaves(x.getNumChaves() + 1);
        } else {
            while (i >= 0 && valor < x.getChave(i)) {
                i--;
            }
            i++;

            if (x.getFilho(i).getNumChaves() == 3) {
                dividirFilho(x, i, x.getFilho(i));
                if (valor > x.getChave(i)) {
                    i++;
                }
            }
            inserirNaoCheio(x.getFilho(i), valor);
        }
    }
    public void percorrerEmOrdem() {
        System.out.print("Em-Ordem: ");
        percorrerEmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void percorrerEmOrdemRecursivo(No no) {
        if (no != null) {
            int i;
            for (i = 0; i < no.getNumChaves(); i++) {
                if (!no.isFolha()) {
                    percorrerEmOrdemRecursivo(no.getFilho(i));
                }
                System.out.print(no.getChave(i) + " ");
            }
            if (!no.isFolha()) {
                percorrerEmOrdemRecursivo(no.getFilho(i));
            }
        }
    }

    public void imprimirEstrutura() {
        imprimirEstruturaRecursivo(raiz, 0);
    }

    private void imprimirEstruturaRecursivo(No no, int nivel) {
        if (no != null) {
            System.out.print("Nível " + nivel + ": [ ");
            for (int i = 0; i < no.getNumChaves(); i++) {
                System.out.print(no.getChave(i) + " ");
            }
            System.out.println("]");

            if (!no.isFolha()) {
                for (int i = 0; i <= no.getNumChaves(); i++) {
                    imprimirEstruturaRecursivo(no.getFilho(i), nivel + 1);
                }
            }
        }
    }
}