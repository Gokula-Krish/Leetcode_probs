// { Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String input[] = br.readLine().trim().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution g = new Solution();
                Node k = g.lca(root,a,b);
    			System.out.println(k.data);
    	        
	        }
	}
}
// } Driver Code Ends


/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Solution{
    //Function to return the lowest common ancestor in a Binary Tree.
    ArrayList<Node> list1=new ArrayList();
    ArrayList<ArrayList<Node>> ans=new ArrayList();
    public void recurpath(Node root,int p,int q){
        if(root==null){
            return;
        }
        list1.add(root);
        if(root.data==p){
            ans.add(new ArrayList(list1));
        }
        if(root.data==q){
            ans.add(new ArrayList(list1));
        }
        recurpath(root.left,p,q);
        recurpath(root.right,p,q);
        list1.remove(list1.size()-1);
    }
	Node lca(Node root, int n1,int n2){
		// Your code here
		recurpath(root,n1,n2);
        Node anscestor=null;
        int n=Math.min(ans.get(0).size(),ans.get(1).size());
        ArrayList<Node> l1=ans.get(0);
        ArrayList<Node> l2=ans.get(1);
        for(int i=0;i<n;i++){
            if(l1.get(i)==l2.get(i)){
                anscestor=l1.get(i);
            }
            if(l1.get(i)!=l2.get(i)){
                break;
            }
        }
        return anscestor;
	}
}