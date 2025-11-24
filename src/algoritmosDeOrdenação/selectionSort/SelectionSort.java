package algoritmosDeOrdenação.selectionSort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    public static List<Integer> SelectionSort(List<Integer> l) {
        int n = l.size();

        for (int i = 0; i < n - 1; i++) {

            int indiceDoMenor = i;

            for (int j = i + 1; j < n; j++) {

                if (l.get(j) < l.get(indiceDoMenor)) {
                    indiceDoMenor = j;
                }
            }

            if (indiceDoMenor != i) {

                int guardar = l.get(i);
                l.set(i, l.get(indiceDoMenor));
                l.set(indiceDoMenor, guardar);
            }
        }
        return l;
    }

    public static void main(String[] args) {

        List<Integer> minhaLista = new ArrayList<>(List.of(5, 8, 9, 14, 2, 1, 7, 28, 12, 4, 3));

        System.out.println("SELECTION SORT");

        System.out.println("Lista original: " + minhaLista);

        List<Integer> listaOrdenada = SelectionSort(minhaLista);

        System.out.println("Lista ordenada: " + listaOrdenada);
    }
}