// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.partition(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node partition(Node node, int x) {
        // Your code here
        if(node==null){
            return node;
        }
        Node dum1=new Node(-11111),dum2=new Node(-11111),dum3=new Node(-11111);
        Node t1=dum1,t2=dum2,t3=dum3;
        Node h=node;
        while(h!=null){
            if(h.data<x){
                t1.next=new Node(h.data);
                t1=t1.next;
            }
            else if(h.data>x){
                t2.next=new Node(h.data);
                t2=t2.next;
            }
            else if(h.data==x){
                t3.next=new Node(h.data);
                t3=t3.next;
            }
            h=h.next;
        }
        t1.next=dum3.next;
        if(t1.next==null){
            t1.next=dum2.next;
            return dum1.next;
        }
        t3.next=dum2.next;
        return dum1.next;
    }
}