// { Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			insertion llist = new insertion(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		head = ob.insertionSort(llist.head);
		llist.printList(head);
		
        t--;		
        }
    }}// } Driver Code Ends


//User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution{
    static Node sorted;
    public static Node insertionSort(Node head_ref){
        //code here
        Node c=head_ref;
        sorted=null;
        while(c!=null){
            Node next=c.next;
            sortIt(c);
          //  System.out.println("Sorted: "+sorted.data);
            c=next;
        }
        head_ref=sorted;
        return head_ref;
    }
    public static void sortIt(Node newN){
        if(sorted==null || newN.data<=sorted.data){
            //if(sorted!=null)
              //  System.out.println(newN.data+"---->"+sorted.data);
           // System.out.println(newN.data);
            newN.next=sorted;
            sorted=newN;
           // System.out.println("Sorted: "+sorted.data);
        }
        else{
            Node c=sorted;
            Node prev=null;
            while(c!=null && c.data<newN.data){
                prev=c;
                c=c.next;
            }
           // System.out.println(prev.data+"---->"+c.data);
            prev.next=newN;
            newN.next=c;
        }
    }
}