package leetcode.linkedlist;

class Node {
    int val;

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    Node next;
    Node() {}Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }
}

class ReverseLinkedList {

     public Node reverseList(Node head){
        Node curr = head;
        Node prv= null;
        while(curr!=null){
            Node next = curr.next;
            curr.next = prv;
            prv =curr;
            curr = next;
        }
        return prv;
    }
}
class ReverseLinkedListTest {
    public static  void  main (String ...args){
        Node start = new Node(1);
        Node tmp = start;
        tmp.next = new Node(2);
        tmp.next.next= new Node(3);
        tmp.next.next.next= new Node(4);
        Node newHead = new ReverseLinkedList().reverseList(start);
        System.out.println(newHead.val);
        System.out.println(newHead.next);
    }
}