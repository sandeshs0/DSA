package Tree;
public class AVL {
    public static class Node{
        int height=1;
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
        Node createBST(Node root, int data){
            if(root==null){
                return new Node(data);
            }
            if (data<root.data) {
                root.left= createBST(root.left,data);
            }
            else if(data>root.data){
                root.right=createBST(root.right,data);

            }
            else{
                return root;
            }
            root.height=1+Math.max(getHeight(root.left),getHeight(root.right));


            int balanceFactor=getBalanceFactor(root);
            if(balanceFactor>1 && data<root.left.data){
                // LL
                return rightRotation(root);
            }
            if(balanceFactor>1 && data>root.left.data){
                // LR
                root.left=leftRotation(root.left);
                return rightRotation(root);
            }
            if(balanceFactor<-1 && data>root.right.data){
                // RR
                return leftRotation(root);
            }
            if(balanceFactor<-1 && data<root.right.data){
                // RL
            }

            return root;
        }

        Node rightRotation(Node y){
            Node x= y.left;
            Node t2=x.right;
            x.right=y;
            y.left=t2;
            y.height=1+Math.max(getHeight(y.left), getHeight(y.right));
            x.height=1+Math.max(getHeight(x.left), getHeight(x.right));
            return x;
        }
    
        int getBalanceFactor(Node node){
            if(node==null){
                return 0;
            }
            return getHeight(node.left)-getHeight(node.right);
        }

        Node leftRotation(Node x){
            Node y= x.right;
            Node t2=y.left;
            y.left=x;
            x.right=t2;
            x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
            y.height=1+ Math.max(getHeight(y.right), getHeight(y.left));
            return y;
        }

    int getHeight(Node node){
        if(node==null){
            return 0;
        }
        return node.height;
    }
}
}
