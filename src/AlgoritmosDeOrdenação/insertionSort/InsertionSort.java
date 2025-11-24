package AlgoritmosDeOrdenação.insertionSort;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {

    public static List<Integer> InsertionSort(List<Integer> l) {
        int n = l.size();

        for (int i = 1; i < n; i++) {
            int chave = l.get(i);
            int j = i - 1;

            while (j >= 0 && l.get(j) > chave) {
                l.set(j + 1, l.get(j));
                j = j - 1;
            }
            l.set(j + 1, chave);
        }
        return l;
    }

    public static void main(String[] args) {
        List<Integer> minhaLista = new ArrayList<>(List.of(5, 8, 9, 14, 2, 1, 7, 28, 12, 4, 3));

        System.out.println("INSERTION SORT");

        System.out.println("Lista original: " + minhaLista);

        List<Integer> listaOrdenada = InsertionSort(minhaLista);

        System.out.println("Lista ordenada: " + listaOrdenada);
    }
}