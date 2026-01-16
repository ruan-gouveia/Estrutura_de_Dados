package arvoreB;

public class Main {
    public static void main(String[] args) {
        ArvoreB arvore = new ArvoreB();

        int[] valores = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        System.out.println("=== Inserindo Valores ===");
        for (int v : valores) {
            System.out.println("Inserindo: " + v);
            arvore.inserir(v);
        }

        System.out.println("\n=== Percorrendo em Ordem ===");
        arvore.percorrerEmOrdem();

        System.out.println("\n=== Estrutura da Árvore (Níveis) ===");
        arvore.imprimirEstrutura();

        System.out.println("\n=== Teste de Busca ===");
        System.out.println("Busca 20 (Existe): " + arvore.buscar(20));
        System.out.println("Busca 99 (Não existe): " + arvore.buscar(99));
    }
}