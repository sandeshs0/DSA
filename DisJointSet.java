public class DisJointSet {//merging 2 trees into 1 and reducing the searching time complexity by making one set root the parent of another set.
    int parent[];
    int size[];
    int vertices;
    DisJointSet(int vertices){
        this.vertices=vertices;
        parent=new int[vertices];
        size=new int[vertices];
        for(int i=0;i<vertices;i++){
            parent[i]=-1;//initially everyone has the same parent of -1.
        }
    }
    void isCycleDetected(int u, int v){//giving source(u) and destination(v).
        int uabsoluteroot=find(u);
        int vabsoluteroot=find(v);
        if(uabsoluteroot==vabsoluteroot){
            System.out.println("cycle detected");//if the absolute root of the source and destination are the same then it means that a cycle exists
            return;
        }
        union(uabsoluteroot,vabsoluteroot);//calling the union method
    }
    int find(int c){//to find the absoulte root of an element
        if (parent[c]==-1){//the given child is the absoulte root of itself
            return c;
        }
        return parent[c]=find(parent[c]);//recursiveley calling the find method to find the absoulte parent
        //we also do path compression in the above line as we are also changing the parent of each element to the absoulte parent.
    }
    void union(int uabsoluteroot,int vabsoluteroot){
        if(size[uabsoluteroot]>size[vabsoluteroot]){
            parent[vabsoluteroot]=uabsoluteroot;
        }
        else if(size[uabsoluteroot]<size[vabsoluteroot]){
            parent[uabsoluteroot]=vabsoluteroot;
        }
        else{
            parent[vabsoluteroot]=uabsoluteroot;
            size[uabsoluteroot]++;
        }
    }
    public static void main(String[] args) {
        DisJointSet s= new DisJointSet(4);
        s.isCycleDetected(0, 1);
        s.isCycleDetected(0, 2);
        s.isCycleDetected(0, 3);
        s.isCycleDetected(0, 3);
    }
}