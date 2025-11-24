package listaDuplamenteEncadeadaCircular;

public class Main {

    public static void main(String[] args) {

        ListaDuplamenteEncadeadaCircular minhaLista = new ListaDuplamenteEncadeadaCircular();

        System.out.println("Lista criada. Tamanho: " + minhaLista.tamanho());

        System.out.println("\nAdicionando elementos...");
        minhaLista.adiciona(10);
        minhaLista.adiciona(20);
        minhaLista.adiciona(30);
        minhaLista.adiciona(1, 15);

        System.out.println("Tamanho após adicionar: " + minhaLista.tamanho());

        System.out.println("Elemento no índice 0: " + minhaLista.get(0).valor);
        System.out.println("Elemento no índice 1: " + minhaLista.get(1).valor);
        System.out.println("Elemento no índice 2: " + minhaLista.get(2).valor);
        System.out.println("Elemento no índice 3: " + minhaLista.get(3).valor);

        NoDuplo noDoMeio = minhaLista.get(1);
        System.out.println("Anterior de " + noDoMeio.valor + ": " + noDoMeio.anterior.valor);
        System.out.println("Próximo de " + noDoMeio.valor + ": " + noDoMeio.proximo.valor);

        System.out.println("\nRemovendo um elemento:");
        boolean removido = minhaLista.remove(1);
        System.out.println("Remoção do índice 1 bem-sucedida? " + removido);
        System.out.println("Tamanho após remoção: " + minhaLista.tamanho());
        System.out.println("Novo elemento no índice 1: " + minhaLista.get(1).valor);

        NoDuplo novoNoDoMeio = minhaLista.get(1);
        System.out.println("Anterior de " + novoNoDoMeio.valor + ": " + novoNoDoMeio.anterior.valor);
        System.out.println("Próximo de " + novoNoDoMeio.valor + ": " + novoNoDoMeio.proximo.valor);

        System.out.println("\nRemovendo o primeiro elemento:");
        minhaLista.remove(0);
        System.out.println("Tamanho após remoção: " + minhaLista.tamanho());
        System.out.println("Novo primeiro elemento: " + minhaLista.get(0).valor);

        NoDuplo primeiroAtual = minhaLista.get(0);
        System.out.println("Anterior do primeiro (" + primeiroAtual.valor + "): " + primeiroAtual.anterior.valor);
        System.out.println("Próximo do primeiro (" + primeiroAtual.valor + "): " + primeiroAtual.proximo.valor);

        System.out.println("\nEsvaziando a lista:");
        minhaLista.remove(0);
        minhaLista.remove(0);
        System.out.println("Tamanho após esvaziar: " + minhaLista.tamanho());
        System.out.println("Primeiro elemento: " + minhaLista.get(0));

        System.out.println("\n--- Fim dos Testes ---");
    }
}