package tabelaHash;
import java.util.LinkedList;

public class TabelaHash {
    private int tamanho = 10;
    private LinkedList<Aluno>[] tabela;

    public TabelaHash() {
        tabela = new LinkedList[tamanho];

        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int funcaoHash(int matricula) {
        return matricula % tamanho;
    }

    public String pegarValor (int matricula) {
        int posicao = funcaoHash(matricula);
        LinkedList<Aluno> lista = tabela[posicao];

        if (lista == null) {
            return null;
        }

        for (Aluno atual : lista) {
            if (matricula == atual.getMatricula()) {
                return atual.getNome();
            }
        }
        return null;
    }

    public void inserirValor (int matricula, String nome) {
        int posicao = funcaoHash(matricula);
        Aluno novo = new Aluno(matricula, nome);
        tabela[posicao].add(novo);
    }

    public void removerValor(int matricula){
        int posicao = funcaoHash(matricula);
        LinkedList<Aluno> lista = tabela[posicao];

        if (lista == null) {
            return;
        }

        Aluno alunoParaRemover = null;
        for (Aluno atual : lista) {
            if (matricula == atual.getMatricula()) {
                alunoParaRemover = atual;
                break;
            }
        }
        if (alunoParaRemover != null) {
            lista.remove(alunoParaRemover); // Remove o objeto encontrado
        }
    }
}