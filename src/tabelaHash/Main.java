package tabelaHash;

public class Main {

    public static void main(String[] args) {

        System.out.println("--- Testando TabelaHash ---");

        TabelaHash minhaTabela = new TabelaHash();
        System.out.println("Tabela Hash criada.");

        System.out.println("\nInserindo alunos...");
        minhaTabela.inserirValor(101, "Alice");
        minhaTabela.inserirValor(202, "Bob");
        minhaTabela.inserirValor(303, "Charlie");
        minhaTabela.inserirValor(11, "David");
        minhaTabela.inserirValor(21, "Eve");

        System.out.println("\nBuscando alunos:");
        System.out.println("Matricula 101: " + minhaTabela.pegarValor(101));
        System.out.println("Matricula 202: " + minhaTabela.pegarValor(202));
        System.out.println("Matricula 11: " + minhaTabela.pegarValor(11));
        System.out.println("Matricula 21: " + minhaTabela.pegarValor(21));
        System.out.println("Matricula 999 (inexistente): " + minhaTabela.pegarValor(999));

        System.out.println("\nRemovendo aluno:");
        System.out.println("Removendo matricula 11 (David)");
        minhaTabela.removerValor(11);
        System.out.println("Matricula 11 após remoção: " + minhaTabela.pegarValor(11));
        System.out.println("Matricula 101 (ainda existe?): " + minhaTabela.pegarValor(101));
        System.out.println("Matricula 21 (ainda existe?): " + minhaTabela.pegarValor(21));

        System.out.println("\nTentando remover aluno inexistente:");
        minhaTabela.removerValor(555);
        System.out.println("Matricula 555 (inexistente): " + minhaTabela.pegarValor(555));

        System.out.println("\n--- Fim dos Testes ---");
    }
}
