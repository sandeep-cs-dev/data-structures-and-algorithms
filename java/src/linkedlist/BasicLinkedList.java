package linkedlist;

public class BasicLinkedList {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
    Node head;

    public BasicLinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the end of the linked list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        System.out.println("LinkedList: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node deleteKthNodeFromEnd(int k) {
         // dummy node
         Node preHead = new Node(-11111);
         preHead.next=head;
         Node fastPointer = head;
         Node slowPointer = preHead;

         // 1 2  3  4  5 6
        // k= 2

         while (k>0 && fastPointer!=null){
               fastPointer = fastPointer.next;
               k--;
         }
         if(k!=0){
             return head;
         }
         while (fastPointer!=null){
              slowPointer =slowPointer.next;
              fastPointer= fastPointer.next;
          }
          Node tmp = slowPointer.next;
          slowPointer.next = tmp.next;
          tmp.next=null;
          System.out.println(preHead.next);
          head =preHead.next;
          return head;
    }
}

class Main {
    public static void main(String[] args) {
        BasicLinkedList list = new BasicLinkedList();
        for(int i=1;i<=5;i++){
            list.append(i);
        }
        list.deleteKthNodeFromEnd(3);
        list.printList(); // Output: LinkedList: 1 2 3
    }
}

