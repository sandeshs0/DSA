import java.util.HashMap;

public class LRUCaching {
    public static class  Node {
        Node previous;
        Node next;
        int key;
        int value;
        Node(int key, int value){
            this.key=key;
            this.value = value;
            this.next=this.previous=null;
        }

    }
//   5 week haina yo
    int capacity;
    HashMap <Integer,Node> map;
    LRUCaching(int capacity){
        this.capacity=capacity;
        map= new HashMap<>();
    }
    void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            } 
        else if(capacity==map.size()){
                remove(tail);
            }
        Node newNode= new Node(key,value);
        insert(newNode);
        }
        Node head=null;
        Node tail=null;
        void insert(Node newNode){
            map.put(newNode.key, newNode);
            if(head==null){
                head=tail=newNode;
            }
            else{
                newNode.next=head;
                head.previous=newNode;
                head=newNode;
            }
        }
        public int get(int key){
            Node node=map.get(key);
            if(node==null){
                return -1;
            }
            remove(node);
            insert(node);
            return node.value;
        }

        void remove(Node node){
            if(node==head){
            head.next.previous=node;
            Node temp= node.next;
            head.next= null;
            head=temp;
            }
            else if(node==tail){
                tail=tail.previous;
                tail.next.previous=null;
                tail.next=null;
            }
            else{
            
            }
        }


public static void main(String[] args) {
    LRUCaching lru=new LRUCaching(2);
    lru.put(1,10);
    lru.put(2,20);
    lru.put(3,30);
    System.out.println(lru.get(2));
    lru.put(4,40);
    System.out.println(lru.get(1));
    System.out.println(lru.get(3));
    System.out.println(lru.get(4));
}

}
