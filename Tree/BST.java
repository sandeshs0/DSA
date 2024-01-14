package Tree;

public class BST {
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
        
    }
    Node createBST(Node root, int data){
        if(root==null){
            return new Node(data);
        }
        if(data<root.data){
            root.left=createBST(root.left, data);
        }
        else if(data>root.data){
            root.right=createBST(root.right, data);
        }
        
        return root;
    }

    void inOrder(Node root){
        if(root==null)return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    Node deleteNode(Node root, int data){
        if(root==null){
            return null;
        }
         if(data<root.data){
            root.left=deleteNode(root.left,data);
        }
        else if(data>root.data){
            root.right=deleteNode(root.right, data);

        }
        // root
        else{
            if (root.left==null) {
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                root.data=findMin(root.right);
                root.right=deleteNode(root.right, root.data);
            }
        }
        return root;
    }

    int findMin(Node node){
        int min=node.data;
        while(node.left!=null){
            node=node.left;
            min=node.data;
        }
        return min;
    }

    public static void main(String[] args) {
        BST t= new BST();
        Node root = t.createBST(null, 50);
        root= t.createBST(root,20);
        root= t.createBST(root,40);
        root= t.createBST(root,70);
        root= t.createBST(root,90);
        root= t.createBST(root,30);
        System.out.print("Inorder traversal of the constructed tree is: ");
        t.inOrder(root);
    }
    
}
// AVL
// - BST tree
// Balance factors {1,0,-1}
// Self Balancing Binary Search Tree
// Balance Factor ma parena vane chai its Skewed BST


