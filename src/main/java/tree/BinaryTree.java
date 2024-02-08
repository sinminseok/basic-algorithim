package tree;

public class BinaryTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node n4 = tree.makeNode(null, null, 4);
        Node n5 = tree.makeNode(null, null, 5);
        Node n2 = tree.makeNode(n4, n5, 4);
        Node n3 = tree.makeNode(null, null, 3);
        Node n1 = tree.makeNode(n2,n3,1);
        tree.setRoot(n1);

        tree.postOrder(tree.getRoot());
    }
}

class Node{
    int data;
    Node left;
    Node right;
}

class Tree{
    private Node root;

    public void setRoot(Node node){
        this.root = node;
    }

    public Node getRoot(){
        return root;
    }

    public Node makeNode(Node left, Node right, int data){
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }

    public void inorder(Node node){
        if(node != null){
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }

    public void preOrder(Node node){
        if(node != null){
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

}
