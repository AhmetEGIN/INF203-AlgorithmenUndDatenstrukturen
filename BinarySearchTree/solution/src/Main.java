public class Main {
    public static void main(String[] args) {

        MyBinarySearchTree tree = new MyBinarySearchTree();

        tree.add(4);
        tree.add(8);
        tree.add(1);
        tree.add(13);
        tree.add(-2);


        System.out.println(tree.contains(-2));


    }
}