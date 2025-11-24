package algoritmosDeOrdenação.bubbleSort;
import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

    public static void main(String[] args) {

        List<Integer> Lista = new ArrayList<>(List.of(5,8,9,14,2,1,7,28,12,4,3));
        System.out.println("BUBBLE SORT");
        System.out.println("Lista original: " + Lista);
        System.out.println("Lista ordenada: " + BubbleSort(Lista));

    }
    public static List<Integer> BubbleSort(List<Integer> l) {

        for (int i = 0; i < l.size(); i ++) {

            for (int j = l.size() - 1; j > i; j-- ) {

                if(l.get(j) < l.get(j-1)) {
                    int guardar = l.get(j-1);
                    l.set(j-1, l.get(j));
                    l.set(j, guardar);
                }
            }
        } return l;
    }
}
