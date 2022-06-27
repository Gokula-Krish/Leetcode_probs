// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    // Return the size of the largest sub-tree which is also a BST
    static int n;
    static boolean isBst(){
        //System.out.println("Inside IsBST--"+ls);
        for(int i=1;i<ls.size();i++){
            if(ls.get(i-1)>=ls.get(i)){
                return false;
            }
            else{
                continue;
            }
        }
       // System.out.println("After IsBST: "+ls);
        return true;
    }
    static int max=0;
    static void preOrder(Node root){
        if(root==null){
            return;
        }
        ls.clear();
        n=0;
        intoVal(root);
       // System.out.println(ls);
        if(isBst()){
            max=Math.max(max,n);
        }
        preOrder(root.left);
        preOrder(root.right);
    }
    static int largestBst(Node root){
        // Write your code here
        ls.clear();
        n=0;
        max=0;
        preOrder(root);
        return max;
    }
    static ArrayList<Integer> ls=new ArrayList();
    static void intoVal(Node root){
        if(root==null){
            return;
        }
        intoVal(root.left);
        ls.add(root.data);n++;
        intoVal(root.right);
    }
}