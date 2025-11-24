package algoritmosDeOrdenaçãoRecursivos.mergeSort;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>(List.of(7, 23, 11, 5, 2, 9, 4, 8, 1, 15));
        System.out.println("MERGE SORT");
        System.out.println("Lista desordenada: " + lista);
        System.out.println("Lista ordenada: " + MergeSort(lista));
    }

    public static List<Integer> MergeSort(List<Integer> lista) {

        if (lista.size() == 1) {
            return lista;
        }

        List<Integer> vetor_l1 = new ArrayList<>(lista.subList(0, lista.size() / 2));
        List<Integer> vetor_l2 = new ArrayList<>(lista.subList(lista.size() / 2, lista.size()));

        vetor_l1 = MergeSort(vetor_l1);
        vetor_l2 = MergeSort((vetor_l2));

        return mesclar(vetor_l1, vetor_l2);

    }

    public static List<Integer> mesclar(List<Integer> lista1, List<Integer> lista2)  {

        List<Integer> lista3 = new ArrayList<>();

        while (!lista1.isEmpty() && !lista2.isEmpty()){
            if (lista1.get(0) > lista2.get(0)) {
                lista3.add(lista2.get(0));
                lista2.remove(0);
            }
            else {
                lista3.add(lista1.get(0));
                lista1.remove((0));
            }
        }

        while (!lista1.isEmpty()) {
            lista3.add(lista1.get(0));
            lista1.remove((0));
        }

        while (!lista2.isEmpty()) {
            lista3.add(lista2.get(0));
            lista2.remove(0);
        }

        return lista3;
    }
}