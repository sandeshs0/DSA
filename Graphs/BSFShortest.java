package Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BSFShortest {

    private int graph[][];
    private int v;

    BSFShortest(int v) {
        this.v = v;
        graph = new int[v][v];
    }

    void addEdge(int source, int destination, int weight) {
        graph[source][destination] = weight;
        graph[destination][source] = weight;
    }

    void printGraph() {
        for (int i = 0; i < v; i++) {
            System.out.print(i + " is connected to ");
            for (int j = 0; j < v; j++) {
                if (graph[i][j] != 0) {
                    System.out.print(j + ", ");
                }
            }
            System.out.println();
        }
    }

    List<Integer> getAdjNodes(int i) {
        List<Integer> adjList = new ArrayList<>();
        for (int j = 0; j < v; j++) {
            if (graph[i][j] != 0) {
                adjList.add(j);
            }
        }
        return adjList;
    }

    void BFS(int rootNode) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        visited[rootNode] = true;
        queue.offer(rootNode);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : getAdjNodes(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    int dijakstra(int source,int destination){
        int distance[]=new int[v];
        int prevpath[]= new int[v];
        boolean visited[]= new boolean[v];

        for(int i=0; i<0; i++){
            distance[i]= Integer.MAX_VALUE;
            prevpath[i]=-1;
        }
        distance[source]=0;
        
        for(int i=0; i<v; i++){
            int u=findMinVertex(distance,visited);
            visited[u]=true;
            for(int j = 0; j<v; j++){
                if(graph[u][j]!=0){
                    if(!visited[j] && distance[u]+graph[u][j]<distance[j]){
                        distance[j]=distance[u]+graph[u][j];
                        prevpath[j]=u;
                    }
                }
            }
        }
        // Path Print garne:
        Stack<Integer> stk= new Stack<>();
        int current=destination;
        stk.push(destination);
        while (prevpath[current]!=-1) {
            current=prevpath[current];
            stk.push(current);

        }

        
        System.out.println("Shortest Path:");
        for(int i=0; i<stk.size();i++){
            System.out.println(stk.pop());
        }

        return distance[destination];
    }

    int findMinVertex(int[] distance, boolean[] visited){
        int minVertex=-1;
        for(int i=0; i<v; i++){
        if(distance[i]!=Integer.MAX_VALUE && (minVertex==-1 && !visited[i]) || (distance[i]<distance[minVertex] && !visited[i])){
            minVertex=i;
        }
        }
        return minVertex;
    }

    int shortDistFindBFS(int source, int destination) {
        int[] dist = new int[v];
        int[] prevPath = new int[v];
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
            prevPath[i] = -1;
        }

        dist[source] = 0;
        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int neighbor : getAdjNodes(x)) {
                if (!visited[neighbor] && dist[x] + 1 < dist[neighbor]) {
                    dist[neighbor] = dist[x] + 1;
                    prevPath[neighbor] = x;
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        // Print path (optional)
        System.out.print("Shortest path from " + source + " to " + destination + ": ");
        printShortestPath(prevPath, source, destination);
        System.out.println();

        return dist[destination];
    }

    private void printShortestPath(int[] prevPath, int source, int destination) {
        if (destination == -1 || source == destination) {
            System.out.print(destination + " ");
            return;
        }
        printShortestPath(prevPath, source, prevPath[destination]);
        System.out.print(destination + " ");
    }

    public static void main(String[] args) {
        BSFShortest adj = new BSFShortest(5);

        adj.addEdge(0, 1,5);
        adj.addEdge(0, 2,2);
        adj.addEdge(1, 3,4);
        adj.addEdge(1, 5,100);
        adj.addEdge(3, 5,2);
        adj.addEdge(5, 4,15);
        adj.addEdge(2, 3,2);
        adj.addEdge(2, 4,10);
        adj.printGraph();

        System.out.println("BFS traversal:");
        adj.BFS(0);

        int shortestDistance = adj.shortDistFindBFS(0, 4);
        System.out.println("Shortest distance: " + shortestDistance);
    }
}