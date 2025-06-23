package DS.Tree;
//Functions involved:
//1.Pre-ordered traversal
//2.In-order traversal
//3.Post-order traversal


class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
    }
}
class Tree{
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        preOrderTraversal(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);

    }

    public static void preOrderTraversal(Node root){
        if(root==null)
        return;

        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(Node root){
        if(root==null)
        return;

        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root){
        if(root==null)
        return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }
}