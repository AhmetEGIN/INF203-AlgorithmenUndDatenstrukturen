package business;

import java.util.Arrays;

public class MyStack {

    private final MyLinkedList myLinkedList;


//    TODO: void push(int item) -> Element wird oben eingefügt.                     DONE
//    TODO: int pop()           -> Element oben wird zurückgegeben und gelöscht     DONE
//    TODO: int top()           -> Element oben wird zurückgegeben.                 DONE
//    TODO: int size()          -> Anzahl der Elemente wird zurückgegeben           DONE
//    TODO: boolean isEmpty()   -> true falls keine Elemente vorhanden sind.        DONE

    public MyStack() {
        this.myLinkedList = new MyLinkedList();
    }


    public void push(int item) {
        myLinkedList.addToStart(item);

    }

    public int pop(){
        return myLinkedList.removeFirstElement();
    }

    public int top() {
        return myLinkedList.getFirstElement();
    }

    public int size() {
        return myLinkedList.getSize();
    }

    public boolean isEmpty(){
        return myLinkedList.isEmpty();
    }
    public void printAllData(){
        Arrays.stream(
                myLinkedList.getAllData(),
                0,
                size() + 1
        )
                .forEach(System.out::println);
    }

}
