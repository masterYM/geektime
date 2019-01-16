package tree;



public class BinaryTree {
    private Node tree;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(6);
        binaryTree.insert(4);
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(8);
        binaryTree.insert(9);
        Node n = binaryTree.find(9);
        System.out.println(n.data);
    }

    public void delete(int data){
        Node p = tree;//p 指向要删除的节点，初始化指向根节点
        Node pp = null;//pp记录的是p的父节点
        while ( p != null && p.data != data){
            pp = p;
            if(data > p.data) p = p.right;
            else p = p.left;
        }
        if(p == null) return;//没有找到

        //要删除的节点有两个子节点
        if(p.left != null && p.right != null){
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null){
                minPP = minP;
                minP = minP.left;
            }

            p.data = minP.data;//将minP 的数据替换到 p 中
            p = minP;//下面就变成了删除 minP 了
            pp = minPP;
        }
        //删除节点是叶子节点或者仅有一个子节点
        Node child;//p 的子节点
        if(p.left != null) child = p.left;
        else if(p.right != null) child = p.right;
        else child = null;

        if(pp == null){
            tree = child; //删除的是根节点
        }else if(pp.left == p){
            pp.left = child;
        }else {
            pp.right = child;
        }

    }

    //查找
    public Node find(int data){
        Node p = tree;
        while (p != null){
            if(data < p.data){
                p = p.left;
            }else if(data > p.data){
                p = p.right;
            }else {
                return p;
            }
        }
        return null;
    }
    //插入操作
    public  void insert(int data){
        if(tree == null){
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null){
            if(data > p.data){
                if (p.right == null){
                    p.right = new Node(data);
                    return;
                }
               p = p.right;
            }else {// data < p.data
                if(p.left == null){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
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
