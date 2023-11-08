import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        Sıralama Algoritmaları - Bubble Sort (Baloncuk Sıralaması)
//        örneğin elimizdeki bir array' in elemanlarını bir for döngüsü içerisinde dönüyoruz
//        döngü içerisinde her işlem artı bir İŞ demek. ZAMAN (TİME COMPLEXİTY)
//        Heap bölümünde yaratılan objeler için -> ALAN (SPACE COMPLEXITY)

        int[] numbers = {5, 2, 7, 9, 1, 0, 6, 3, 4};
//        yukarıdaki array' i bubble sort ile sıralama:
//        Elamanlar iki iki birbirleriyle karşılaştırılır
//        Örneğin 5 ve 2 karşılaştırılır 5 büyük olduğu için 2 ile yer değiştirir
//        Daha sonra 5 ve 7 karşılaştırılır 7, 5 ten büyük olduğu için sağ tarafta kalması gerekir
//        bu şekilde döngünün sonuna kadar gidilir.
//        Döngünün sonuna ilk gittiğimizde array' in en büyük elemanı döngünün sonuna ulaşmış olur


        bubbleSort(numbers);
        Arrays.stream(numbers).forEach(System.out::println);
    }

    public static  void bubbleSort(int[] array) {

//        Space Complexity -> O(1)
//        Time Complexity -> O(n^2)

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j+1);
//                    Collections.swap(array, array[j], array[j+1]); // ArrayList kullanıyor olsaydık böyle yapabilirdik

                }
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