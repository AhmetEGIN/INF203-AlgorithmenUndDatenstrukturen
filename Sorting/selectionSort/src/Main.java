import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        Sıralama Algoritmaları - Selection Sort (Seçerek Sıralama)


        int[] numbers = {5, 2, 7, 9, 1, 0, 6, 3, 4};
        selectionSort(numbers);
        Arrays.stream(numbers).forEach(System.out::println);

    }

    public static void selectionSort(int[] array) {

//        küçük olanı başa alarak devam edeceğiz

//        Time Complexity  -> O(n^2)
//        Space Complexity -> O(1)

        for (int i = 0; i < array.length; i++) {

            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {

                swap(array, i, minIndex);
            }

        }

    }

    private static void swap(int[] array, int a, int b) {
        // buradaki a ve b yerleri değiştirilecek index' leri belirtir.
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

    }


}