package LinkedList;

class Node{
    int data;
    Node next;

    Node(int data){
    this.data = data;
    this.next = null;
    }

    Node(int data , Node next){
        this.data = data;
        this.next = next;
    }
}

class Link_list{
    public static void main(String[] args) {
        int[] arr = {10,20,23,44};
        Node head = convertArr2LL(arr);
        printLL(head);
        
    }

    private static Node convertArr2LL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1 ; i < arr.length ; i++){
            Node newNode = new Node(arr[i]);
            mover.next = newNode;
            mover = mover.next;
        }

        return head;
    }

    private static void printLL(Node head){
        Node mover = head;
        while(mover!=null){
            System.out.print(mover.data+" ");
            mover = mover.next;
        }
    }


}

