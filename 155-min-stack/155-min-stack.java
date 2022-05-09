class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MinStack() {
        stack1=new Stack();
        stack2=new Stack();
    }
    
    public void push(int val) {
        stack1.push(val);
        val=Math.min(val,stack2.empty()?val:stack2.peek());
        stack2.push(val);
    }
    
    public void pop() {
        if(stack1.empty()){
            return;
        }
        stack1.pop();
        stack2.pop();
    }
    
    public int top() {
        if(stack1.empty()){
            return -1;
        }
        return stack1.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */