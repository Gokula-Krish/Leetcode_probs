// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    ArrayList<Integer> A = new ArrayList<Integer>();
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        A.add(arr[i]);
		        
		    }
		   
		   
		    
		    ArrayList <ArrayList<Integer>> res = new Solution().subsets(A);
		    for (int i = 0; i < res.size (); i++)
		    {
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		          System.out.print(res.get(i).get(j)+" ");
		        }
		        System.out.println();
		      
		    }
		    //System.out.println();
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> ans=new ArrayList();
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A){
        //code here
        ans.clear();
        recursion(A,new ArrayList(),0);
        Collections.sort(ans,new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> l1,ArrayList<Integer> l2){
                int n=Math.min(l1.size(),l2.size());
                for(int i=0;i<n;i++){
                    if(l1.get(i)==l2.get(i)){
                        continue;
                    }
                    else{
                        return Integer.compare(l1.get(i),l2.get(i));
                    }
                }
                return Integer.compare(l1.size(),l2.size());
            }
        });
        return ans;
    }
    public static void recursion(ArrayList<Integer> A,ArrayList<Integer> ds,int i){
        if(i>=A.size()){
            ans.add(new ArrayList(ds));
            return;
        }
        ds.add(A.get(i));
        recursion(A,ds,i+1);
        ds.remove(ds.size()-1);
        recursion(A,ds,i+1);
    }
}