// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}

class LinkedList
{
    static  Node head;  
    static  Node lastNode;
    
    public static void addToTheLast(Node node)
    {

        if (head == null)
        {
            head = node;
            lastNode = node;
        }
        else
        {
            Node temp = head;
            lastNode.next = node;
            lastNode = node;
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc=  new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n, K;
            n = sc.nextInt();
            K = sc.nextInt();
            
            Node head = null;
            int val = sc.nextInt();
            head = new Node(val);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                val = sc.nextInt();
                addToTheLast(new Node(val));
            }
            
            Node before[] = new Node[n];
            addressstore(before, head);
            GFG obj = new GFG();
            
            head = obj.swapkthnode(head, n, K);
        
           Node after[] = new Node[n];
          addressstore(after, head);
        
        if(check(before, after, n, K) == true)
            System.out.println("1");
        else
            System.out.println("0");
        
        }
    }
    
    static boolean check(Node before[], Node after[], int num, int K)
    {
          if(K > num)
           return true;
           
           return (before[K-1] == after[num - K]) && (before[num-K] == after[K-1]);
              
       
    }
    
    static void addressstore(Node arr[], Node head)
  {
      Node temp = head;
      int i = 0;
      while(temp != null){
        arr[i] = temp;
        i++;
        temp = temp.next;
    }
}
    
}// } Driver Code Ends
//User function Template for Java
/* Linked List Node class
   class Node {
     int data;
     Node next;
     Node(int data){
         this.data = data;
         next = null;
     }
  }
*/
class GFG{
    //Function to swap Kth node from beginning and end in a linked list.
    Node swapkthnode(Node head, int num, int K){
        // your code here
        if(K>num){
            return head;
        }
        if(K==num){
            K=1;
        }
        Node h=head,front=null,back=null;
        int c=1,end=num-K+1;
        if(K==1){
            front=head;
        }
        while(h!=null){
            if(c==K-1){
                front=h;
            }
            if(c==end-1){
                back=h;
            }
            c++;
            h=h.next;
        }
        if(K==1){
            Node n1=front.next;
            Node n2=back.next;
            Node n3=n2.next;
            back.next=front;
            front.next=n3;
            n2.next=n1;
            head=n2;
            return head;
        }
        Node a0=front,b0=back,a1=a0.next,a2=a1.next,b1=b0.next,b2=b1.next;
        if(a1.next==b1){
            a0.next=b1;
            b1.next=a1;
            a1.next=b2;
            return head;
        }
        else if(b1.next==a1){
            b0.next=a1;
            a1.next=b1;
            b1.next=a2;
            return head;
        }
        a0.next=b1;
        b1.next=a2;
        b0.next=a1;
        a1.next=b2;
        return head;
    }
}