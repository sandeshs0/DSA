package Graphs;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AdjMatrixMST {

    public static class  Edge implements Comparable<Edge>{
        int s;
        int d;
        int w;
        Edge(int s, int d, int w){
            this.s=s;
            this.d=d;
            this.w=w;
        }
        @Override
        public int compareTo(Edge o) {
            return this.w-o.w;
        }
    }

    
    int graph[][];
    int v;
    Edge edges[];

    AdjMatrixMST(int v){
        this.v=v;
        graph= new int[v][v];
        edges= new Edge[v*(v-1)/2];
    }

    void addEdge(int source, int destination){ // if it was a weighted graph, we would take a w parameter and set that in place of 1.
        graph[source][destination]=1;
        graph[destination][source]=1;
    }
    void printGraph(){ // prints the connected nodes
        for(int i=0; i<v;i++){ //travelling to each rows
            System.out.print(i +" is connected to ");
            for (int j=0; j<v;j++){ //travelling to each columns
                if(graph[i][j]!=0){
                    System.out.print( j + ", ");
                }
            }
            System.out.println();

        }
    }

    List<Integer> getAdjNodes(int node){
        List<Integer> adjnodes= new ArrayList<>();

        for(int i=0; i<v; i++){
            if(graph[node][i]!=0){
                adjnodes.add(i);
            }
        }
        return adjnodes;
    }

    void dfs(int rootnode, boolean [] visisted){
        visisted[rootnode]=true;
        System.out.println(rootnode);
        for(int i=0;i<v;i++){
            if(graph[rootnode][i]!=0){
                if(!visisted[i]){
                    dfs(i, visisted);
                }
            }
        }
    }
//iterative approach
    void dfs2(int rootnode){
        boolean visisted[]= new boolean[v];
        Stack<Integer> stk=new Stack<>();
        stk.push(rootnode);
        while (!stk.isEmpty()) {
            int x=stk.peek();
            stk.pop();
            if(!visisted[x]){
                System.out.println(x);
                visisted[x]=true;
            }

        for(int i=0;i<v;i++){
            if(graph[x][i]!=0){
                if(!visisted[i]){
                    stk.push(i);
                }
            }
        }


        }


    }

    void dfsHelper(int rootnode){
        boolean visisted[]= new boolean[v];
        dfs(rootnode, visisted);

    }

    public void BFS(int rootnode){
        Queue q=new Queue(v);
        boolean [] visisted=new boolean[v];
        q.enqueue(rootnode);
        visisted[rootnode]=true;
        while(!q.isEmpty()){
            int x=q.dequeue();
            System.out.println(x);
            for(int i=0;i<v;i++){
                if(graph[x][i]!=0){
                if(!visisted[i]){
                    q.enqueue(i);
                    visisted[i]=true;
                }
                }
            }
        }
    }

    // Topological Sorting.
    // Here, graph is not a parameter because the graph is a global vairable in this case. However, in other 
    // usecases we might have to ask for it. For instance in the exam
    void TopologicalSort(){
       int indegree [] =new int [v]; //To store the indegrees of all nodes. initially set to 0.
       Queue q= new Queue(v); //The Queue that stores vertices with indegree 0.
       for(int i=0;i<v;i++){ //Moving in the Graph
        for(int j=0; i<v; j++){
            if(graph[i][j] != 0){ //if the vet
                indegree[j]+=1;
            }

        }
       }

       for(int i=0; i<v;i++){
        if(indegree[i]==0){
            q.enqueue(i);
        }
       }
       while (!q.isEmpty()) {
        int x=q.dequeue();
        System.out.println("Executed Task: "+x);
        for(int j=0;j<v;j++){
            if(graph[x][j]!=0){
                indegree[j]--;
                if(indegree[j]==0){
                    q.enqueue(j);
                }
            }
        }
       }
    }

    public static void main(String[] args) {
        AdjMatrix g =new AdjMatrix(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.printGraph();
        System.out.println(g.getAdjNodes(4));
    }
}
