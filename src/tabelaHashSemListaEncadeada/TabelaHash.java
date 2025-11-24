package tabelaHashSemListaEncadeada;

public class TabelaHash {

    public int tamanho = 7;
    private Aluno[] tabela = new Aluno[tamanho];
    private int ocupados = 0;
    private final Aluno APAGADO = new Aluno(-1, "APAGADO");


    private int funcaoHash(int matricula) {
        return matricula % tamanho;
    }

    public void inserir(int matricula, String nome) {
        if ((double) ocupados / tamanho >= 0.75) {
            redimensionar();
        }

        int posicao = funcaoHash(matricula);
        Aluno novo = new Aluno(matricula, nome);

        while (tabela[posicao] != null && tabela[posicao] != APAGADO) {
            if (tabela[posicao].getMatricula() == matricula) {
                tabela[posicao].setNome(nome);
                return;
            }
            posicao = (posicao + 1) % tamanho;
        }

        tabela[posicao] = novo;
        ocupados++;
    }

    private void redimensionar() {
        int novoTamanho = tamanho * 2;
        Aluno[] novaTabela = new Aluno[novoTamanho];
        Aluno[] tabelaAntiga = tabela;
        tabela = novaTabela;
        tamanho = novoTamanho;
        ocupados = 0;

        for (Aluno aluno : tabelaAntiga) {
            if (aluno != null && aluno != APAGADO) {
                int posicao = aluno.getMatricula() % tamanho;

                while (tabela[posicao] != null) {
                    posicao = (posicao + 1) % tamanho;
                }
                tabela[posicao] = aluno;
                ocupados++;
            }
        }
    }

    public void remover(int matricula) {
        int posicao = funcaoHash(matricula);
        int inicio = posicao;

        while (tabela[posicao] != null) {
            if (tabela[posicao] != APAGADO && tabela[posicao].getMatricula() == matricula) {
                tabela[posicao] = APAGADO;
                ocupados--;
                System.out.println("Aluno removido: " + matricula);
                return;
            }

            posicao = (posicao + 1) % tamanho;
            if (posicao == inicio) {
                break;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    public String pegar(int matricula) {
        int posicao = funcaoHash(matricula);
        int inicio = posicao;

        while (tabela[posicao] != null) {
            if (tabela[posicao] != APAGADO && tabela[posicao].getMatricula() == matricula) {
                return tabela[posicao].getNome();
            }

            posicao = (posicao + 1) % tamanho;
            if (posicao == inicio) {
                break;
            }
        }
        return null;
    }
}