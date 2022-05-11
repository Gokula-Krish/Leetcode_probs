// { Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends


class Solution{
    static HashMap<Integer,Integer> map;
    static int i;
    static Node root;
    public static Node buildTree(Node root,int inorder[], int preorder[],int l,int r){
        if(l>r){
            return null;
        }
        int p=preorder[i];
        root=new Node(p);i++;
        root.left=buildTree(root.left,inorder,preorder,l,map.get(p)-1);
        root.right=buildTree(root.right,inorder,preorder,map.get(p)+1,r);
        return root;
    }
    public static Node buildTree(int inorder[], int preorder[], int n){
        // code here
        i=0;
        root=null;
        map=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return buildTree(root,inorder,preorder,0,n-1);
    }
}
