package business;

import entities.Node;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int count;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        count = 0;
    }

    public void addToStart(int data) {

        Node tempNode = new Node(data);

        if (checkIfHeadAndTailNull()) {
            head = tempNode;
            tail = tempNode;
        } else {
            tempNode.setNext(head);
            head = tempNode;

        }
        count++;

    }

    public int removeFirstElement() {
        if (checkIfHeadAndTailNull()) {
            System.out.println("List is empty");
            return -1;
        }

        int data = head.getData();
        if (head.getNext() == null) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();

        }
        count--;
        return data;

    }

    public int getFirstElement() {
        if (checkIfHeadAndTailNull()) {
            System.out.println("List is empty");
            return -1;
        }

        return head.getData();
    }


    public int getSize(){
        return count - 1;
    }

    public boolean isEmpty(){
        return checkIfHeadAndTailNull();
    }

    public int[] getAllData(){

        int[] data = new int[count];
        Node tempHead = head;
        for (int i = 0; i < count ; i++) {

            int tempData = tempHead.getData();
            data[i] = tempData;
            tempHead = tempHead.getNext();

        }
        return data;
    }

    private boolean checkIfHeadAndTailNull() {
        return head == null && tail == null;
    }

}
