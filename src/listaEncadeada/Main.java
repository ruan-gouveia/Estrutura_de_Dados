package listaEncadeada;

public class Main {

    public static void main(String[] args) {

        ListaEncadeada minhaLista = new ListaEncadeada();

        System.out.println("Lista criada. Tamanho: " + minhaLista.tamanho());
        System.out.println("Adiconando Elementos...");

        minhaLista.adiciona(10);
        minhaLista.adiciona(20);
        minhaLista.adiciona(30);
        minhaLista.add(1, 15);

        System.out.println("Tamanho após adicionar: " + minhaLista.tamanho());
        System.out.println("Elemento no índice 0: " + minhaLista.get(0).valor);
        System.out.println("Elemento no índice 1: " + minhaLista.get(1).valor);
        System.out.println("Elemento no índice 2: " + minhaLista.get(2).valor);
        System.out.println("Elemento no índice 3: " + minhaLista.get(3).valor);

        int valorRemovido = minhaLista.remove(1);
        System.out.println("Valor removido do índice 1: " + valorRemovido);
        System.out.println("Tamanho após remoção: " + minhaLista.tamanho());
        System.out.println("Novo elemento no índice 1: " + minhaLista.get(1).valor);
    }
}