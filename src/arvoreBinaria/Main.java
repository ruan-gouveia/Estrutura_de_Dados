package arvoreBinaria;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        System.out.println("=== 1. Inserindo Valores ===");
        //       50
        //      /  \
        //    30    70
        //   / \    / \
        //  20 40  60 80

        int[] valores = {50, 30, 20, 40, 70, 60, 80};
        for (int v : valores) {
            System.out.print("Inserindo: " + v + " | ");
            arvore.inserir(v);
        }
        System.out.println("\n\n--- Verificando inserção com Em-Ordem ---");
        arvore.percorrerEmOrdem();

        System.out.println("\n=== 2. Testando os 3 Percursos ===");

        arvore.percorrerPreOrdem();

        arvore.percorrerEmOrdem();

        arvore.percorrerPosOrdem();

        System.out.println("\n=== 3. Testando Busca ===");

        int valorExiste = 40;
        int valorNaoExiste = 99;

        boolean achou40 = arvore.buscar(valorExiste);
        System.out.println("Buscando " + valorExiste + " (Esperado: true) -> " + achou40);

        boolean achou99 = arvore.buscar(valorNaoExiste);
        System.out.println("Buscando " + valorNaoExiste + " (Esperado: false) -> " + achou99);

        System.out.println("\n=== 4. Testando Remoção ===");

        System.out.println("\n-> Removendo nó folha (20)...");
        arvore.remover(20);
        arvore.percorrerEmOrdem();

        System.out.println("\n-> Removendo nó com 1 filho (30)...");
        arvore.remover(30);
        arvore.percorrerEmOrdem();

        System.out.println("\n-> Removendo nó com 2 filhos (70)...");
        arvore.remover(70);
        arvore.percorrerEmOrdem();

        System.out.println("\n-> Removendo a Raiz (50)...");
        arvore.remover(50);
        arvore.percorrerEmOrdem();

        System.out.println("\nTeste Finalizado.");
    }
}