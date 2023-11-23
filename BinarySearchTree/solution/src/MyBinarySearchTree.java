public class MyBinarySearchTree {

    private Node root;

    public MyBinarySearchTree(int value) {
        this.root = new Node(value);
    }

    public MyBinarySearchTree() {
    }

    private static class Node {

        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }


    }


    public void add(int value) {
        this.root = add(root, value);

    }

    public boolean contains(int value) {
        return contains(this.root, value);
    }

    private boolean contains(Node current, int value) {

        if (current == null) {
            return false;
        }
        else if(current.value == value){
            return true;
        }

        if (value > current.value){
            return contains(current.right, value);
        }
        else {
            return contains(current.left, value);
        }
//        if (contains(current.right, value)) return true;
//        else if (contains(current.left, value)) return true;
//        else return false;
    }

    private Node add(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = add(current.left, value);

        } else {
            current.right = add(current.right, value);
        }

        return current;

    }


}
