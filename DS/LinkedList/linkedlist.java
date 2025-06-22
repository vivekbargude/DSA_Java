package DS.LinkedList;
// Function : 
// 1.Insert Node at start
// 2.Insert a sublist at particular index
// 3.Display the linkedlist alongwith the sublist
// 4.Length of the linkedlist
// 5.Print the prime nodes
// 6.Delete frequency of elements
// 7.Reverse a linkedlist
// 8.Delete a node without giving head;
// 9.Find the Middle Node 
// 10.Palindrome LinkedList 
// 11.Delete Nodes From Linked List Present in Array
// 12.Delete the Middle Node of a Linked List
// 13.Insert Node in sorted Linked List

import java.util.HashSet;
import java.util.Set;

class Node {
    int data;
    Node next;
    Node sub;  //For nested sublist

    Node(int data) {
        this.data = data;
        this.next = null;
        this.sub = null;
    }
}

class Linkedlist {

    public static void main(String[] args) {
        Node head = new Node(5);
        head = insertNode(head, 3);
        head = insertNode(head, 2);
        head = insertNode(head, 1);
        head = insertNodeSorted(head, 6);
        
        printLL(head);
       // head = deleteDuplicates(head);
        // head = insertNode(head, 7);
        // head = insertNode(head, 8);
        // head = insertNode(head, 9);


      // System.out.println("Length of Linked List: " + getLength(head));

        //head = bubbleSort(head);

       // head = insertSublist(head, 1); 

       // System.out.println("Final Linked List:");
      //  printLL(head);

        //printPrime(head);
        // head = deleteNumberFreq(head, 3, 2);
        // head = reverseLL(head);
        // displayLL(head);

    }

    public static Node insertNode(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    public static Node insertNodeSorted(Node head,int data){
        if(head==null)
        return head;
        Node newNode = new Node(data);

        Node mover=head;
        while(mover.next!=null){
            if(mover==head && data<mover.data){
                newNode.next=head;
                return newNode;
            }
            if(mover.data<=data && data<=mover.next.data){
                newNode.next=mover.next;
                mover.next=newNode;
                return head;
            }

            mover=mover.next;
        }
        mover.next=newNode;
        
        return head;

    }

    public static void printLL(Node head){
        if(head==null){
            System.out.println("Empty LinkedList.");
            return;
        }

        Node mover = head;
        while(mover!=null){
            System.out.print(mover.data+"->");
            mover=mover.next;
        }
        System.out.print("null");
    }

    public static void displayLL(Node head) {
        Node mover = head;
        while (mover != null) {
            System.out.print(mover.data);

            if (mover.sub != null) {
                System.out.print(" [Sublist: ");
                Node temp = mover.sub;
                while (temp != null) {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }
                System.out.print("]");
            }

            System.out.print(" -> ");
            mover = mover.next;
        }
        System.out.println("null");
    }

    public static Node bubbleSort(Node head) {
        if (head == null) {
            System.out.println("LinkedList Empty");
            return head;
        }

        boolean swapped;
        Node ptr;
        Node lptr = null;

        do {
            ptr = head;
            swapped = false;

            while (ptr.next != lptr) {
                if (ptr.data > ptr.next.data) {
                    int temp = ptr.data;
                    ptr.data = ptr.next.data;
                    ptr.next.data = temp;
                    swapped = true;
                }
                ptr = ptr.next;
            }

            lptr = ptr;

        } while (swapped);

        return head;
    }

    public static int getLength(Node head) {
        int len = 0;
        Node mover = head;
        while (mover != null) {
            len++;
            mover = mover.next;
        }
        return len;
    }

    public static Node insertSublist(Node head, int n) {
        if (head == null) {
            System.out.println("Empty LinkedList");
            return head;
        }

        int i = 0;
        Node mover = head;
        while (i < n-1 && mover != null) {
            mover = mover.next;
            i++;
        }

        if (mover == null) {
            System.out.println("Node at position " + n + " does not exist.");
            return head;
        }

        if (mover.sub == null) {
            int base = mover.data;
            Node subHead = new Node(base * 1);
            Node temp = subHead;

            for (int table = 2; table <= 10; table++) {
                Node newNode = new Node(base * table);
                temp.next = newNode;
                temp = newNode;
            }

            mover.sub = subHead;
        }

        return head;
    }

    public static boolean isPrime(int n){
        if(n<=1)
        return false;
        
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i==0)
                return false;
            }

        return true;
    }

    public static void printPrime(Node head){
        if(head==null)
        return;

        System.out.print("Prime Node: ");
        Node mover = head;
        while(mover!=null){
            if(isPrime(mover.data)){
                System.out.print(mover.data+" ");
            }

            if(mover.sub!=null){
                Node temp = mover.sub;
                while(temp!=null){
                    if(isPrime(temp.data)){
                        System.out.print(temp.data+" ");
                    }
                    temp=temp.next;
                }
            }
            mover=mover.next;
        }
    }

    public static Node deleteNumberFreq(Node head, int num, int freq) {
        if (head == null || freq <= 0) {
            return head;
        }
    
        // Handle deletions at the head
        while (head != null && head.data == num && freq > 0) {
            head = head.next;
            freq--;
        }
    
        // If the entire list was deleted from the head
        if (head == null) {
            return null;
        }
    
        // Traverse the rest of the list
        Node current = head;
    
        while (current.next != null) {
            if (current.next.data == num && freq > 0) {
                // Delete the next node
                current.next = current.next.next;
                freq--;
            } else {
                // Move to next node only if no deletion
                current = current.next;
            }
        }
    
        return head;
    }

    public static Node reverseLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
    
        Node prev = null;
        Node curr = head;
    
        while (curr != null) {
            Node nextNode = curr.next;  // Save next node
            curr.next = prev;           // Reverse pointer
            prev = curr;                // Move prev forward
            curr = nextNode;            // Move curr forward
        }
    
        return prev;  // New head
    }

    public Node middleNode(Node head) {
        if(head==null || head.next == null)
        return head;

        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

        public void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node rev = reverseLL(slow.next); // reverse second list
        slow.next = null;
        while(rev != null) {
            if(head.data != rev.data) {
                return false;
            }
            head = head.next;
            rev = rev.next;
        }
        return true;
    }

    public static Node deleteDuplicates(Node head) {
        if(head==null || head.next==null)
        return head;

        if(head.next.next==null){
            if(head.data == head.next.data)
            {
            head.next=head.next.next;
            head.next.next=null;
            return head;
            }
            else 
            return head;
        }

        Node mover = head;
        while(mover!=null && mover.next!=null){
                if(mover.data == mover.next.data && mover.data == mover.next.next.data){
                System.out.println("mover"+mover.data);
                mover.next=mover.next.next.next;
                mover.next.next.next=null;
            }else{      
                System.out.println("mover"+mover.data);
                mover.next=mover.next.next;
                mover.next.next=null;
            
            }
            mover=mover.next;
        }

        return head;

    }

    public Node modifiedList(int[] nums, Node head) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
        set.add(num);

        if(head==null)
        return head;

        while(head!=null && set.contains(head.data))
        head=head.next;

        if(head == null || head.next == null )
        return head;

        Node prev = head;
        Node curr = head.next;

        while(curr!=null){
            while(curr!=null&&set.contains(curr.data)){
                prev.next=curr.next;
                curr=curr.next;
            }

            if(curr!=null)
            curr=curr.next;


            prev=prev.next;
        }

        return head;
    }
    
        public Node deleteMiddle(Node head) {
        if(head==null)
        return head;

        if(head.next==null)
        return null;

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.next=slow.next;

        return head;
    }
    
}