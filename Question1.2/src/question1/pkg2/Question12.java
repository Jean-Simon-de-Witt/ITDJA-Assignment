package question1.pkg2;
import java.util.ArrayList;
public class Question12 {
    // Merge two arrays
    public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> c = new ArrayList<>();

        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.get(0) > b.get(0)) {
                c.add(b.get(0));
                b.remove(0);
            }
            else {
                c.add(a.get(0));
                a.remove(0);
            }
        }

        while (!a.isEmpty()) {
            c.add(a.get(0));
            a.remove(0);
        }

        while (!b.isEmpty()) {
            c.add(b.get(0));
            b.remove(0);
        }
        return c;
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> a) {
        if (a.size() == 1) {
            return a;
        }
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        int i = 0;

        while (i < a.size() / 2) {
            array1.add(a.get(i));
            i++;
        }

        while (i < a.size()) {
            array2.add(a.get(i));
            i++;
        }

        array1 = mergeSort(array1);
        array2 = mergeSort(array2);

        return merge(array1, array2);
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();

        array.add(4);
        array.add(2);
        array.add(6);
        array.add(5);
        array.add(3);
        array.add(9);

        System.out.println("Unsorted Array:");
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + "\n");
        }

        System.out.println("\nSorted Array:");
        ArrayList<Integer> sortedArray = mergeSort(array);
        for (int i = 0; i < sortedArray.size(); i++) {
            System.out.print(sortedArray.get(i) + "\n");
        }
    }
}
