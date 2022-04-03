// { Driver Code Starts
//Initial Template for C

#include<stdio.h>





 // } Driver Code Ends
//User function Template for C

// ar[] is the array 
// n is the number of elements in array.
void print(int ar[], int n)
{
    
    // code here
    
    int i;
    for(i=0;i<n;i=i+2){
        printf("%d ",ar[i]);
    }
    
}

// { Driver Code Starts.
int main()
{
   int t;
   scanf("%d", &t);
  while(t--)
   {
     int ar[100001]={0};
     int n;
     scanf("%d", &n);
     for(int i=0;i<n;i++)
      scanf("%d", &ar[i]);
      print(ar,n);
      printf("\n");
     }

return 0;
}  // } Driver Code Ends