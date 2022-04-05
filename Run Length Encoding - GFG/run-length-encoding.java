// { Driver Code Starts
import java.util.*;
 
class RLEncoding
{
   public static void main(String[] args) 
   {
 
      Scanner sc = new Scanner(System.in);
    
	  int T = sc.nextInt();
	  sc.nextLine();
	  while(T>0)
	  {
		  
		String str = sc.nextLine();
		
		GfG g = new GfG();
		System.out.println(g.encode(str));
		
      
        T--;
	  }
   }
}

// } Driver Code Ends


class GfG
 {
	String encode(String str)
	{
          //Your code here
            int c=0;
          char prev=',';
          String ans="";
          for(int i=0;i<str.length();i++){
              char ch=str.charAt(i);
              if(i==0){
                  c++;
              }
              else if(prev==ch){
                  c++;
              }
              else if(prev!=ch){
                  ans+=prev+String.valueOf(c);
                  c=1;
              }
              prev=ch;
          }
          if(c!=0){
              ans+=prev+String.valueOf(c);
          }
          return ans;
          
	}
	
 }