// { Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}
// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG{
    HashMap<Integer,Integer> map=new HashMap();
    public Node buildTree(Node root,int[] in,int[] post,int l,int r,int pl,int pr){
        if(l>r){
            return null;
        }
        int p=post[pr];
        root=new Node(p);
        root.left=buildTree(root.left,in,post,l,map.get(p)-1,pl,pl+map.get(p)-1-l);
        root.right=buildTree(root.right,in,post,map.get(p)+1,r,pl+map.get(p)-l,pr-1);
        return root;
    }
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n){
        // Your code here
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return buildTree(null,in,post,0,in.length-1,0,post.length-1);
    }
}
