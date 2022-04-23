class MyHashSet {
    int[] set=new int[(int)1e6+1];
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        set[key]=1;
    }
    
    public void remove(int key) {
        set[key]=0;
    }
    
    public boolean contains(int key) {
        return set[key]==1?true:false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */