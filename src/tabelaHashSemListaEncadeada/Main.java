package tabelaHashSemListaEncadeada;

public class Main {

    public static void main(String[] args) {

        System.out.println("--- Testando TabelaHash com Sondagem Linear ---");

        TabelaHash minhaTabela = new TabelaHash();

        System.out.println("Tabela Hash criada com tamanho inicial: " + minhaTabela.tamanho);

        System.out.println("\nInserindo alunos...");
        minhaTabela.inserir(10, "Ana");
        minhaTabela.inserir(17, "Beto");
        minhaTabela.inserir(24, "Carla");
        minhaTabela.inserir(3, "Diego");
        minhaTabela.inserir(4, "Edu");
        minhaTabela.inserir(5, "Fabi");
        System.out.println("Tamanho da tabela após inserções (e possível redimensionamento): " + minhaTabela.tamanho);

        System.out.println("\nBuscando alunos:");
        System.out.println("Matricula 10 (Ana): " + minhaTabela.pegar(10));
        System.out.println("Matricula 17 (Beto): " + minhaTabela.pegar(17));
        System.out.println("Matricula 24 (Carla): " + minhaTabela.pegar(24));
        System.out.println("Matricula 3 (Diego): " + minhaTabela.pegar(3));
        System.out.println("Matricula 4 (Edu): " + minhaTabela.pegar(4));
        System.out.println("Matricula 5 (Fabi): " + minhaTabela.pegar(5));
        System.out.println("Matricula 99 (inexistente): " + minhaTabela.pegar(99));

        System.out.println("\nTestando atualização de nome:");
        minhaTabela.inserir(10, "Ana Paula");
        System.out.println("Matricula 10 (atualizada): " + minhaTabela.pegar(10));

        System.out.println("\nRemovendo alunos:");
        minhaTabela.remover(17);
        System.out.println("Matricula 17 após remoção: " + minhaTabela.pegar(17));
        System.out.println("Matricula 10 (ainda existe?): " + minhaTabela.pegar(10));

        minhaTabela.remover(10);
        System.out.println("Matricula 10 após remoção: " + minhaTabela.pegar(10));

        minhaTabela.remover(99);

        System.out.println("\n--- Fim dos Testes ---");
    }
}