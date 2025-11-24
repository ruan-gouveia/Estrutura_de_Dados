# Estrutura_de_Dados

Este repositório contém implementações em Java de diversas Estruturas de Dados e Algoritmos, desenvolvidos para fins de estudo e aprimoramento em Ciência da Computação.

## Conteúdo do Repositório

Aqui você encontrará implementações de:

### Algoritmos de Ordenação

*   **Bubble Sort:** Um algoritmo de ordenação simples que compara repetidamente pares adjacentes e os troca se estiverem na ordem errada.
*   **Insertion Sort:** Constrói a lista final ordenada um item de cada vez, inserindo cada elemento na sua posição correta na parte já ordenada.
*   **Selection Sort:** Encontra repetidamente o menor elemento da parte não ordenada da lista e o coloca no início da parte ordenada.
*   **Merge Sort (Recursivo):** Um algoritmo de divisão e conquista que divide a lista pela metade recursivamente, ordena as sub-listas e as mescla.
*   **Quick Sort (Recursivo):** Seleciona um "pivô" da lista, particiona os outros elementos em sub-listas (menores e maiores que o pivô) e ordena as sub-listas recursivamente.

### Estruturas de Dados

*   **Lista Encadeada Simples:** Uma estrutura linear de dados onde os elementos não são armazenados em locais de memória contíguos. Cada elemento (nó) contém um valor e uma referência (ponteiro) para o próximo nó da sequência.
*   **Lista Duplamente Encadeada Circular:** Uma variação da lista encadeada onde cada nó tem referências para o nó anterior e para o próximo, e o último nó aponta para o primeiro, formando um ciclo.
*   **Tabela Hash com Encadeamento Separado:** Implementação de uma Tabela Hash que resolve colisões utilizando listas encadeadas (LinkedList) em cada "balde" da tabela.
*   **Tabela Hash com Sondagem Linear:** Implementação de uma Tabela Hash que resolve colisões buscando a próxima posição vazia sequencialmente (sondagem linear) e com capacidade de redimensionamento dinâmico.

## Como Executar

Cada implementação está em seu respectivo pacote e pode ser executada a partir de sua classe `Main` correspondente.

Por exemplo, para testar o Bubble Sort:

```bash
# Navegue até a pasta src/bubbleSort
# Compile o arquivo .java
javac BubbleSort.java
# Execute a classe principal
java BubbleSort