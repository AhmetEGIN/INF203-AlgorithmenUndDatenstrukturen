import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        Sıralama Algoritmaları - Insertion Sort (Ekleyerek Sıralama)


        int[] numbers = {5, 2, 7, 9, 1, 0, 6, 3, 4};
//      Burada bir elemanı kaydırarak ilerleyeceğiz

        insertionSort(numbers);
        Arrays.stream(numbers).forEach(System.out::println);
    }


    public static void insertionSort(int[] array) {

//        Time Complexity -> O(n^2)
//        Space Complexity -> O(1)

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
//            1. index teki değeri karşılaştırma elemanı olarak kullanacağız
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = key;

        }


    }

}