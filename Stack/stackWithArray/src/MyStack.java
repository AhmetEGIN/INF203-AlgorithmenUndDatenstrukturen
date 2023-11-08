import java.util.Arrays;

public class MyStack {
    private final static int INITIAL_CAPACITY = 10;
    private int[] array;
    private int count;


    public MyStack(int capacity) {
        this.array = new int[capacity];
        count = 0;
    }

    public MyStack() {
        this(INITIAL_CAPACITY);
    }


//    TODO: void push(int item) -> Element wird oben eingefügt.                     DONE
//    TODO: int pop()           -> Element oben wird zurückgegeben und gelöscht     DONE
//    TODO: int top()           -> Element oben wird zurückgegeben.                 DONE
//    TODO: int size()          -> Anzahl der Elemente wird zurückgegeben           DONE
//    TODO: boolean isEmpty()   -> true falls keine Elemente vorhanden sind.        DONE

    public void push(int item) {

        if (checkIsArrayFull()) {
            increaseCapacityOfArray();
        }

        array[count++] = item;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Array is empty");
            return -1;
        }

        return array[--count];

    }

    public int top() {
        if (isEmpty()) {
            System.out.println("Array is empty");
            return -1;
        }

        return array[count - 1];

    }

    public int size() {
        return count;
    }


    public boolean isEmpty() {
        return count == 0;
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("Array is empty");
        }

        Arrays.stream(array, 0, count).forEach(System.out::println);

    }

    private boolean checkIsArrayFull() {
        return count == array.length;
    }

    private void increaseCapacityOfArray() {
        int[] newArray = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];

        }

        array = newArray;

    }


}
