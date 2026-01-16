package arvoreB;

public class No {
    private int numChaves;
    private int[] chaves;
    private No[] filhos;
    private boolean folha;

    public No(boolean folha) {
        this.folha = folha;
        this.numChaves = 0;
        this.chaves = new int[3];
        this.filhos = new No[4];
    }

    public int getNumChaves() {
        return numChaves;
    }

    public void setNumChaves(int numChaves) {
        this.numChaves = numChaves;
    }

    public int getChave(int index) {
        return chaves[index];
    }

    public void setChave(int index, int valor) {
        this.chaves[index] = valor;
    }

    public No getFilho(int index) {
        return filhos[index];
    }

    public void setFilho(int index, No no) {
        this.filhos[index] = no;
    }

    public boolean isFolha() {
        return folha;
    }

    public void setFolha(boolean folha) {
        this.folha = folha;
    }

    public int[] getChaves() {
        return chaves;
    }
}