// { Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
        }
    }
}
// } Driver Code Ends


// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    int h1=0,h2=0,h3=0;boolean avis=false,bvis=false,cvis=false;
    public void preOrder(Node root,int a,int b,int c,int level){
        if(root==null){
            return;
        }
        if(!avis && root.data==a){
            avis=true;
            h1=level;
        }
        if(!bvis && root.data==b){
            bvis=true;
            h2=level;
        }
        if(!cvis && root.data==c){
            cvis=true;
            h3=level;
        }
        preOrder(root.left,a,b,c,level+1);
        preOrder(root.right,a,b,c,level+1);
    }
    int findDist(Node root, int a, int b) {
        // Your code 
        Node l=LCA(root,a,b);
        preOrder(root,a,b,l.data,0);
        return h1+h2-(2*h3);
    }
    Node LCA(Node root,int a,int b){
        if(root==null){
            return root;
        }
        if(root.data==a || root.data==b){
            return root;
        }
        Node left=LCA(root.left,a,b);
        Node right=LCA(root.right,a,b);
        if(left!=null && right!=null){
            return root;
        }
        return left!=null?left:right;
    }
}