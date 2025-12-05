package arvoreAVL;

public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        System.out.println("=== Teste AVL: Inserção ===");

        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30);

        arvore.percorrerEmOrdem();
        arvore.imprimirRaiz();

        System.out.println("\n=== Inserindo mais valores ===");
        arvore.inserir(40);
        arvore.inserir(50);

        arvore.percorrerEmOrdem();
        arvore.imprimirRaiz();

        System.out.println("\n=== Inserindo valor menor ===");
        arvore.inserir(5);
        arvore.percorrerEmOrdem();

        System.out.println("\n=== Removendo Nó ===");
        arvore.remover(30);

        arvore.percorrerEmOrdem();
        arvore.imprimirRaiz();
    }
}