class StockSpanner {
    Stack<int[]> stack=new Stack();
    int k;
    public StockSpanner() {
        k=-1;
    }
    
    public int next(int price) {
        k++;
        while(!stack.empty() && stack.peek()[0]<=price){
            stack.pop();
        }
        int ans=stack.empty()?k+1:(k-stack.peek()[1]);
        stack.push(new int[]{price,k});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */