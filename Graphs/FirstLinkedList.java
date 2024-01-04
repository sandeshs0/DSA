
package Graphs;
public class FirstLinkedList {
    public static class Node {
        int data;
        Node next;
        // Constructor to create a new node of the linked list.
        Node(int d){
            this.data =d;
            this.next=null;
        }
    }
    Node head=null;
    Node tail= null;
    void addNode(int data){
        Node newNode=new Node(data);
        if (head == null) {
            head= newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
            }
            // The following code is to travel in  linkedList to find the last node but it gives O(n). so not so optimal in this case.
    //     Node current = head;
    //     while (current.next != null) {
    //         current=current.next;       
    // }
    // current.next=newNode;
}

void printAllNodes(){
    Node current=head;
    while(current!=null){
        System.out.println(current.data);
        current=current.next;
    }
}
}

// Add a function