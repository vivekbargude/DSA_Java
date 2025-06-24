package DS.Tree;

import java.util.*;

//Functions involved:
//1.Pre-ordered traversal (Recursion)
//2.In-order traversal (Recursion)
//3.Post-order traversal (Recursion)
//4.Level-order traversal (Using Queue)
//5.Pre-order traversal (Iterative using Stack)
//6.In-order traversal (Iterative using Stack)


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
        // preOrderTraversal(root);
        // System.out.println();
        // inOrderTraversal(root);
        // System.out.println();
        // postOrderTraversal(root);

        // List<List<Integer>> list = levelOrderTraversal(root);
        // printLevelOrder(list);

        printList(iterativeInOrder(root));

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

    public static List<List<Integer>> levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root==null)
        return list;

        queue.offer(root);
        while(!queue.isEmpty()){
            int numElements = queue.size();
            List<Integer> sublist = new LinkedList<>();
            for(int i=0;i<numElements;i++){
                if(queue.peek().left!=null)
                queue.offer(queue.peek().left);
                if(queue.peek().right!=null)
                queue.offer(queue.peek().right);
                sublist.add(queue.poll().data);
            }
            list.add(sublist);
        }

        return list;
        
    }

    public static void printLevelOrder(List<List<Integer>> list){
        if(list==null){
            System.out.println("Empty Tree.");
            return;
        }
        for (List<Integer> innerList : list) {
            for (Integer num : innerList) {
                System.out.print(num + " ");
            }
            System.out.println(); 
        }
    }

    public static List<Integer> iterativePreOrder(Node root){
        List<Integer> preorder = new ArrayList<>();
        if(root==null)
        return preorder;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            Node newRoot = st.pop();

            if(newRoot.right!=null)
            st.push(newRoot.right); // forst insert right

            if(newRoot.left!=null)
            st.push(newRoot.left);  //then left

            preorder.add(newRoot.data);
        }

        return preorder;
    }

    public static void printList(List<Integer> list){
        if(list==null)
       {
         System.out.println("Empty List");
         return;
       }

       for(Integer num: list){
        System.out.print(num+" ");
       }
    }

    public static List<Integer> iterativeInOrder(Node root){
        List<Integer> inorder = new ArrayList<>();
        if(root==null)
        return inorder;

        Stack<Node> st = new Stack<>();
        Node node = root;

        while(true){
            if(node!=null){
                st.push(node);
                node=node.left;
            }else{
                if(st.isEmpty())
                break;

                node = st.pop();
                inorder.add(node.data);
                node = node.right;
            }
        }
        return inorder;
    }
}