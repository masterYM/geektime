package tree;



public class BinaryTree {
    private Node tree;


    //插入操作
    public void insert(int data){
        if(tree == null){
            tree = new Node(data);
            return;
        }
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
