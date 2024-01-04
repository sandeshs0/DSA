public class StackUsingArray{
    int stack[];
    int top=-1;
    int size;

    StackUsingArray(int size){
        stack= new int[size];
        this.size=size;
    }
    void push(int data){
        if(isFull()){
            System.out.println("Stack bhariyo");
        }
        else{
            top++;
            stack[top]=data;
        }
        
    }
    boolean isFull(){
        return top==size-1;
    }
    boolean isKhali(){
        return false;
    }  
    int pop(){
        if (isEmpty()) {
            System.out.println("Stack Khali xa");
            return -1;
        }
        int popped= stack[top];
        top--;
        return popped;

    }
    boolean isEmpty(){
        return top==-1;
    }

    int peek(){
        return stack[top];
    }

public static void main(String[] args) {
    

    StackUsingArray myStack = new StackUsingArray(5);
    myStack.push(90);
    myStack.push(80);
    myStack.push(70);
    myStack.push(60);
    myStack.push(50);
    // myStack.push(50);
   System.out.println( myStack.peek());
   System.out.println( myStack.pop());
}
}                                          


