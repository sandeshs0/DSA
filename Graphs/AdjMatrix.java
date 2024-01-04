package Graphs;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AdjMatrix {
    int graph[][];
    int v;
    AdjMatrix(int v){
        this.v=v;
        graph= new int[v][v];
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
