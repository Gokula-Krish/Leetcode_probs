// { Driver Code Starts
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
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    System.out.print("()");
		    ArrayList <ArrayList<Integer>> res = new solve().AllSubsets(arr,n);
		    for (int i = 0; i < res.size (); i++)
		    {
		        System.out.print ("(");
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		            if (j != res.get(i).size()-1)
		                System.out.print ((res.get(i)).get(j) + " ");
		            else
		                System.out.print ((res.get(i)).get(j));
		        }
		        System.out.print (")");
		      
		    }
		    System.out.println();
		}
	}
}// } Driver Code Ends


class solve{
    static ArrayList<ArrayList<Integer>> ans;
    static Set<ArrayList<Integer>> set;
    //Function to find all possible unique subsets.
    public static ArrayList <ArrayList<Integer>> AllSubsets(int arr[], int n){
        // your code here
        ans=new ArrayList();
        set=new HashSet();
        Arrays.sort(arr);
        recurse(arr,0,new ArrayList<Integer>(),n);
        ans.addAll(set);
        Collections.sort(ans,(a,b)->{
            String s1="",s2="";
            for(int i:a){
                s1+=String.valueOf(i);
            }
            for(int i:b){
                s2+=String.valueOf(i);
            }
            return s1.compareTo(s2);
        });
        ans.remove(0);
        return ans;
    }
    public static void recurse(int[] arr,int i,ArrayList<Integer> ls,int n){
        if(i==n){
            set.add(new ArrayList(ls));
            return;
        }
        ls.add(arr[i]);
        recurse(arr,i+1,ls,n);
        ls.remove(ls.size()-1);
        recurse(arr,i+1,ls,n);
    }
}
