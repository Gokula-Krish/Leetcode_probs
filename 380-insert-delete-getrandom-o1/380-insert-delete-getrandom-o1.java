class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer,Integer> map;
    public RandomizedSet() {
        list=new ArrayList();
        map=new HashMap();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            list.add(val);
            map.put(val,list.size()-1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){    
            int in=map.get(val);
            int lastIn=list.size()-1;
            if(in==lastIn){
                list.remove(lastIn);
                map.remove(val);
            }
            else{
                int last=list.get(lastIn);
                list.set(in,last);
                map.put(last,in);
                list.remove(lastIn);
                map.remove(val);
            }
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        if(list.isEmpty()){
            return -1;
        }
        int rand=(int)(Math.random()*(list.size()));
        return list.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */