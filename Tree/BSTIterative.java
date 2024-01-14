package Tree;

public class BSTIterative {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    // 
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

    // Now createBST in Iterative approach
//     Node createBST(Node root, int data){
//         Node n = new Node(data);
//         if (root == null) {
//             return n;
//             }
//             Node current = root;
//             while (true) {
//                 if (data < current.data) {
//                     if (current.left == null) {
//                         current.left = n;
//                         break;
//                     }
//                     current = current.left;

//     }
// }




// }

}
