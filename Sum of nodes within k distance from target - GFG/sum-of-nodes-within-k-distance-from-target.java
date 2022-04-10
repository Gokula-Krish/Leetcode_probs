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
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int target = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            solver x = new solver();
            System.out.println( x.sum_at_distK(root, target, k) );
            t--;
        }
    }
}

// } Driver Code Ends


/*
// node structure:

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

*/

class solver{
    static Node tar=null;
    static HashMap<Node,Node> mapParent(Node root,int t){
        HashMap<Node,Node> map=new HashMap();
        Queue<Node> q=new LinkedList();
        q.add(root);
        map.put(root,null);
        while(!q.isEmpty()){
            Node c=q.poll();
            if(c.data==t){
                tar=c;
            }
            if(c.left!=null){
                q.add(c.left);
                map.put(c.left,c);
            }
            if(c.right!=null){
                q.add(c.right);
                map.put(c.right,c);
            }
        }
        return map;
    }
    static int sum_at_distK(Node root, int target, int k){
        // code here
        tar=null;
        if(k==0){
             return target; 
        }
        HashMap<Node,Node> map=mapParent(root,target);
        HashSet<Node> set=new HashSet();
        set.add(tar);
        Queue<Node> q=new LinkedList();
        q.add(tar);
        int level=0;
        int sum=0;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Node c=q.poll();
                Node node=map.get(c);
                if(node!=null && !set.contains(node)){
                    q.add(node);
                    set.add(node);
                }
                if(c.left!=null && !set.contains(c.left)){
                    q.add(c.left);
                    set.add(c.left);
                }
                if(c.right!=null && !set.contains(c.right)){
                    q.add(c.right);
                    set.add(c.right);
                }
            }
            level++;
            if(level<=k){
                for(Node n1:q){
                    sum+=n1.data;
                }
                if(level==k){
                    break;
                }
            }
        }
        return sum+target;
    }
}

