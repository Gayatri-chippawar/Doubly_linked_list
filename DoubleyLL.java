package Linked_List;

public class DoubleyLL {
    public static class Node{
        int data ;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail =newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void  addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void removeFirst(){
        if(head == null){
            System.out.println("Cant remove list is empty");
        }
        else if(head.next==null){
            head = null;
            tail = null;
        }
        else{
            Node temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        size--;
    }

    public void removeLast(){
        if(head==null){
            System.out.println("Cant remove list is empty");
        }
        else{
            Node temp = tail.prev;
            temp.next = null;
            tail.prev = null;
            tail = temp;
        }
        size--;
    }

    public  void printList(){//O(n)
        if(head == null){
            System.out.println("null");
            return;
        }
        Node temp = head;

        while (temp!=null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void getReverse(){
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoubleyLL dll = new DoubleyLL();
        dll.addFirst(30);
        dll.addFirst(20);
        dll.addFirst(10);
        dll.addLast(40);
        dll.removeLast();
        dll.removeFirst();
        dll.getReverse();
        dll.printList();
    }
}
