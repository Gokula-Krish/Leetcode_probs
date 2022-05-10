// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Node{
    int val;
    Node left,right;
    Node(int val){
        this.val=val;
        left=right=null;
    }
}
class Solution{
    Node root=null;
    public Node buildTree(Node root,int[] nums,int l,int r){
        if(l>r){
            return null;
        }
        int mid=l+(r-l)/2;
        root=new Node(nums[mid]);
        root.left=buildTree(root.left,nums,l,mid-1);
        root.right=buildTree(root.right,nums,mid+1,r);
        return root;
    }
    int k=0;int[] ans;
    public void preOrder(Node root){
        if(root==null){
            return;
        }
       // System.out.println(root.val);
        ans[k++]=root.val;
        preOrder(root.left);
        preOrder(root.right);
    }
    public int[] sortedArrayToBST(int[] nums){
        // Code here 
        root=buildTree(null,nums,0,nums.length-1);
        ans=new int[nums.length];
        preOrder(root);
        return ans;
    }
}