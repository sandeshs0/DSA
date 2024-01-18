package Graphs;
public class Queue {
    int queue[];
    int front=-1;
    int rear =-1;
    int size;
    // Constructor to create a Queue of given size.
    Queue(int size){
        this.size=size;
        queue=new int[size];
    }
    void enqueue(int data){
     if(isFull()){
        System.out.println("Queue is Full");
     }
     else{
        if(front==-1){
            front=rear=0;
            queue[rear]=data;
        }
        else{
            rear++;
            queue[rear]=data;
        }
     }
    }

    int dequeue(){
        if(isEmpty()){
            System.out.println("The Queue is Empty");
            return -9999;
        }
        if(front == rear){
            int x = queue[front];
            front = rear =-1;
            return queue[x];
        }
        return queue[front++];
    }

    boolean isFull(){
        return size==size-1;
    }

    boolean isEmpty(){
        return front==-1 && rear==-1;
    }


    public static void main(String[] args) {
        Queue q= new Queue(4);
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.dequeue());
    }
}
