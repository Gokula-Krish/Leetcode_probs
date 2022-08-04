class NumArray {
    int[] segment;
    int n;
     public void build(int ind,int l,int r,int[] nums){
        if(l==r){
            segment[ind]=nums[l];
            return;
        }
        int mid=(l+r)/2;
        build(2*ind+1,l,mid,nums);
        build(2*ind+2,mid+1,r,nums);
        segment[ind]=segment[2*ind+1]+segment[2*ind+2];   
    }
    
    public NumArray(int[] nums) {
        n=nums.length;
        segment=new int[2*1000000];
        build(0,0,n-1,nums);
    }
    
    public int rangeQuery(int ind,int l,int h,int left,int right){
        if(l>=left && h<=right){
            return segment[ind];
        }
        if(h<left || l>right){
            return 0;
        }
        int mid=(l+h)/2;
        int left1=rangeQuery(2*ind+1,l,mid,left,right);
        int right1=rangeQuery(2*ind+2,mid+1,h,left,right);
        return left1+right1;
    }
    
    public int sumRange(int left, int right) {
        return rangeQuery(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */