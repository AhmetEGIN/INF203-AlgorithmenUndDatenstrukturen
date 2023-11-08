import business.MyStack;

public class Main {
    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        System.out.println(myStack.isEmpty());
        myStack.pop();

        myStack.push(10);
        myStack.push(11);
        myStack.push(12);
        System.out.println(myStack.pop());
        myStack.push(13);
        System.out.println(myStack.top());
        System.out.println("----------");
        myStack.printAllData();


    }
}