package Graphs;



// Sparsh Graph uses Adjacendy List. Dense Graph uses  Adjancey Matrix. Why is that so?
// In Sparse graph, the number of edges are much less than the total nodes. Hence it is more efficient to use Adjacency list
public class AdjList {
    int v;
    FirstLinkedList list[];

    AdjList(int v){
        this.v = v;
        list= new FirstLinkedList[v];
        for (int i=0; i<v; i++){
            list[i]=new FirstLinkedList();

        }
    }

    public void BFS(int rootnode){
        Queue q=new Queue(v);
        boolean [] visisted=new boolean[v];
        q.enqueue(rootnode);
        visisted[rootnode]=true;
        while(!q.isEmpty()){
            int x=q.dequeue();
            System.out.println(x);
        FirstLinkedList.Node current= list[x].head;
        while(current != null) {
            if(!visisted[current.data]){
                q.enqueue(current.data);
                visisted[current.data]=true;
            }
            current = current.next;
        }
        }
    }



    void addEdge(int source, int destination){
        list[source].addNode(destination);
        list[destination].addNode(source);
    }
    void printGraph(){
        System.out.println("Adjancency List Representation");
        for (int i=0; i < v ; i++) {
            System.out.print(i + " is connected to ");
        FirstLinkedList.Node current= list[i].head;
        while(current != null) {
            System.out.print(current.data+" , ");
            current = current.next;
        }
        System.out.println();
    }
}
// Yo afai gar
//  List<Integer> getAdjNodes(int node){
//         List<Integer> adjnodes= new ArrayList<>();


//     }
public static void main(String[] args) {
    AdjList g1 = new AdjList(5); // Create a graph with 5 vertices
    g1.addEdge(0, 2);   // Add an undirected edge from vertex 0 to vertex 2
    g1.addEdge(1, 3);   // Add an undirected edge from vertex 1 to vertex 3
    g1.addEdge(4, 0);   // Add an undirected edge from vertex 4 to vertex 0 
}
}