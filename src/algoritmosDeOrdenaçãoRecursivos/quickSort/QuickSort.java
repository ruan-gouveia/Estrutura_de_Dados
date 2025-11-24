package algoritmosDeOrdenaçãoRecursivos.quickSort;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>(List.of(7, 23, 11, 5, 2, 9, 4, 8, 1, 15));
        System.out.println("QUICK SORT");
        System.out.println("Lista desordenada: " + lista);
        System.out.println("Lista ordenada: " + QuickSort(lista));
    }

    public static List<Integer> QuickSort(List<Integer> lista) {
        if (lista.size() <= 1) {
            return lista;
        }

        Random random = new Random();
        int indicePivo = random.nextInt(lista.size());
        int pivo = lista.get(indicePivo);

        List<Integer> menores = new ArrayList<>();
        List<Integer> iguais = new ArrayList<>();
        List<Integer> maiores = new ArrayList<>();

        for (Integer elemento : lista) {
            if (elemento < pivo) {
                menores.add(elemento);
            } else if (elemento == pivo) {
                iguais.add(elemento);
            } else {
                maiores.add(elemento);
            }
        }

        List<Integer> menoresOrdenados = QuickSort(menores);
        List<Integer> maioresOrdenados = QuickSort(maiores);
        List<Integer> resultado = new ArrayList<>();
        resultado.addAll(menoresOrdenados);
        resultado.addAll(iguais);
        resultado.addAll(maioresOrdenados);

        return resultado;
    }
}