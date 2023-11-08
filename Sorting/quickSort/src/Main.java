import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        Sıralama Algoritmaları - Quick Sort

//        Avarage Case' de biraz daha avantajlıdır.

    /*

            1  7  9  3  2  -> Bu array' de en küçük eleman olması gereken yerde
            9  1  6  12 4  -> Bu array' de orta eleman olması gereken yerde
            4  5  2  0  9  -> Bu array' de en büyük eleman olması gereken yerde

            pivot - partition  -> Bu iki kelime Quick Sort' ta büyük anlama sahip
            Array' in içerisinde sıralı bir tane bulup kalanları seçtiğimiz elemanın etrafında dizeceğiz
            Örneğin yukarıda ikinci array örneğinde 6 elemanını seçelim
            ve 6'nın sağ tarafında büyük elemanlar, sol tarafında küçük elemanlar olacak
            Bu seçtiğimiz sayılara pivot denir. -> Yukarıdaki örneklerde 1, 6 ve 9 pivot elemanıdır.

            Verimli bir algoritma istiyorsak pivot olarak tam ortadaki elemanı seçmek olur.
            Partition' un amacı seçtiğimiz pivot' u doğru yerine koymaktır. Pivottan küçükleri sola, büyükleri sağa koymaktır

            Bu işlemi yaptıktan sonra sol taraftaki elemanları kendi aralarında sıralayacağız, aynı şekilde
            sağ taraftaki elemanları kendi aralarında sıralayacağız. Partition işlemini uygulayacağız


              Partition için iki tane şema bulunmakta:

                   ## Hoare  ##
            Dizi içerisindeki ilk elemanı pivot olarak seçiyoruz.
            Bu olayda bizim iki tane değişkenimiz olacak. Bir tanesi dizinin başından diğeri dizinin sonundan
            pivot' un yerini bulmaya çalışacak.
            4   1   7   2
            Burada pivot 4 olarak seçilir. i değişkenimiz listenin başında, j değişkenimiz listenin sonunda bulunmakta
            i değişkenimiz pivot' tan büyük veya eşit olanlarını bulana kadar ilerleyecek.
            j değişkenimiz ise pivot' tan küçük olanları bulana kadar ilerleyecek.
            daha sonra bu iki verinin yerini değiştiriyoruz
            bu iki değişken birbirine erişene kadar devam edecekler.

            4   1   7   2           2   1   7   4        2  1   7   4       2   1   7   4
            i           j     ->    i           j    ->     i       j   ->          i   j

                2   1   7   4
            ->      j   i
            Yukarıdaki örnekte j, i' nin yanından geçti. Bu durumda i' nin olduğu yer pivot' un olduğu yerdir.

            ->    2    1    4   7      ==> Böylelikle pivot kendi yerini buldu.
            Hoare' nin metoduna göre pivot noktasını da dahil edip sol tarafı yine aynı işleme sokmalıyız
            Benzer şekilde sağ tarafı da yine aynı işleme sokmalıyız.

            İkinci şemamız ise:
                    ## Lomuto  ##
            Burda da partition işlemi değişiyor.
            Burada bir değişken (i) -1 den başlıyor, j ise 0. index' ten başlıyor
            Dizinin en sonundaki eleman pivot olarak seçiliyor.
            i değişkeni bizim en son nerede değişiklik yaptığımız yeri gösterecek,
            j ise dizi üzerinde gezerek elemanları pivot değeri ile karşılaştıracak.
            j nin olduğu eleman pivot' tan küçük veya eşitse bir yer değiştirme işlemi uygulanacak.
            i' nin değerini 1 artırdıktan sonra bu yer değiştirme işlemi i ve j. eleman arasında olacak.
            j pivot' a kadar geldiğinde döngü bitmiş oluyor ve i' nin bir fazlası pivot' un yeridir.
            yani pivot ile i+1 in yerini değiştirdiğimizde pivot olması gereken yere gidiyor
            bu partition işlemlerinin sonunda pivot' un sağ tarafı ve sol tarafını yine rekürsif bir şekilde
            partition işlemlerine sokuyoruz.


            Time Complexity -> Worst Case -> O(n^2)
                            -> Best Case  -> O(logn)
            Space Complexity -> O(1)

    */

//        int[] numbers = {5, 2, 7, 9, 1, 0, 6, 3, 4};
        int[] numbers = {4,1,7,2};
//        quickSortHoare(numbers, 0, numbers.length - 1);
        quickSortLomuto(numbers, 0, numbers.length - 1);
        Arrays.stream(numbers).forEach(System.out::println);



    }

    public static void quickSortHoare(int[] array, int low, int high) {
//        ## Hoare ##
//        low ve high parametreleri dizinin kaçıncı elemanından kaçıncı elemanına kadar sıralayacağımızı belirtir

        if (low < high) {

            int partitionIndex = partitionHoare(array, low, high);

            quickSortHoare(array, low, partitionIndex);
            quickSortHoare(array, partitionIndex+1, high);

        }

    }

    private static int partitionHoare(int[] array, int low, int high){

        int pivot = array[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;

            }while (array[i] < pivot);
            do {
                j--;

            }while (array[j] > pivot);
            if (i >= j) {
                return j;
            }
            swap(array, i, j);

        }

    }


    public static void quickSortLomuto(int[] array, int low, int high) {


        if (low < high) {
            int partitionIndex = partitionLomuto(array, low, high);

            quickSortLomuto(array, low, partitionIndex - 1);
            quickSortLomuto(array, partitionIndex+1, high);

        }

    }

    private static int partitionLomuto(int[] array, int low, int high) {

        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j<high; j++) {

            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }

        }
        swap(array, i + 1, high);

        return i + 1;

    }


    private static void swap(int[] array, int i, int j){

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

}