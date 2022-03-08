class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack();
        int n=heights.length,i=0,max=-1;
        while(i<n){
            if(stack.empty() || heights[stack.peek()]<=heights[i]){
                stack.push(i++);
            }
            else{
                int top=stack.pop();
                int area=heights[top]*(stack.empty()?i:i-stack.peek()-1);
                if(max<area){
                    max=area;
                }
            }
        }
        while(!stack.empty()){
            int top=stack.pop();
                int area=heights[top]*(stack.empty()?i:i-stack.peek()-1);
                if(max<area){
                    max=area;
                }
        }
        return max;
    }
}