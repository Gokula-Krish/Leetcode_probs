class MapSum {
    HashMap<String,Integer> map;
    public MapSum() {
        map=new HashMap();
    }
    
    public void insert(String key, int val) {
        map.put(key,val);
    }
    
    public int sum(String prefix) {
        int c=0;
        for(Map.Entry m:map.entrySet()){
            if(((String)m.getKey()).startsWith(prefix)){
                c+=(int)m.getValue();
            }
        }
        return c;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */