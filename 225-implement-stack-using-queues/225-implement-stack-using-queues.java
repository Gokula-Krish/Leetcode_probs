class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1=new LinkedList();
        q2=new LinkedList();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        while(q1.size()>1){
            q2.add(q1.poll());
        }
        int d=q1.poll();
        Queue<Integer> temp=new LinkedList();
        temp=q1;
        q1=q2;
        q2=temp;
        return d;
    }
    
    public int top() {
        if(empty()){
            return -1;
        }
        int ans=0;
        for(int i:q1){
            ans=i;
        }
        return ans;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */