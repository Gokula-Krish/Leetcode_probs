// { Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // int arr[] = new int[10000];
        
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]=new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }
            
            solver x = new solver();
            int res[]=x.print_next_greater_freq(arr,n);
            StringBuffer sb=new StringBuffer("");
            for(int i : res){
                sb.append(i+" ");
            }
            System.out.println(sb);
        }
    }
}
// } Driver Code Ends


class solver{
    static int[] print_next_greater_freq(int arr[], int n){
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        HashMap<Integer,Integer> map=new HashMap();
        for(int a:arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        Stack<Integer> stack=new Stack();
        for(int i=0;i<n;i++){
            while(!stack.empty() && map.get(arr[stack.peek()])<map.get(arr[i])){
                ans[stack.peek()]=arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}

