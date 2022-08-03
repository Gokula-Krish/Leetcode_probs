class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map=new TreeMap();
    }
    
    public boolean book(int start, int end) {
        Integer low=map.floorKey(start);
        Integer high=map.ceilingKey(start);
        if((low==null || (map.get(low)<=start)) && (high==null || (end<=high))){
            map.put(start,end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */