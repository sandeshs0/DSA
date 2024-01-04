import java.util.Stack;

public class UsingStack {
    Stack<Integer> stack1= new Stack<>();
    Stack<Integer> stack2= new Stack<>();

    void enqueue(int data){
        stack1.push(data);
    }
    int dequeue(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int x= stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
    }
    return x;
}
public static void main(String[] args) {
    UsingStack queue= new UsingStack();
    queue.enqueue(15);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);
    queue.enqueue(50);
    System.out.println(queue.dequeue());
}

}

