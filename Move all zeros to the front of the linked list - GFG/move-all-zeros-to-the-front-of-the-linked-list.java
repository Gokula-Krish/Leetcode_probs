// { Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
class Zeroes{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Node head=null;
            while(n-->0){
                int a=sc.nextInt();
                if(head==null){
                    head=new Node(a);
                }
                else{
                    Node temp=new Node(a);
                    temp.next=head;
                    head=temp;
                }
            }
            GfG g=new GfG();
            head = g.moveZeroes(head);
            while(head!=null){
                System.out.print(head.data+" ");
                head=head.next;
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
*/

class GfG{
     public Node moveZeroes(Node head){
        //Your Code here.
        Node zeros=null,nonzeros=null,zh=null,nZH=null;
        Node h=head;
       // System.out.println("HELLOOOOOO");
        while(h!=null){
          //  System.out.println(h.data);
            if(h.data==0){
                if(zeros==null){
                    zeros=h;
                    zh=h;
                }
                else{
                    zeros.next=h;
                    zeros=zeros.next;
                }
            }
            else{
                if(nonzeros==null){
                    nonzeros=h;nZH=h;
                }
                else{
                    nonzeros.next=h;
                    nonzeros=nonzeros.next;
                }
            }
            h=h.next;
        }
        if(zeros==null){
            nonzeros.next=null;
            return nZH;
        }
        if(nonzeros==null){
            zeros.next=nZH;
            return zh;
        }
        zeros.next=nZH;
        nonzeros.next=null;
        return zh;
    }
}